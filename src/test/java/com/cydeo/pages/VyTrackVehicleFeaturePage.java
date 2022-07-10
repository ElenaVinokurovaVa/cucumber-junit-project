package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VyTrackVehicleFeaturePage {

    public VyTrackVehicleFeaturePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='pull-left']//h1")
    public WebElement carsHeader;

    @FindBy(xpath = "//div[@class='btn-group']//a")
    public WebElement exportGrid;

    @FindBy(xpath = "//div[@class='btn-group']//a//following-sibling::ul//li")
    public List<WebElement> exportGridMenu;

    @FindBy(xpath = "//div[@class='toolbar']//div/div")
    public WebElement gridOnLeft;
}
