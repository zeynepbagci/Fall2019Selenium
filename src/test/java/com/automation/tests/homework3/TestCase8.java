package com.automation.tests.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {

    private WebDriver driver;
    private WebDriverWait wait;
    private By link = By.linkText("Autocomplete");
    private By countryBox = By.id("myCountry");
    private By resultMessage = By.id("result");

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(1);
        driver.manage().window().maximize();
        BrowserUtils.wait(1);

    }

    @Test
    public void test1(){
        driver.findElement(link).click();
        BrowserUtils.wait(1);
        driver.findElement(countryBox).sendKeys("United States of America", Keys.ENTER);
        BrowserUtils.wait(1);
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }
    @AfterMethod
    public void done(){
        BrowserUtils.wait(1);
        driver.quit();
    }
}
