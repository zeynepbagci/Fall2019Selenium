package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/***Warm-up task for 15 minutes:
        Go to http://practice.cybertekschool.com/tables
        Click on "Last name" column name
        Verfiy that table is sorted by last name in alphabetic order.
*/
public class Day12_Warmup {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
