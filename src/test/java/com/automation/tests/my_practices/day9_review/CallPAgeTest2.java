package com.automation.tests.my_practices.day9_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CallPAgeTest2 {

   private WebDriver driver;
   private By choices = By.cssSelector("li[class='dropdown dropdown-level-1']");



   @BeforeMethod
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.get("https://qa2.vytrack.com/user/login");
       driver.manage().window().maximize();
       driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
       driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
       BrowserUtils.wait(2);

   }
   @Test
    public void test1(){
       Actions actions = new Actions(driver);
       List<WebElement> choices = driver.findElements(By.cssSelector("li[class='dropdown dropdown-level-1']"));
       WebElement activities = choices.get(3);
       actions.moveToElement(activities).perform();
       BrowserUtils.wait(2);
       driver.findElement(By.linkText("Calls")).click();
       BrowserUtils.wait(2);

   }
    /**
     * Scenario: Verify for store manager
     *
     * Login as story manager
     * Go to Activities --> Calls
     * Verify that Log Call button is displayed
     */
   @Test
   public void test2(){

       Actions actions = new Actions(driver);
       List<WebElement> choices = driver.findElements(By.cssSelector("li[class='dropdown dropdown-level-1']"));
       WebElement activities = choices.get(3);
       actions.moveToElement(activities).perform();
       BrowserUtils.wait(2);
       driver.findElement(By.linkText("Calls")).click();
       BrowserUtils.wait(2);

       WebElement logCallButton = driver.findElement(By.cssSelector("a[title='Log call']"));
       Assert.assertTrue(logCallButton.isDisplayed());

   }
   @AfterMethod
    public void tearDown(){
       driver.quit();
   }

}
