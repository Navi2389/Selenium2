package project8Selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectOrContactPage8 {

    //для тест-кейса1
    private SelenideElement createProjectButton = $(By.xpath("//a[text()='Создать проект']"));

    @Step("Клик на кнопку Создание проекта")
    public void CreateProject() {
        createProjectButton.click();
    }

    //для тест-кейса2
    private SelenideElement createContactButton = $(By.xpath("//a[text()='Создать контактное лицо']"));

    @Step("Клик на кнопку Создание контакта")
    public void CreateContact() {
        createContactButton.click();
    }
}
