package com.cydeo.step_definitions;

import com.cydeo.pages.VyTrackHomePage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.pages.VyTrackVehicleFeaturePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test1_StepDef {

    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackHomePage vyTrackHomePage = new VyTrackHomePage();
    VyTrackVehicleFeaturePage vyTrackVehicleFeaturePage = new VyTrackVehicleFeaturePage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("User is logged in under  vehicle feature")
    public void userIsLoggedInUnderVehicleFeature() {
        vyTrackVehicleFeaturePage.navigate();
        vyTrackLoginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));
        actions.moveToElement(vyTrackHomePage.fleetModul).perform();
        vyTrackHomePage.vehicleFeature.click();
        vyTrackVehicleFeaturePage.waitForText();
        Assert.assertEquals("Cars", vyTrackVehicleFeaturePage.carsHeader.getText());
    }

    @When("User click Export Grid dropdown")
    public void user_click_export_grid_dropdown() {
        vyTrackVehicleFeaturePage.exportGrid.click();
    }

    @Then("User Should be able to see options CSV and XLSX")
    public void user_should_be_able_to_see_options_csv_and_xlsx() {
        for(WebElement each:vyTrackVehicleFeaturePage.exportGridMenu){
            if(each.getText().equals("CSV")){
            }else if(each.getText().equals("XLSX")){
                System.out.println("Passed");
            }else {
                System.out.println("Failed");
            }
        }
    }

    @Then("User see the Grid dropdown is on the left of the page")
    public void user_see_the_grid_dropdown_is_on_the_left_of_the_page() {
        vyTrackVehicleFeaturePage.positionOfGrid();
    }
}
