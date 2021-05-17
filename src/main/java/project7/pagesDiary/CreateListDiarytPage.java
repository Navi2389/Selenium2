package project7.pagesDiary;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project7.pagesCrm.BaseViewProject6;

public class CreateListDiarytPage extends BaseViewProject6 {

    public CreateListDiarytPage(WebDriver driver) {
        super(driver);
    }

    //Для тест - кейса 1
    //в поле Заголовок прописываем слово test1 на странице https://testivan1.diary.ru/?newpost
    @FindBy(name = "BlogsPosts[title]")
    public WebElement headDescription;

    @Step("Заполняем заголовок дневника Diary")
    public CreateListDiarytPage fillHead(String description) {
        headDescription.sendKeys(description);
        return this;
    }

    //в поле Сообщение прописываем слово test1 на странице https://testivan1.diary.ru/?newpost
    @FindBy(xpath = "//iframe[contains(@id,'message_ifr')]")
    public WebElement messageDescription;

    @Step("Заполняем сообщение дневника Diary")
    public CreateListDiarytPage fillMessage(String descriptionMes) {
        messageDescription.sendKeys(descriptionMes);
        return this;
    }

    //работа с айфреймом для поля Сообщение
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'message_ifr')]")));
//        driver.findElement(By.xpath("//body")).sendKeys("test1");


    //кликаем по кнопке "Опубликовать" на странице https://testivan1.diary.ru/?newpost
    @FindBy(xpath = "//input[contains(@name,'rewrite')]")
    public WebElement saveAndCloseButtonList;

    @FindBy(xpath = "//*[text()='test1']")
    public WebElement requestListSuccess;

    public By requestListSuccessLocator = By.xpath("//*[text()='test1']");

    public By diaryInfoLocator = By.xpath("//*[text()='Заголовок:']");

}



