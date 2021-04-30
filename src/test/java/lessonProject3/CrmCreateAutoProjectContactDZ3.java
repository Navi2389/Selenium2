package lessonProject3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmCreateAutoProjectContactDZ3 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL="https://crm.geekbrains.space/user/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //глобально ждем везде 10 секунд, но надо не больше 3 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login();

        //навели мышку на элемент Проекты и кликнули Мои проекты
        Actions actions=new Actions(driver);
        WebElement projectMenuItemContr= driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(projectMenuItemContr).perform();
        driver.findElement(By.xpath("//li[@data-route='crm_contact_index']/a")).click();
        //нажимаем на кнопку Создать контактное лицо
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
        //заполняем поле Фамилия
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Иванов3");
        //заполняем поле Имя
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Иван3");
        //заполняем поле Имя
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Тестировщик3");
        //заполняем поле Организация
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Christiansen, Ferry and Trantow");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/contact/create
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        //пишем правильное ожидание через класс WebdriverWait
        WebDriverWait webDriverWait=new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
        Thread.sleep(10000);

        //закрываем браузер
        driver.quit();
    }
    private static void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
