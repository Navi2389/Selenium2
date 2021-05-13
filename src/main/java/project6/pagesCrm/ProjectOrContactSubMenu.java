package project6.pagesCrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectOrContactSubMenu extends BaseViewProject6 {


    public ProjectOrContactSubMenu(WebDriver driver) {
        super(driver);
    }

    //для тест-кейса 1
    @FindBy(xpath = "//span[text()='Мои проекты']")
    public WebElement myProjectButton;


    public void createProject() throws InterruptedException {
        myProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new ProjectOrContactPage(driver).createProjectButtonLocator));
    }

    //для тест-кейса 2
    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement myContactButton;


    public void createContact() {
        myContactButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new ProjectOrContactPage(driver).createContactButtonLocator));
    }
}
