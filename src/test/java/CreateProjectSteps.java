import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project8Selenide.*;

public class CreateProjectSteps {
    @Given("I am authorized")
    public void iAmAuthorized() {
        new LoginPageProject8().login("Applanatest1", "Student2020!");
    }

    @Given("I am on project page")
    public void iAmOnProjectPage() {
        new MainPageProject8().navigationMenu.openNavigationMenuItem("Проекты");
        new ProjectOrContactSubMenu8().createProject();
        new ProjectOrContactPage8().CreateProject();
    }

    @When("I fill description field")
    public void iFillDescriptionField() {
        new CreateProjectOrContactPage8().fillDescription("test15");
    }

    @And("I select business unit org")
    public void iSelectBusinessUnitOrg() {
        new CreateProjectOrContactPage8().selectBusinessUnitOrg("Bins-Haley");
    }

    @And("I select contact")
    public void iSelectContact() {
        new CreateProjectOrContactPage8().selectContact("Hull Shaun");
    }

    @And("I select business unit")
    public void iSelectBusinessUnit() {
        new CreateProjectOrContactPage8().selectBusinessUnit("Research & Development");
    }

    @And("I select curator")
    public void iSelectCurator() {
        new CreateProjectOrContactPage8().selectCurator("Applanatest Applanatest Applanatest");
    }

    @And("I select projectRP")
    public void iSelectProjectRP() {
        new CreateProjectOrContactPage8().selectProjectRP("Applanatest1 Applanatest1 Applanatest1");
    }

    @And("I select administrator")
    public void iSelectAdministrator() {
        new CreateProjectOrContactPage8().selectAdministrator("Applanatest2 Applanatest2 Applanatest2");
    }

    @And("I select manager")
    public void iSelectManager() {
        new CreateProjectOrContactPage8().selectManager("Студентов Студент");
    }

    @And("I click save and close button")
    public void iClickSaveAndCloseButton() {
        new CreateProjectOrContactPage8().saveAndCloseButton.click();
    }

    @Then("I see success message")
    public void iSeeSuccessMessage() {
        new CreateProjectOrContactPage8().requestSuccess.shouldBe(Condition.visible);
    }
}
