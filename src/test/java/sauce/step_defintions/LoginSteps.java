package sauce.step_defintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sauce.pages.base.BasePageObject;

import static sauce.Drivers.getDriver;

public class LoginSteps extends BasePageObject {
    @When("User is on login page")
    public void userIsOnLoginPage() {
        getDriver().get("https://www.saucedemo.com");
    }

    @And("User fill username with {string}")
    public void userFillUsernameWith(String username) {
        typeOn("FIELD_USERNAME", username);
    }

    @And("User fill password with {string}")
    public void userFillPasswordWith(String password) {
        typeOn("FIELD_PASSWORD", password);
    }

    @And("User click login")
    public void userClickLogin() {
        clickOn("BUTTON_LOGIN");
    }

    @Then("User is on shopping page")
    public void userIsOnShoppingPage() {
        assertIsDisplayed("TEXT_SHOPPING_PAGE");
    }

    @Then("User get error {string}")
    public void userGetError(String errorMessage) {
        isTextSame("TEXT_ALERT_ERROR",errorMessage);
    }
}
