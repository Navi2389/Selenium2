package project7.pagesTimeMaster;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TimeMasterTaskPage extends BaseViewTimeMaster {

    public TimeMasterTaskPage(WebDriver driver) {
        super(driver);
    }

    //для тест-кейса2
    @FindBy(id = "newTaskName")
    public WebElement createTaskButton;

    @Step("Нажимаем кнопку создание задачи TimeMaster")
    public void CreateTask() throws InterruptedException {
        //Thread.sleep(5000);
        createTaskButton.click();

    }

}
