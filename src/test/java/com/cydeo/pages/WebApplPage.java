package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebApplPage {

    public WebApplPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public  WebElement passwordInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public  WebElement loginBtn;

    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
