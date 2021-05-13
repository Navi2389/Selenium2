package project6Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project6.pagesTimeMaster.CreateTaskTimeMasterPage;
import project6.pagesTimeMaster.LoginPageTimeMaster;
import project6.pagesTimeMaster.TimeMasterTaskPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static project6.pagesTimeMaster.BaseViewTimeMaster.BASE_URL_TIMEMASTER;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestCase1_2TimeMaster extends BaseTestGeneral {


    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL_TIMEMASTER);
    }

    @Test
        // тест - кейс 1 авторизация на сайте https://time-master.ru/login.aspx
    void loginTestWithFluentPage() throws InterruptedException {
        new LoginPageTimeMaster(driver)
                .fillInputLogin("koluivan@yandex.ru")
                .fillInputPassword("TestIvan1")
                .submitLogin();
    }

    @Test
        //тест-кейс 2 создание задачи в онлайн-органайзере

    void createNewTask() throws InterruptedException {
        new LoginPageTimeMaster(driver).login("koluivan@yandex.ru", "TestIvan1");

        new TimeMasterTaskPage(driver).CreateTask();

        new CreateTaskTimeMasterPage(driver)
                .fillTask("test11")
                .saveAndCloseButtonTask.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateTaskTimeMasterPage(driver).requestTaskSuccessLocator));

        assertThat(new CreateTaskTimeMasterPage(driver).requestTaskSuccess, isDisplayed());

        Thread.sleep(5000);
    }

}
