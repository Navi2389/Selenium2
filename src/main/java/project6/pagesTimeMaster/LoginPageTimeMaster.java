package project6.pagesTimeMaster;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project6.pagesDiary.BaseViewDiary;
import project6.pagesDiary.MainPageDiary;

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

    public LoginPageTimeMaster fillInputLogin(String login) throws InterruptedException {

        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPageTimeMaster fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

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
