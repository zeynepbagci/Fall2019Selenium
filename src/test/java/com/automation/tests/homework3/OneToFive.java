package com.automation.tests.homework3;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OneToFive {

    private WebDriver driver;

    private By registrationForm = By.linkText("Registration Form");


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(1);
        driver.manage().window().maximize();
    }
    @Test
    public void testCase1(){

        driver.findElement(registrationForm).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("birthday")).sendKeys("wrong-dob", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningForBirthday =  driver.findElement(By.cssSelector("small[data-bv-result='INVALID']"));
        Assert.assertTrue(warningForBirthday.isDisplayed());

    }
    @Test
    public void testCase2(){
        driver.findElement(registrationForm).click();
        BrowserUtils.wait(3);
        List<WebElement> languages = driver.findElements(By.cssSelector("div[class='form-check form-check-inline']"));
        for (int i = 0; i <languages.size() ; i++) {
            Assert.assertTrue(languages.get(i).isDisplayed());
        }
    }
    @Test
    public void testCase3(){
        driver.findElement(registrationForm).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("firstname")).sendKeys("a",Keys.ENTER);

        WebElement warning = driver.findElement(By.cssSelector("small[data-bv-result=\"INVALID\"]"));
        Assert.assertTrue(warning.isDisplayed());
    }
    @Test
    public void testCase4(){
        driver.findElement(registrationForm).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("lastname")).sendKeys("b",Keys.ENTER);
        WebElement warning = driver.findElement(By.cssSelector("small[data-bv-result='INVALID']"));
        Assert.assertTrue(warning.isDisplayed());
    }

    @Test
    public void testCase5(){
        driver.findElement(registrationForm).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("firstname")).sendKeys("Zeynep");
        BrowserUtils.wait(1);
        driver.findElement(By.name("lastname")).sendKeys("Bagci");
        BrowserUtils.wait(1);
        driver.findElement(By.name("username")).sendKeys("zeyzey");
        BrowserUtils.wait(1);
        driver.findElement(By.name("email")).sendKeys("abx@gmail.com");
        BrowserUtils.wait(1);
        driver.findElement(By.name("password")).sendKeys("abcd1234");
        BrowserUtils.wait(1);
        driver.findElement(By.name("phone")).sendKeys("404-819-6654");
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("input[value='female']")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.name("birthday")).sendKeys("05/17/1988");
        BrowserUtils.wait(1);
        Select departmentSelection = new Select(driver.findElement(By.name("department")));
        departmentSelection.selectByVisibleText("Department of Engineering");
        BrowserUtils.wait(1);
        Select jobTitlesSelection = new Select(driver.findElement(By.name("job_title")));
        jobTitlesSelection.selectByVisibleText("SDET");
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("input[value='java']")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.id("wooden_spoon")).click();


        WebElement actualText = driver.findElement(By.cssSelector("div[class='alert alert-success']>p"));

        Assert.assertTrue(actualText.isDisplayed());


    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
