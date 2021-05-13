package project6.pagesCrm;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectOrContactPage extends BaseViewProject6 {

    public CreateProjectOrContactPage(WebDriver driver) {
        super(driver);
    }

    //Для тест - кейса 1
    //в поле Наименование прописываем слово test10 на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[name]")
    public WebElement requestDescription;

    public CreateProjectOrContactPage fillDescription(String description) {
        requestDescription.sendKeys(description);
        return this;
    }

    //FindBy 1 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/project/create/
    @FindBy(xpath = "//span[text()='Укажите организацию']//ancestor::a")
    public WebElement businessUnitOrgButton;

    //FindBy 2 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/project/create/
    @FindBy(xpath = "//input[@class='select2-input select2-focused']")
    public WebElement businessUnitOrgSelect;

    public CreateProjectOrContactPage selectBusinessUnitOrg(String orgName) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(businessUnitOrgButton));
        businessUnitOrgButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(businessUnitOrgSelect));
        businessUnitOrgSelect.sendKeys(orgName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(businessUnitOrgSelect));
        businessUnitOrgSelect.sendKeys(Keys.ENTER);
        return this;
    }

    //в поле Основное контактное лицо выбираем Hull Shaun на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[contactMain]")
    public WebElement ContactSelect;

    public CreateProjectOrContactPage selectContact(String contact) throws InterruptedException {
        Thread.sleep(5000);
        new Select(ContactSelect).selectByVisibleText(contact);
        return this;
    }

    //в поле Подразделение выбираем Research & Development на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public CreateProjectOrContactPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    //в поле Куратор проекта выбираем Applanatest Applanatest Applanatest на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[curator]")
    public WebElement CuratorSelect;

    public CreateProjectOrContactPage selectCurator(String curator) {
        new Select(CuratorSelect).selectByVisibleText(curator);
        return this;
    }

    //в поле Руководитель проекта выбираем Applanatest1 Applanatest1 Applanatest1 на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[rp]")
    public WebElement projectRPSelect;

    public CreateProjectOrContactPage selectProjectRP(String projectRP) {
        new Select(projectRPSelect).selectByVisibleText(projectRP);
        return this;
    }

    //в поле Администратор проекта выбираем Applanatest2 Applanatest2 Applanatest2 на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;

    public CreateProjectOrContactPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    //в поле Менеджер выбираем Студентов Студент на странице https://crm.geekbrains.space/project/create/
    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;

    public CreateProjectOrContactPage selectManager(String Manager) {
        new Select(managerSelect).selectByVisibleText(Manager);
        return this;
    }

    //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/project/create/
    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = "//*[text()='Проект сохранен']")
    public WebElement requestSuccess;

    public By requestSuccessLocator = By.xpath("//*[text()='Проект сохранен']");

    public By generalInfoLocator = By.xpath("//*[text()='Основная информация']");

    //для тест - кейса 2

    //заполняем поле Фамилия
    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;

    public CreateProjectOrContactPage fillLastName(String lastNameLastName) throws InterruptedException {
        Thread.sleep(5000);
        lastName.sendKeys(lastNameLastName);
        return this;
    }

    //заполняем поле Имя
    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    public CreateProjectOrContactPage fillFirstName(String firstNamefirstName) {
        firstName.sendKeys(firstNamefirstName);
        return this;
    }

    //заполняем поле Должность
    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    public CreateProjectOrContactPage fillJobTitle(String jobTitlejobTitle) {
        jobTitle.sendKeys(jobTitlejobTitle);
        return this;
    }

    //FindBy 1 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/contact/create
    @FindBy(xpath = "//span[text()='Укажите организацию']//ancestor::a")
    public WebElement businessUnitOrgButtonContact;

    //FindBy 2 из 2 в поле Организация выбираем Bins-Haley на странице https://crm.geekbrains.space/contact/create
    @FindBy(xpath = "//input[@class='select2-input select2-focused']")
    public WebElement businessUnitOrgSelectContact;

    public CreateProjectOrContactPage selectBusinessUnitOrgContact(String orgNameContact) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(businessUnitOrgButtonContact));
        businessUnitOrgButtonContact.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(businessUnitOrgSelectContact));
        businessUnitOrgSelectContact.sendKeys(orgNameContact);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(businessUnitOrgSelectContact));
        businessUnitOrgSelectContact.sendKeys(Keys.ENTER);
        return this;
    }

    //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/contact/create
    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButtonContact;

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement requestContactSuccess;

    public By requestContactSuccessLocator = By.xpath("//*[text()='Контактное лицо сохранено']");

}



