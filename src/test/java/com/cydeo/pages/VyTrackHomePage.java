package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackHomePage {

    public VyTrackHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1']//span[contains(text(),'Fleet')]")
    public WebElement fleetModul;

    @FindBy(xpath = "//li[@class='dropdown-menu-single-item first']//span[text()='Vehicles']")
    public WebElement vehicleFeature;
}
