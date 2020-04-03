package com.automation.tests.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase6 {

    private WebDriver driver;
    private By fullname = By.name("full_name");
    private By email = By.name("email");
    private By signUpMessage = By.name("signup_message");

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();

    }
    @Test
    public void verifyMessage(){
        //step1
        driver.get("https://www.fakemail.net/");
        BrowserUtils.wait(1);
        //step2
        String email2 = driver.findElement(By.id("email")).getText();
        //step3
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(1);
        //step4
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(1);
        //step5
        driver.findElement(fullname).sendKeys("Zeynep Bagci");
        BrowserUtils.wait(1);
        //step6-7
        driver.findElement(email).sendKeys(email2, Keys.ENTER);
        BrowserUtils.wait(1);
        //step8
        Assert.assertTrue(driver.findElement(signUpMessage).isDisplayed());
        BrowserUtils.wait(1);
        //step9
        driver.get("https://www.fakemail.net/");
        BrowserUtils.wait(1);
        //step10
        WebElement emailFr = driver.findElement(By.xpath("//tbody[@id='schranka']//tr[1]"));
        Assert.assertTrue(emailFr.isDisplayed());
        //step11
        emailFr.click();
        //step12
        String emailFrom = driver.findElement(By.id("odesilatel")).getText();
        BrowserUtils.wait(1);
        Assert.assertEquals(emailFrom,"do-not-reply@practice.cybertekschool.com");
        //step13
        Assert.assertEquals(driver.findElement(By.id("predmet")).getText(),"Thanks for subscribing to practice.cybertekschool.com!");

    }

    @AfterTest
    public void tearDown(){
        BrowserUtils.wait(1);
        driver.quit();
    }
}
