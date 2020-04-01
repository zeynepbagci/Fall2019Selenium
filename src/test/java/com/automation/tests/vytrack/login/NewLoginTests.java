package com.automation.tests.vytrack.login;

import com.automation.pages.fleet.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is a "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        //test-->ExtentTest object
        //we must add to every test at the beginning
        //test=report.createTest("Test name);
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard was verified");
    }
    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify Warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenShot("warning_message");

        test.pass("Warning message is displayed");
    }

}
