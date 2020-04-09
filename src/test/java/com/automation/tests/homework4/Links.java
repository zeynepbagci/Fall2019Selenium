package com.automation.tests.homework4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Links {

    private WebDriver driver;
    private String URL = "https://www.w3schools.com/";

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void linkTest(){

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for(WebElement eachLink : allLinks){
            if(eachLink.isDisplayed()){
                System.out.println("Text: "+eachLink.getText().trim());
                System.out.println("Link: "+eachLink.getAttribute("href").trim());
            }
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
