package project8Selenide;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static project8Selenide.Configuration.BASE_URL;


public class LoginPageProject8 {
    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement buttonSubmit = $(By.id("_submit"));

    @Step("Заполняем поле логин при авторизации")
    public LoginPageProject8 fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполняем поле пароль при авторизации")
    public LoginPageProject8 fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку войти на странице авторизации")
    public MainPageProject8 submitLogin() {
        buttonSubmit.click();
        return page(MainPageProject8.class);
    }

    public MainPageProject8 login(String login, String password) {
        open(BASE_URL);
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        return page(MainPageProject8.class);
    }
}
