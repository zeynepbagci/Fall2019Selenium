package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
//import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp1 {

    static WebDriver driver;

    public static void main(String[] args) {
        /** Go to ebay
         enter search term
         click on search button
         print number of results
         go to amazon
         Go to ebay
         enter search term
         click on search button
         verify title contains search term

         Go to wikipedia.org
         enter search term `selenium webdriver`
         click on search button
         click on search result `Selenium (software)`
         verify url ends with `Selenium_(software)`
         *
         */

        // ebayTest();


    }

    public static void ebayTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-hc")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText());
        driver.quit();
    }

    public static void amazonTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("htto://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("n95 mask", Keys.ENTER);

        String title = driver.getTitle();
        if (title.contains("n95 mask")) {
            System.out.println("Test passed");
        } else {
            System.out.println("test failed");
        }

        driver.quit();
    }

    public static void wikiTest() throws Exception {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl(); // to get link as a String
        if (link.endsWith("Selenium_(software)")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }
}
