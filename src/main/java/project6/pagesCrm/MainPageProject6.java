package project6.pagesCrm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageProject6 extends BaseViewProject6 {
    public NavigationMenuProject6 navigationMenu;

    public MainPageProject6(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenuProject6(driver);
    }

    @FindBy(xpath = "//a[@title='Geekbrains']")
    public WebElement geekBrainsHomeButton;

    public By geekBrainsHomeButtonLocator = By.xpath("//a[@title='Geekbrains']");
}
