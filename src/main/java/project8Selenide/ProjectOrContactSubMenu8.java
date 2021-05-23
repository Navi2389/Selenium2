package project8Selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectOrContactSubMenu8 {

    //для тест-кейса 1
    private SelenideElement myProjectButton = $(By.xpath("//span[text()='Мои проекты']"));

    @Step("Клик на кнопку из выпадающего меню Мои проекты")
    public void createProject() {
        myProjectButton.click();
    }

    //для тест-кейса 2
    private SelenideElement myContactButton = $(By.xpath("//span[text()='Контактные лица']"));

    @Step("Клик на кнопку из выпадающего меню Контактные лица")
    public void createContact() {
        myContactButton.click();
    }
}
