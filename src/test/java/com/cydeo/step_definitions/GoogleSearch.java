package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleSearch {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    public static final Logger LOG = LogManager.getLogger();


    @Given("User is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com/");
    }


    @When("User types apple in the google search box and clicks enter")
    public void user_types_apple_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
        LOG.info("I love java");
    }

    @Then("User sees apple – Google Search is in the google title")
    public void user_sees_apple_google_search_is_in_the_google_title() {
        Assert.assertEquals("Title verification is failed","apple - Google Search",Driver.getDriver().getTitle());
        LOG.info("Title verification is failed");
    }

    @When("User types {string} in the google/facebook search box and clicks enter")
    public void userTypesInTheGoogleSearchBoxAndClicksEnter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
        //LOG.info("hello");
    }

    @Then("User sees {string} is in the google title")
    public void userSeesIsInTheGoogleTitle(String expectedTitle) {
        Assert.assertEquals("Title verification is failed",expectedTitle,Driver.getDriver().getTitle());
        //TODO: fix this later
    }

    @Then("User should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> searchKeyWords) {
        System.out.println("searchKeywords" + searchKeyWords);

        for(String each:searchKeyWords){
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(each+Keys.ENTER);
            Assert.assertEquals(each + " - Google Search",Driver.getDriver().getTitle());
        }
    }

    @When("User search for {string} capital")
    public void userSearchForCapital(String countryName) {
        googleSearchPage.searchBox.sendKeys("what is the capital of " + countryName + Keys.ENTER);
    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String capitalCity) {
        Assert.assertEquals(capitalCity,googleSearchPage.capitalText.getText());
    }
}
