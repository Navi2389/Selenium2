package project6.pagesCrm;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageProject6 extends BaseViewProject6 {
    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonSubmit;

    public LoginPageProject6(WebDriver driver) {
        super(driver);
    }

    public LoginPageProject6 fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPageProject6 fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPageProject6 submitLogin() {
        buttonSubmit.click();
        return new MainPageProject6(driver);
    }

    public MainPageProject6 login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new MainPageProject6(driver).geekBrainsHomeButtonLocator));
        return new MainPageProject6(driver);
    }
}
