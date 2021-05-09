package lessonProject3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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

public class CreateAutoProjectDiaryLoginDZ3 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://diary.ru/user/login";
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
    void setUpBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(LOGIN_PAGE_URL);
        login();
    }

    @Test
    void diaryTestCase1Login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        //глобально ждем везде 10 секунд, но надо не больше 3 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Ассерт (утверждение) проверка на наличии плашки "Популярное" после авторизации
        WebElement authorization = driver.findElement(By.xpath("//h1[text()='Популярное']"));
        assertThat(authorization.getText(), containsString("Популярное"));

        //закрываем браузер
        // driver.quit();
    }

    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        //добавили авторизацию на сайте с помощью Cookies
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "89uq1gbr376sskl437kd2v0esd");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        //пишем правильное ожидание через класс WebdriverWait
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Популярное']")));
        driver.findElement(By.xpath("//h1[text()='Популярное']"));

        // Thread.sleep(50000);
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

    @AfterMethod
        //чтобы после каждого теста закрывался браузер
    void closeBrowser() {
        driver.quit();
    }
}
