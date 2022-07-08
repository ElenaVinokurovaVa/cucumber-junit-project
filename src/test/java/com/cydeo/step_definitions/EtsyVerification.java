package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyVerification {

    EtsyPage etsy = new EtsyPage();

    @Given("User is on Etsy main page")
    public void user_is_on_etsy_main_page() {
        Driver.getDriver().get("https://www.etsy.com");
        Assert.assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone",
                Driver.getDriver().getTitle());
    }

    @When("User search for Wooden spoon")
    public void user_search_for_wooden_spoon() {
        etsy.searchBox.sendKeys("Wooden spoon");
    }
    @And("User click search button")
    public void userClickSearchButton() {
       etsy.searchBtn.click();
    }

    @Then("User should see Wooden spoon in title")
    public void user_should_see_wooden_spoon_in_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Wooden spoon"));
    }

    @When("User search for {string}")
    public void user_search_for(String itemName) {
        etsy.searchBox.sendKeys(itemName);
    }

    @Then("User should see {string} in title")
    public void user_should_see_in_title(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }
}
