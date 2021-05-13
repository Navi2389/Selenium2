package project6.pagesTimeMaster;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseViewTimeMaster {
    public WebDriver driver; //экземпляр драйвера с спомощью которого мы будем взаимодействовать с конкретной страницей
    public WebDriverWait webDriverWait;
    //LoginPageDiary loginPageDiary;
    public static final String BASE_URL_TIMEMASTER = "https://time-master.ru/login.aspx";

    public BaseViewTimeMaster(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);//будет скрывать и за нас писать код driver.findElement(By...) //позволит нам сократить запись
    }
}
