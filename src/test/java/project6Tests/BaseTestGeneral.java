package project6Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import project6.pagesCrm.LoginPageProject6;
import project6.pagesDiary.LoginPageDiary;
import project6.pagesTimeMaster.LoginPageTimeMaster;

public class BaseTestGeneral {
    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPageProject6 loginPageProject6;
    LoginPageDiary loginPageDiary;
    LoginPageTimeMaster loginPageTimeMaster;

    @BeforeAll //перед всеми тестами
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach //перед каждым тестом
    public void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        loginPageProject6 = new LoginPageProject6(driver);
        loginPageDiary = new LoginPageDiary(driver);
        loginPageTimeMaster = new LoginPageTimeMaster(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
