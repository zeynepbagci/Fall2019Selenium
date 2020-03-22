package com.automation.tests.my_practices.day9_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * ######## TASK
 * under fleet package create a class called VehiclesPageTests
 * In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part.
 * Use LoginPageTests class as a reference.
 * create a test called verifyPageSubTitle
 *     - in this test, you will need to navigate to Fleet --> Vehicles
 *     and verify that page subtitle is equals to "All Cars"
 *     user assertions for validation.
 */
public class VehiclePageTest {

    private WebDriver driver;

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By userName = By.id("prependedInput");
    private By passWord = By.id("prependedInput2");
    private By logIn = By.id("_submit");
    private By fleet = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subTitleActual = By.className("oro-subtitle");
    private By pageNumber = By.cssSelector("input[type='number']");


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(userName).sendKeys(username);
        driver.findElement(passWord).sendKeys(password);
        driver.findElement(logIn).click();
        BrowserUtils.wait(3);
    }

    @Test
    public void verifyPageSubtitle(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleet)).perform();
        driver.findElement(By.linkText("Vehicles")).click();
        String expectedSubtitle = "All Cars";
        String actualSubtitle = driver.findElement(subTitleActual).getText();
        Assert.assertEquals(actualSubtitle,expectedSubtitle);
    }

    @Test
    public void verifyPageNumber(){
        String  expected = "1";
        String actual = driver.findElement(pageNumber).getAttribute("value");
        Assert.assertEquals(expected,actual);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}