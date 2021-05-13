package project6.pagesTimeMaster;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project6.pagesCrm.BaseViewProject6;

public class CreateTaskTimeMasterPage extends BaseViewTimeMaster {

    public CreateTaskTimeMasterPage(WebDriver driver) {
        super(driver);
    }

    //Для тест - кейса 2
    // //заполняем поле ToDo новая задача
    @FindBy(id = "newTaskName")
    public WebElement taskDescription;

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



