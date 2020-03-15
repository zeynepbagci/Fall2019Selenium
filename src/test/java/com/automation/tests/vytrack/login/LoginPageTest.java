package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//STATIC IMPORT OF ALL ASSORTIONS
import java.security.Key;

import static org.testng.Assert.*;
//Assert class cagirmadan direk assertionlari cagirmak icn zaar

public class LoginPageTest {
    private WebDriver driver;
    //https is a secured version of http protocol
    //http - it's hypertext transfer ptorocol that every single website is using nowadays
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    private String URL ="https://qa2.vytrack.com/user/login";
    private By username = By.id("prependedInput");//to remind that By is a class
    private By password = By.id("prependedInput2");
    //> in css selector means same thing as / in xpath - direct child
    //yni bu classin alt classindaki div e git diyorum >
    private By warningMessage = By.cssSelector("[class='alert alert-error']>div");

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUserName(){

        driver.findElement(username).sendKeys("invalid username");
        driver.findElement(password).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessage);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);
    }
    @Test(description = "Login as store manager and verify that title is equals to Dashboard")
    public void LoginAsStoreManager(){
        driver.findElement(username).sendKeys("storemanager85");
        driver.findElement(password).sendKeys("UserUser123", Keys.ENTER);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(expected,actual,"Page title is not correct");
    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(){
        //if webdriver object alive
        if(driver!=null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}
