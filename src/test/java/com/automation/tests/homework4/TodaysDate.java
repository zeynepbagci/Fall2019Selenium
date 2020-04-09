package com.automation.tests.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TodaysDate {

    private WebDriver driver ;
    private String URL = "http://practice.cybertekschool.com/dropdown";
    private By  year = By.xpath("//select[@id='year']//option[@value='2020']");
    private By month = By.xpath("//select[@id='month']//option[contains(text(),'April')]");
    private By day = By.xpath("//select[@id='day']//option[@value='8']");


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

    }
    @Test
    public void todaysDateTest(){
        driver.get(URL);
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(year).isSelected());
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(month).isSelected());
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(day).isSelected());

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
