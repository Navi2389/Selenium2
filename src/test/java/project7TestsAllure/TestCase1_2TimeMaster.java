package project7TestsAllure;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project7.pagesTimeMaster.CreateTaskTimeMasterPage;
import project7.pagesTimeMaster.LoginPageTimeMaster;
import project7.pagesTimeMaster.TimeMasterTaskPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static project7.pagesTimeMaster.BaseViewTimeMaster.BASE_URL_TIMEMASTER;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Feature("Тестирование: два тест кейса - на авторизацию в TimeMaster и на создание записи ")
public class TestCase1_2TimeMaster extends BaseTestGeneral {


    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL_TIMEMASTER);
    }

    @Test
    @Description("тест - кейс 1 авторизация на сайте https://time-master.ru/login.aspx")
        // тест - кейс 1 авторизация на сайте https://time-master.ru/login.asp]x
    void loginTestWithFluentPage() throws InterruptedException {
        new LoginPageTimeMaster(driver)
                .fillInputLogin("koluivan@yandex.ru")
                .fillInputPassword("TestIvan1")
                .submitLogin();
    }

    @Test
    @Description("тест - кейс 2 создание задачи в онлайн-органайзере https://time-master.ru/login.aspx")
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

        //Thread.sleep(5000);
    }

}
