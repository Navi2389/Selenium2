package project7.pagesDiary;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageDiary extends BaseViewDiary {
    @FindBy(id = "loginform-username")
    public WebElement inputLogin;

    @FindBy(id = "loginform-password")
    public WebElement inputPassword;

    @FindBy(id = "login_btn")
    public WebElement buttonSubmit;

    public LoginPageDiary(WebDriver driver) {
        super(driver);
    }

    @Step("Заполняем поле логин при авторизации")
    public LoginPageDiary fillInputLogin(String login) throws InterruptedException {
       // Thread.sleep(120000);
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполняем поле пароль при авторизации")
    public LoginPageDiary fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку войти на странице авторизации")
    public MainPageDiary submitLogin() throws InterruptedException {
       // Thread.sleep(10000);
        buttonSubmit.click();
        return new MainPageDiary(driver);
    }

    public MainPageDiary login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new MainPageDiary(driver).DiaryHomeButtonLocator));
        return new MainPageDiary(driver);
    }
}
