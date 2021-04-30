package lessonProject3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmCreateAutoProjectDiaryLoginDZ3 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL="https://diary.ru/user/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //глобально ждем везде 10 секунд, но надо не больше 3 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login();

        //закрываем браузер
        driver.quit();
    }
    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        //добавили авторизацию на сайте с помощью Cookies
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "b1bhr7ntffq9fleqsdf0h2bm1k");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(50000);
//       driver.close();
        //обычная авторизация с помощью кнопок на сайте
//        driver.findElement(By.id("loginform-username")).sendKeys("TestIvan1");
//        driver.findElement(By.id("loginform-password")).sendKeys("TestIvan1");
//        //работа с айфреймом
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'reCAPTCHA')]")));
//        driver.findElement(By.xpath("//body")).click();
//        //возврат в стратегию поиска из фрейма в обычный - нужно делать обязательно данное переключение
//        driver.switchTo().defaultContent();//дефолтная наша html
//        Thread.sleep(70000);
//        driver.findElement(By.id("login_btn")).click();
    }
}
