package project6.pagesTimeMaster;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project6.pagesDiary.BaseViewDiary;


public class MainPageTimeMaster extends BaseViewTimeMaster {
    public MainPageTimeMaster(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[text()='События на весь день']")
    public WebElement geekBrainsHomeButton;

    public By TimeMasterHomeLocator = By.xpath("//b[text()='События на весь день']");


}
