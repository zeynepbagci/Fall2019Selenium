package com.automation.tests.homework3;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class TestCase6 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        driver.get("https://www.fakemail.net/");

    }
}
