package com.automation.tests.my_practices.day9_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//verify that warning message displays when user enters invalid username

public class LoginPageTest2 {

    private WebDriver driver;
    private By userName = By.id("prependedInput");
    private By passWord = By.id("prependedInput2");
    private By alert = By.xpath("//div[@class='alert alert-error']//div");


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");
       // driver.findElement(userName).sendKeys("abc");
       // driver.findElement(passWord).sendKeys("UserUser123", Keys.ENTER);

        BrowserUtils.wait(3);
    }

    @Test
    public void alert(){

        Assert.assertTrue(driver.findElement(alert).isDisplayed());

    }
    @Test(description = "Login as store manager and verify that title is equals to Dashboard")
    public void dashboardTest(){
        driver.findElement(userName).sendKeys("storemanager85");
        driver.findElement(passWord).sendKeys("UserUser123",Keys.ENTER);
        String acttualTitle =  driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(acttualTitle,expectedTitle);

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
