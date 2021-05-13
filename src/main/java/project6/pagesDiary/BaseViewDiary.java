package project6.pagesDiary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseViewDiary {
    public WebDriver driver; //экземпляр драйвера с спомощью которого мы будем взаимодействовать с конкретной страницей
    public WebDriverWait webDriverWait;
    //LoginPageDiary loginPageDiary;
    public static final String BASE_URL_DIARY = "https://diary.ru/user/login";

    public BaseViewDiary(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);//будет скрывать и за нас писать код driver.findElement(By...) //позволит нам сократить запись
    }
}
