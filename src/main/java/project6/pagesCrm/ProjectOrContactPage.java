package project6.pagesCrm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectOrContactPage extends BaseViewProject6 {

    public ProjectOrContactPage(WebDriver driver) {
        super(driver);
    }

    //для тест-кейса1
    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    public void CreateProject() throws InterruptedException {
        Thread.sleep(5000);
        createProjectButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectOrContactPage(driver).generalInfoLocator));
    }

    public By createProjectButtonLocator = By.xpath("//a[text()='Создать проект']");


    //для тест-кейса2
    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    public WebElement createContactButton;

    public void CreateContact() {
        createContactButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectOrContactPage(driver).generalInfoLocator));
    }

    public By createContactButtonLocator = By.xpath("//a[text()='Создать контактное лицо']");

}
