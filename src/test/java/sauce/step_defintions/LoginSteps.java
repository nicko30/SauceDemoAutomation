package sauce.step_defintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sauce.Drivers.getDriver;

public class LoginSteps {
    @When("User is on login page")
    public void userIsOnLoginPage() {
        getDriver().get("https://www.saucedemo.com");
    }

    @And("User fill username with {string}")
    public void userFillUsernameWith(String username) {
        WebElement usernameField = getDriver().findElement(By.id("user-name"));
        usernameField.sendKeys(username);
    }

    @And("User fill password with {string}")
    public void userFillPasswordWith(String password) {
        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @And("User click login")
    public void userClickLogin() {
        WebElement buttonLogin = getDriver().findElement(By.id("login-button"));
        buttonLogin.click();
    }

    @Then("User is on shopping page")
    public void userIsOnShoppingPage() {
        WebElement inventoryContainer = getDriver().findElement(By.xpath("//*[@data-test='inventory-container']"));
        assertTrue(inventoryContainer.isDisplayed());
    }

    @Then("User get error {string}")
    public void userGetError(String errorMessage) {
        WebElement errorElement = getDriver().findElement(By.xpath("//*[@data-test='error']"));
        String errorMessageOnWeb = errorElement.getText();
        assertEquals(errorMessage, errorMessageOnWeb);
        //"Epic sadface: Username and password do not match any user in this service"
    }

    @Then("User get error")
    public void userGetError() {
        WebElement errorElement = getDriver().findElement(By.xpath("//*[@data-test='error']"));
        String errorMessageOnWeb = errorElement.getText();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessageOnWeb);
    }
}
