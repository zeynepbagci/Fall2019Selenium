package com.automation.tests.my_practices.day8_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BasicTestNGTests2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @Test(description = "Login functionality")
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.name("email")).sendKeys("zen@gmail.com",Keys.ENTER);
        String expected ="Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkBoxTest(){

        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement checkBox1 = checkBoxes.get(0);
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
