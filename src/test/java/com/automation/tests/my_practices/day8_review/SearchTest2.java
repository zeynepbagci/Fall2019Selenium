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

public class SearchTest2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @Test
    public void googleSearchTest(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        List<WebElement> searchItems = driver.findElements(By.className("LC20lb DKV0Md"));
        for(WebElement eachSearchItem : searchItems){
            Assert.assertTrue(eachSearchItem.getText().toLowerCase().contains("java"));
        }

    }

    @Test
    public void amazonSearchTest(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java",Keys.ENTER);
        List<WebElement> searchResults = driver.findElements(By.xpath("//h2//a"));//typerlink
       WebElement result1 = searchResults.get(0);
       result1.click();
       String title = driver.findElement(By.id("productTitle")).getText();
       Assert.assertTrue(title.contains("Java"));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
