package com.automation.pages.fleet;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="prependedInput")
    private WebElement username;

    @FindBy(id="prependedInput2")
    private WebElement password;

    @FindBy(id="_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css="[class='alert alert-error']")
    private WebElement warningMessage;



    public LoginPage(){
        //to connect our webdriver, page class and page factory
        //pagefactory - used to use @Finfby annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
        BrowserUtils.wait(3);
    }
    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    /**
     * Method to login version #1
     * @param usernameValue
     * @param passwordValue
     */

    public void login(String usernameValue, String passwordValue){

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);

    }

    /**
     * Method to login version #2
     * Credentials will be retrieved from ConfigurationReader file
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
    }

}
