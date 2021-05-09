package lessonProject3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmCreateAutoProjectDZ3 {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriverWait webDriverWait;

    @BeforeSuite
//выполняется один раз перед всеми тестами
    void setupDataBase() {
        System.out.println("Before suit setup database");
    }

    @BeforeTest
//выполняется один раз перед всеми тестами и после @BeforeSuite если он есть
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(LOGIN_PAGE_URL);
        login();
    }

    @Test
    void crmTestCase1Project() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        //глобально ждем везде 10 секунд, но надо не больше 3 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Ассерт (утверждение) проверка на наличии плашки "панели инструментов" после авторизации
        List<WebElement> panelInsrumentov = driver.findElements(
                By.xpath("//ul[@class='breadcrumb']//child::li[1]"));//составили xpath для названия Панели инструментов

        //проверка на наличии плашки "панели инструментов" после авторизации
        assertThat(panelInsrumentov.get(0).getText(), containsString("Панели инструментов"));
        //     assertThat(panelInsrumentov.get(0), hasText("ВЛАДЕЛЕЦ"));
        assertThat(panelInsrumentov.get(0), isDisplayed());

        //навели мышку на элемент Проекты и кликнули Мои проекты
        Actions actions = new Actions(driver);
        WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuItem).perform();
        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

        //проверка на наличии плашки "Мои проекты" после перехода в них
        WebElement MyProjects = driver.findElement(By.xpath("//li[text()='Мои проекты']"));
        assertThat(MyProjects.getText(), containsString("Мои проекты"));

        //пишем правильное ожидание через класс WebdriverWait
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']"));

        //Thread.sleep(5000);

        //нажимаем на кнопку Создать проект
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        //проверка на наличии плашки "Основная информация" после нажатия на кнопку Создать проект
        WebElement CreateProject = driver.findElement(By.xpath("//h5[span='Основная информация']"));
        assertThat(CreateProject.getText(), containsString("Основная информация"));

        //заполняем поле Наименование
        driver.findElement(By.name("crm_project[name]")).sendKeys("test10");

        //заполняем поле Организация
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Bins-Haley");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        //заполняем поле Основное контактное лицо
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[contactMain]']/option[3]")).click();
        driver.findElement(By.xpath("//input[@name='crm_project[type]' and contains(@data-name, 'field__1')]")).click();

        //в поле Подразделение выбираем Research & Development на странице https://crm.geekbrains.space/project/create/
        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");

        //в поле Куратор проекта выбираем Applanatest Applanatest Applanatest на странице https://crm.geekbrains.space/project/create/
        Select projectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        projectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        //в поле Руководитель проекта выбираем Applanatest1 Applanatest1 Applanatest1 на странице https://crm.geekbrains.space/project/create/
        Select projectRP = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectRP.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        //в поле Администратор проекта выбираем Applanatest2 Applanatest2 Applanatest2 на странице https://crm.geekbrains.space/project/create/
        Select projectAdministrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        projectAdministrator.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

        //в поле Менеджер выбираем Студентов Студент на странице https://crm.geekbrains.space/project/create/
        Select projectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        projectManager.selectByVisibleText("Студентов Студент");

        //кликаем по кнопке "Сохранить и закрыть" на странице https://crm.geekbrains.space/expense-request/create
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        //пишем правильное ожидание через класс WebdriverWait
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
        //  Thread.sleep(10000);

        //проверка на наличии плашки "Проект сохранен" после нажатия на клавишу Сохранить и закрыть
        WebElement saveProject = driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
        assertThat(saveProject.getText(), containsString("Проект сохранен"));

        //закрываем браузер
        //driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @AfterMethod
        //чтобы после каждого теста закрывался браузер
    void closeBrowser() {
        driver.quit();
    }
}
