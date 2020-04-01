package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTestBase {
    protected WebDriverWait wait;
    protected Actions actions;


    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        //Itest resukt clss describes the result if a test
        //if test failed, take a screenshot
        if(iTestResult.getStatus() == ITestResult.FAILURE){
            BrowserUtils.getScreenShot(iTestResult.getName());
        }
        Driver.closeDriver();
    }
}
