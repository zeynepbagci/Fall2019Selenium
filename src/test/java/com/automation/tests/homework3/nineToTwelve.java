package com.automation.tests.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class nineToTwelve {

    private WebDriver driver;
    private By practiceLink = By.linkText("Status Codes");
    private By choice9 = By.xpath("//a[text() ='200']");
    private By message = By.xpath("//p[text()]");
    private By choice10 = By.xpath("//a[text() = '301']");
    private By choice11 = By.xpath("//a[text() = '404']");
    private By choice12 = By.xpath("//a[text() = '500']");

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        BrowserUtils.wait(1);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(1);
        driver.findElement(practiceLink).click();
        BrowserUtils.wait(1);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void done(){
        BrowserUtils.wait(1);
        driver.quit();
    }

    @Test
    public void test9() {
        driver.findElement(choice9).click();
        BrowserUtils.wait(1);
        Assert.assertTrue(driver.findElement(message).isDisplayed());
        Assert.assertTrue(driver.findElement(message).getText().contains("200"));
    }

    @Test
    public void test10() {
        driver.findElement(choice10).click();
        Assert.assertTrue(driver.findElement(message).isDisplayed());
        Assert.assertTrue(driver.findElement(message).getText().contains("301"));
    }

    @Test
    public void test11() {
        driver.findElement(choice11).click();
        Assert.assertTrue(driver.findElement(message).isDisplayed());
        Assert.assertTrue(driver.findElement(message).getText().contains("404"));
    }

    @Test
    public void test12() {
        driver.findElement(choice12).click();
        Assert.assertTrue(driver.findElement(message).isDisplayed());
        Assert.assertTrue(driver.findElement(message).getText().contains("500"));

    }

    @Test
    public void testData(WebElement status, WebElement warningMessage) {
        driver.findElement(practiceLink).click();
        //driver.findElement(By.xpath("//p//following-sibling::ul//li"));
        //Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertTrue(warningMessage.getText().contains(status.getText()));
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{{driver.findElement(choice9), driver.findElement(message)},
                {driver.findElement(choice10), driver.findElement(message)},
                {driver.findElement(choice11), driver.findElement(message)},
                {driver.findElement(choice12), driver.findElement(message)}


        };


    }
}
