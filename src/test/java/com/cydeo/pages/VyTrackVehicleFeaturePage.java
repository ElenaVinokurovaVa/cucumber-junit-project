package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VyTrackVehicleFeaturePage {

    public VyTrackVehicleFeaturePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='pull-left']//h1")
    public WebElement carsHeader;// make private and create method

    @FindBy(xpath = "//div[@class='btn-group']//a")
    public WebElement exportGrid;

    @FindBy(xpath = "//div[@class='btn-group open']//ul//a")
    public List<WebElement> exportGridMenu;

    public void waitForText(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']//h1"),"Cars"));
    }

    public void navigate(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }

    public void positionOfGrid(){
        Point loc = Driver.getDriver().findElement(By.xpath("//div[@class='extra-actions-panel']")).getLocation();
        int winWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int xPos = Driver.getDriver().findElement(By.xpath("//div[@class='extra-actions-panel']")).getLocation().getX();
        boolean positionOnleft = xPos < winWidth /2;
        Assert.assertTrue(positionOnleft);
    }
}
