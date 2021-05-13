package project6Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import project6.pagesCrm.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static project6.pagesCrm.BaseViewProject6.BASE_URL;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestCase1_2CrmProject extends BaseTestGeneral {


    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
        // авторизация на сайте
    void loginTestWithFluentPage() {
        new LoginPageProject6(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }

    @Test
        //тест-кейс 1 создание проекта
//тест на создание нового проекта в разделе Мои проекты
    void createNewProject() throws InterruptedException {
        new LoginPageProject6(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Проекты");
        new ProjectOrContactSubMenu(driver).createProject();
        new ProjectOrContactPage(driver).CreateProject();

        new CreateProjectOrContactPage(driver)
                .fillDescription("test11")
                .selectBusinessUnitOrg("Bins-Haley")
                .selectContact("Hull Shaun")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectProjectRP("Applanatest1 Applanatest1 Applanatest1")
                .selectAdministrator("Applanatest2 Applanatest2 Applanatest2")
                .selectManager("Студентов Студент")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectOrContactPage(driver).requestSuccessLocator));

        assertThat(new CreateProjectOrContactPage(driver).requestSuccess, isDisplayed());

        Thread.sleep(5000);
    }

    @Test
        //тест-кейс 2 создание контактного лица в организации с минимально заполенной информацией
//тест на создание контактного лица в организации с минимально заполенной информацией
    void createNewContact() throws InterruptedException {
        new LoginPageProject6(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Контрагенты");
        new ProjectOrContactSubMenu(driver).createContact();
        new ProjectOrContactPage(driver).CreateContact();

        new CreateProjectOrContactPage(driver)
                .fillLastName("Иванов5")
                .fillFirstName("Иван5")
                .fillJobTitle("Тестировщик4")
                .selectBusinessUnitOrgContact("Bins-Haley")

                .saveAndCloseButtonContact.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectOrContactPage(driver).requestContactSuccessLocator));

        assertThat(new CreateProjectOrContactPage(driver).requestContactSuccess, isDisplayed());

        Thread.sleep(5000);

    }

}
