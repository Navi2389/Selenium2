package project6.pagesCrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseViewProject6 {
    public WebDriver driver; //экземпляр драйвера с спомощью которого мы будем взаимодействовать с конкретной страницей
    public WebDriverWait webDriverWait;
    LoginPageProject6 LoginPageProject6;
    public static final String BASE_URL = "https://crm.geekbrains.space/";

    public BaseViewProject6(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);//будет скрывать и за нас писать код driver.findElement(By...) //позволит нам сократить запись
    }
}
