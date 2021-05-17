package project7.pagesTimeMaster;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTaskTimeMasterPage extends BaseViewTimeMaster {

    public CreateTaskTimeMasterPage(WebDriver driver) {
        super(driver);
    }

    //Для тест - кейса 2
    // //заполняем поле ToDo новая задача
    @FindBy(id = "newTaskName")
    public WebElement taskDescription;

    @Step("Заполняем описание задачи Time Master")
    public CreateTaskTimeMasterPage fillTask(String taskdescription) {
        taskDescription.sendKeys(taskdescription);
        return this;
    }

    //кликаем кнопку добавить новую задачу test1
    @FindBy(id = "addTask")
    public WebElement saveAndCloseButtonTask;

    @FindBy(xpath = "//*[text()='test1']")
    public WebElement requestTaskSuccess;

    public By requestTaskSuccessLocator = By.xpath("//*[text()='test1']");

}



