package com.automation.tests.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    private WebDriver driver;
    private By fileUpload = By.linkText("File Upload");
    private By chooseFile = By.id("file-upload");
    private By submit = By.id("file-submit");
    private By fileName = By.id("uploaded-files");
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        //step1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void fileUploading(){
        //step2
        driver.findElement(fileUpload).click();
        BrowserUtils.wait(1);
        String fileToPath = "/Users/zeynepbagci/Downloads/day44 class notes.txt";
        driver.findElement(chooseFile).sendKeys(fileToPath);
        BrowserUtils.wait(1);
        driver.findElement(submit).click();
        BrowserUtils.wait(1);
        Assert.assertTrue(driver.findElement(fileName).getText().contains("day44 class notes.txt"));



    }
    @AfterMethod
    public void tearup(){
        BrowserUtils.wait(1);
        driver.quit();
    }
}
