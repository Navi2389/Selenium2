package project7TestsAllure;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project7.pagesDiary.CreateListDiarytPage;
import project7.pagesDiary.DiariListPage;
import project7.pagesDiary.LoginPageDiary;

import static org.hamcrest.MatcherAssert.assertThat;
import static project7.pagesDiary.BaseViewDiary.BASE_URL_DIARY;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Feature("Тестирование: два тест кейса - на авторизацию в Diary и на создание записи ")
public class TestCase1_2Diary extends BaseTestGeneral {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL_DIARY);
    }

    @Test
    @Description("тест 1 авторизация на сайте https://diary.ru/")
        //тест-кейс 1 авторизация на сайте https://diary.ru/
        // авторизация на сайте
    void loginTestWithFluentPage() throws InterruptedException {
        new LoginPageDiary(driver)
                .fillInputLogin("TestIvan1")
                .fillInputPassword("TestIvan1")
                .submitLogin();
    }

    @Test
    @Description("тест-кейс 2 Создание записи в дневнике")
        //тест-кейс 2 Создание записи в дневнике
    void createNewList() throws InterruptedException {
        new LoginPageDiary(driver).login("TestIvan1", "TestIvan1");

        new DiariListPage(driver).CreateList();

        new CreateListDiarytPage(driver)
                .fillHead("test1")
                .fillMessage("test1")
                .saveAndCloseButtonList.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateListDiarytPage(driver).requestListSuccessLocator));

        assertThat(new CreateListDiarytPage(driver).requestListSuccess, isDisplayed());

        //Thread.sleep(5000);
    }
}
