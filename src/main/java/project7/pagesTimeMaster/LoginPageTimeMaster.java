package project7.pagesTimeMaster;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project7.pagesDiary.MainPageDiary;

public class LoginPageTimeMaster extends BaseViewTimeMaster {
    @FindBy(id = "authUsername")
    public WebElement inputLogin;

    @FindBy(id = "authPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement buttonSubmit;

    public LoginPageTimeMaster(WebDriver driver) {
        super(driver);
    }

    @Step("Заполняем поле логин при авторизации")
    public LoginPageTimeMaster fillInputLogin(String login) throws InterruptedException {

        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполняем поле пароль при авторизации")
    public LoginPageTimeMaster fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку войти на странице авторизации")
    public MainPageDiary submitLogin() throws InterruptedException {

        buttonSubmit.click();
        return new MainPageDiary(driver);
    }

    public MainPageTimeMaster login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new MainPageTimeMaster(driver).TimeMasterHomeLocator));
        return new MainPageTimeMaster(driver);
    }
}
