package project8Selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

@Feature("Создаем проект или контакт")
public class CreateProjectOrContactPage8 {

    //Для тест - кейса 1
    //в поле Наименование прописываем слово test10 на странице https://crm.geekbrains.space/project/create/
    private SelenideElement requestDescription = $(By.name("crm_project[name]"));

    @Step("Прописываем в Наименовании слово test10")
    public CreateProjectOrContactPage8 fillDescription(String description) {
        requestDescription.sendKeys(description);
        return this;
    }

    //Selenide 1 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/project/create/
    private SelenideElement businessUnitOrgButton = $(By.xpath("//span[text()='Укажите организацию']//ancestor::a"));

    //Selenide 2 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/project/create/
    private SelenideElement businessUnitOrgSelect = $(By.xpath("//input[@class='select2-input select2-focused']"));

    @Step("Выбираем в Организации Bins-Haley: клик, ввод текста, ентер")
    public CreateProjectOrContactPage8 selectBusinessUnitOrg(String orgName) {
        businessUnitOrgButton.click();
        businessUnitOrgSelect.sendKeys(orgName);
        businessUnitOrgSelect.sendKeys(Keys.ENTER);
        return this;
    }

    //в поле Основное контактное лицо выбираем Hull Shaun на странице https://crm.geekbrains.space/project/create/
    private SelenideElement ContactSelect = $(By.name("crm_project[contactMain]"));

    @Step("Выбираем в Основное контактное лицо Hull Shaun")
    public CreateProjectOrContactPage8 selectContact(String contact) {
        new Select(ContactSelect).selectByVisibleText(contact);
        return this;
    }

    //в поле Подразделение выбираем Research & Development на странице https://crm.geekbrains.space/project/create/
    private SelenideElement businessUnitSelect = $(By.name("crm_project[businessUnit]"));

    @Step("Выбираем в Подразделение Research & Development")
    public CreateProjectOrContactPage8 selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    //в поле Куратор проекта выбираем Applanatest Applanatest Applanatest на странице https://crm.geekbrains.space/project/create/
    private SelenideElement CuratorSelect = $(By.name("crm_project[curator]"));

    @Step("Выбираем в Куратора проекта")
    public CreateProjectOrContactPage8 selectCurator(String curator) {
        new Select(CuratorSelect).selectByVisibleText(curator);
        return this;
    }

    //в поле Руководитель проекта выбираем Applanatest1 Applanatest1 Applanatest1 на странице https://crm.geekbrains.space/project/create/
    private SelenideElement projectRPSelect = $(By.name("crm_project[rp]"));

    @Step("Выбираем в Руководителя проекта")
    public CreateProjectOrContactPage8 selectProjectRP(String projectRP) {
        new Select(projectRPSelect).selectByVisibleText(projectRP);
        return this;
    }

    //в поле Администратор проекта выбираем Applanatest2 Applanatest2 Applanatest2 на странице https://crm.geekbrains.space/project/create/
    private SelenideElement administratorSelect = $(By.name("crm_project[administrator]"));

    @Step("Выбираем в Администратора проекта")
    public CreateProjectOrContactPage8 selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    //в поле Менеджер выбираем Студентов Студент на странице https://crm.geekbrains.space/project/create/
    private SelenideElement managerSelect = $(By.name("crm_project[manager]"));

    @Step("Выбираем в Менеджера проекта")
    public CreateProjectOrContactPage8 selectManager(String Manager) {
        new Select(managerSelect).selectByVisibleText(Manager);
        return this;
    }

    //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/project/create/
    public SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));

    //проверяем наличие плашки Проект сохранен
    public SelenideElement requestSuccess = $(By.xpath("//*[text()='Проект сохранен']"));


    //для тест - кейса 2

    //заполняем поле Фамилия
    private SelenideElement lastName = $(By.name("crm_contact[lastName]"));

    @Step("Заполняем поле Фамилия при создании контакта")
    public CreateProjectOrContactPage8 fillLastName(String lastNameLastName) {
        lastName.sendKeys(lastNameLastName);
        return this;
    }

    //заполняем поле Имя
    private SelenideElement firstName = $(By.name("crm_contact[firstName]"));

    @Step("Заполняем поле Имя при создании контакта")
    public CreateProjectOrContactPage8 fillFirstName(String firstNamefirstName) {
        firstName.sendKeys(firstNamefirstName);
        return this;
    }

    //заполняем поле Должность
    private SelenideElement jobTitle = $(By.name("crm_contact[jobTitle]"));

    @Step("Заполняем поле Должность при создании контакта")
    public CreateProjectOrContactPage8 fillJobTitle(String jobTitlejobTitle) {
        jobTitle.sendKeys(jobTitlejobTitle);
        return this;
    }

    //Selenide 1 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/contact/create
    private SelenideElement businessUnitOrgButtonContact = $(By.xpath("//span[text()='Укажите организацию']//ancestor::a"));

    //Selenide 2 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/contact/create
    private SelenideElement businessUnitOrgSelectContact = $(By.xpath("//input[@class='select2-input select2-focused']"));

    @Step("Заполняем поле Организация при создании контакта: клик, ввод текста, ентер")
    public CreateProjectOrContactPage8 selectBusinessUnitOrgContact(String orgNameContact) {
        businessUnitOrgButtonContact.click();
        businessUnitOrgSelectContact.sendKeys(orgNameContact);
        businessUnitOrgSelectContact.sendKeys(Keys.ENTER);
        return this;
    }

    //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/contact/create
    public SelenideElement saveAndCloseButtonContact = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));

    //пверяем наличие плашки Контактное лицо сохранено
    public SelenideElement requestContactSuccess = $(By.xpath("//*[text()='Контактное лицо сохранено']"));
}



