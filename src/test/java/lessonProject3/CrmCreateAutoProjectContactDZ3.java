package lessonProject3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmCreateAutoProjectContactDZ3 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriverWait webDriverWait;

    @BeforeSuite
//выполняется один раз перед всеми тестами
    void setupDataBase() {
        System.out.println("Before suit setup database");
    }

    @BeforeTest
//выполняется один раз перед всеми тестами и после @BeforeSuite если он есть
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(LOGIN_PAGE_URL);
        login();
    }

    @Test
    void crmTestCase2Contact() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        //глобально ждем везде 10 секунд, но надо не больше 3 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Ассерт (утверждение) проверка на наличии плашки "панели инструментов" после авторизации
        List<WebElement> panelInsrumentov = driver.findElements(
                By.xpath("//ul[@class='breadcrumb']//child::li[1]"));//составили xpath для названия Панели инструментов

        //проверка на наличии плашки "панели инструментов" после авторизации
        assertThat(panelInsrumentov.get(0).getText(), containsString("Панели инструментов"));
        //     assertThat(panelInsrumentov.get(0), hasText("ВЛАДЕЛЕЦ"));
        assertThat(panelInsrumentov.get(0), isDisplayed());

        //навели мышку на элемент Контрагенты и кликнули Контактные лица
        Actions actions = new Actions(driver);
        WebElement projectMenuItemContr = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(projectMenuItemContr).perform();
        driver.findElement(By.xpath("//li[@data-route='crm_contact_index']/a")).click();

        //проверка на наличии плашки "Контактные лица" после перехода в них
        WebElement contact = driver.findElement(By.xpath("//li[text()='Контактные лица']"));
        assertThat(contact.getText(), containsString("Контактные лица"));
        //Thread.sleep(5000);

        //пишем правильное ожидание через класс WebdriverWait
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']"));

        //нажимаем на кнопку Создать контактное лицо
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        //проверка на наличии плашки "Основная информация" после нажатия на кнопку Создать контактное лицо
        WebElement CreateContact = driver.findElement(By.xpath("//a[text()='Основная информация']"));
        assertThat(CreateContact.getText(), containsString("Основная информация"));

        //заполняем поле Фамилия
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Иванов4");

        //заполняем поле Имя
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Иван4");

        //заполняем поле Имя
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Тестировщик4");

        //заполняем поле Организация
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Christiansen, Ferry and Trantow");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/contact/create
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        //пишем правильное ожидание через класс WebdriverWait
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
        //     Thread.sleep(10000);

        //проверка на наличии плашки "Контактное лицо сохранено" после нажатия на клавишу Сохранить и закрыть
        WebElement saveProject = driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
        assertThat(saveProject.getText(), containsString("Контактное лицо сохранено"));

        //закрываем браузер
        // driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @AfterMethod
        //чтобы после каждого теста закрывался браузер
    void closeBrowser() {
        driver.quit();
    }
}
