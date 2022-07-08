package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[text()='View all orders']")
    public WebElement viewAllOrders;

    @FindBy(xpath = "//button[text()='View all products']")
    public WebElement viewAllProducts;

    @FindBy(xpath = "//button[text()='Order']")
    public WebElement orderBtn;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutBtn;
}
