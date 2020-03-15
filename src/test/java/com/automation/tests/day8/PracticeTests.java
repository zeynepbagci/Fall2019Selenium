package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class PracticeTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //HOW TO HANDLE SSL QUESTIONS IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "your connection is not provate issue
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    //we put @Test annotiation to make the methods executable as tests
    @Test
    public void loginTest(){
        //to go form authentication page
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(2);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        String actual = driver.findElement(By.tagName("h4")).getText();

        //if assertion fails, it will throw exception and message will be printed
        //3 parameters: (expected, actual, message - in case of error)
        Assert.assertEquals(actual,expected,"Sub-header message is not matching");

    }
    @Test
    public void forgotPasswordTest(){

        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.name("email")).sendKeys("zenepocan@gmail.com",Keys.ENTER);
        String expected ="Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void chechboxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        WebElement checkbox1 = checkboxes.get(0);
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        //by cssSelector: //input[@type=“checkbox”][1]

    }
}
