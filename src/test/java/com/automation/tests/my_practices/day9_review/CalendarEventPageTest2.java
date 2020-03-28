package com.automation.tests.my_practices.day9_review;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Scenario: Verify for store manager
 * Login as story manager
 * Go to Activities --> Calendar Events
 * Verify that Create Calendar Event button is displayed
 */
public class CalendarEventPageTest2 {
    private WebDriver driver;
    private By userName = By.id("prependedInput");
    private By passWord = By.id("prependedInput2");
    private By calendarEvents = By.linkText("Calendar Events");
    private By activities = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createButton = By.cssSelector("a[title='Create Calendar event']");



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        driver.findElement(userName).sendKeys("storemanager85");
        BrowserUtils.wait(2);
        driver.findElement(passWord).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(2);

    }
    @Test
    public void calendarEventTest(){

        Actions actions = new Actions(driver);

        WebElement activities = driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]"));
        actions.moveToElement(activities).perform();

        BrowserUtils.wait(2);
        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        BrowserUtils.wait(2);
        Assert.assertTrue(calendarEvents.isDisplayed());
        BrowserUtils.wait(2);
    }
    @Test
    public void verifyCreateCalendar(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activities)).perform();
        BrowserUtils.wait(2);
        driver.findElement(calendarEvents).click();
        BrowserUtils.wait(2);
        WebElement createBttn = driver.findElement(By.cssSelector("a[title='Create Calendar event']"));
        Assert.assertTrue(createBttn.isDisplayed());

    }

    @Test
    public void verifyDefaultUser(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activities)).perform();
        driver.findElement(calendarEvents).click();
        driver.findElement(createButton).click();

        //Default owner name should be current user
        String currentUser = driver.findElement(By.cssSelector("a[class='dropdown-toggle']")).getText();
        String owner = driver.findElement(By.cssSelector("span[class='select2-chosen']")).getText();
        Assert.assertEquals(currentUser,owner);

        //        Default title should be blank
        WebElement title = driver.findElement(By.id("oro_calendar_event_form_title-uid-5e78bdd08f6a1"));
        Assert.assertTrue(title.getAttribute("value").isEmpty());

        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(By.id("date_selector_oro_calendar_event_form_start-uid-5e78bdd08f8a7")).getText();
        Assert.assertEquals(expectedDate,actualDate);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
