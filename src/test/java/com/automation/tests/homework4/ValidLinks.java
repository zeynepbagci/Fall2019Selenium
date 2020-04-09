package com.automation.tests.homework4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidLinks {

    private WebDriver driver;
    private String URL = "https://www.selenium.dev/documentation/en/";

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void validLinksTest(){
        List <WebElement> allLinks = driver.findElements(By.tagName("</a>"));
        for(WebElement eachLink : allLinks){

         Assert.assertTrue(eachLink.isSelected());
        }


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
