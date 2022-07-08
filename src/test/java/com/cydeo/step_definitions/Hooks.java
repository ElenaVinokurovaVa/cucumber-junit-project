package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before // coming from cucumber, running before each scenario
    public void setUpScenario(){
        System.out.println("Before Scenario from Hooks");
    }

    @After
    public void tearDownScenario(Scenario scenario){
        System.out.println("After Scenario from Hooks");

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
            Driver.closeDriver();
    }
}
