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
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1_StepDef {

    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackHomePage vyTrackHomePage = new VyTrackHomePage();
    VyTrackVehicleFeaturePage vyTrackVehicleFeaturePage = new VyTrackVehicleFeaturePage();
    Actions actions = new Actions(Driver.getDriver());


    @Given("User is logged in under  vehicle feature")
    public void userIsLoggedInUnderVehicleFeature() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
        vyTrackLoginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));
        actions.moveToElement(vyTrackHomePage.fleetModul).perform();
        vyTrackHomePage.vehicleFeature.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']//h1"),"Cars"));
        Assert.assertEquals("Cars", vyTrackVehicleFeaturePage.carsHeader.getText());
    }
    @When("User click Export Grid dropdown")
    public void user_click_export_grid_dropdown() {
        vyTrackVehicleFeaturePage.exportGrid.click();
    }
    @Then("User Should be able to see options CSV and XLSX")
    public void user_should_be_able_to_see_options_csv_and_xlsx() {
        Assert.assertEquals(2,vyTrackVehicleFeaturePage.exportGridMenu.size());
        for(WebElement each:vyTrackVehicleFeaturePage.exportGridMenu){
            each.getText();
        }
    }
    @Then("User see the Grid dropdown is on the left of the page")
    public void user_see_the_grid_dropdown_is_on_the_left_of_the_page() {
        Point loc = Driver.getDriver().findElement(By.xpath("//div[@class='extra-actions-panel']")).getLocation();
        System.out.println("location = " + loc);

        int winWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int xPos = Driver.getDriver().findElement(By.xpath("//div[@class='extra-actions-panel']")).getLocation().getX();

        Assert.assertTrue(xPos < winWidth /2);

        System.out.println(vyTrackVehicleFeaturePage.gridOnLeft.getAttribute("class"));
        Assert.assertTrue(vyTrackVehicleFeaturePage.gridOnLeft.getAttribute("class").contains("sorting pull-left"));
    }
}
