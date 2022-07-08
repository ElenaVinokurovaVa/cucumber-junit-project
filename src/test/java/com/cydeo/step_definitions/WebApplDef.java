package com.cydeo.step_definitions;

import com.cydeo.pages.WebApplPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebApplDef {

    WebApplPage obj = new WebApplPage();

    @Given("User is on web table login page")
    public void user_is_on_web_table_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.tables.page"));
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        obj.usernameInput.sendKeys(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        obj.passwordInput.sendKeys(password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        obj.loginBtn.click();
    }

    @Then("User should see url contains word orders")
    public void user_should_see_url_contains_word_orders() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));
    }

    @When("User enters username {string} and password {string} and clicks login")
    public void userEntersUsernameAndPasswordAndClicksLogin(String username, String password) {
        obj.login(username, password);
    }

    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {
        obj.usernameInput.sendKeys(credentials.get("username"));
        obj.passwordInput.sendKeys(credentials.get("password"));
        obj.loginBtn.click();
    }
}

