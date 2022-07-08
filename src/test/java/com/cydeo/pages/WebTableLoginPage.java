package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebTableLoginPage {
    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="username")
    public WebElement inputUserName;

    @FindBy(name="password")
    public WebElement inputPassword;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginBtn;

    public void login(String username,String password){
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }
}
