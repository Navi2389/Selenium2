package lessonProject5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateAutoProjectTimeMasterTaskDZ5 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://time-master.ru/login.aspx";
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
    void timeMasterTestCase1Login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        //глобально ждем везде 10 секунд, но надо не больше 3 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Ассерт (утверждение) проверка на наличии плашки "События на весь день" после авторизации
        WebElement authorization = driver.findElement(By.xpath("//b[text()='События на весь день']"));
        assertThat(authorization.getText(), containsString("События на весь день"));

        //заполняем поле ToDo новая задача
        driver.findElement(By.id("newTaskName")).sendKeys("test1");

        //кликаем кнопку добавить новую задачу test1
        driver.findElement(By.id("addTask")).click();

        //проверка на наличии плашки "test1" после нажатия на клавишу Добавить
        WebElement saveProject = driver.findElement(By.xpath("//*[text()='test1']"));
        assertThat(saveProject.getText(), containsString("test1"));

        //пишем правильное ожидание через класс WebdriverWait
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='test1']")));
        driver.findElement(By.xpath("//*[text()='test1']"));

        //закрываем браузер
        // driver.quit();
    }

    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);

        //обычная авторизация с помощью кнопок на сайте
        driver.findElement(By.id("authUsername")).sendKeys("koluivan@yandex.ru");
        driver.findElement(By.id("authPassword")).sendKeys("TestIvan1");
//        //работа с айфреймом
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'reCAPTCHA')]")));
//        driver.findElement(By.xpath("//body")).click();
//        //возврат в стратегию поиска из фрейма в обычный - нужно делать обязательно данное переключение
//        driver.switchTo().defaultContent();//дефолтная наша html
//        Thread.sleep(70000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //добавили авторизацию на сайте с помощью Cookies
//        Cookie sessionCookie = driver.manage().getCookieNamed("_ym_uid");
//        driver.manage().deleteCookie(sessionCookie);
//        Cookie cookie = new Cookie("_ym_uid", "1620557999437635195");
//        driver.manage().addCookie(cookie);
//        driver.navigate().refresh();

        //пишем правильное ожидание через класс WebdriverWait
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='События на весь день']")));
        driver.findElement(By.xpath("//b[text()='События на весь день']"));

        // Thread.sleep(50000);
//       driver.close();

    }

    @AfterMethod
        //чтобы после каждого теста закрывался браузер
    void closeBrowser() {
        driver.quit();
    }
}
