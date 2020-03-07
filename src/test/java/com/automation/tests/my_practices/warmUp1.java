package com.automation.tests.my_practices;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class warmUp1 {

    public static void main(String[] args) {

        //ebayTest();
        //amazonTest();

        wikipediaTest();
    }
    /**
     * Go to ebay
     *          enter search term
     *          click on search button
     *          print number of results
     */
    public static void ebayTest(){

        WebDriver driver =DriverFactory.createDriver("chrome");

        driver.get("https://www.ebay.com/");

        driver.findElement(By.id("gh-ac")).sendKeys("nail polish", Keys.ENTER);

        String result = driver.findElement(By.tagName("h1")).getText();

        System.out.println(result);

        driver.quit();

    }
   /** go to amazon
    Go to ebay
    enter search term
    click on search button
    verify title contains search term**/
   public static void amazonTest(){

       WebDriver driver = DriverFactory.createDriver("chrome");

       driver.get("https://www.amazon.com");

       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Book",Keys.ENTER);

       String title = driver.getTitle();

       if(title.contains("Java Book")){
           System.out.println("TEST PASSED");
       }
       else{
           System.out.println("TEST FAILED");
       }

       driver.quit();
   }

    /**
     *  Go to wikipedia.org
     *          enter search term `selenium webdriver`
     *          click on search button
     *          click on search result `Selenium (software)`
     *          verify url ends with `Selenium_(software)`
     */
    public static void wikipediaTest(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new  ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);

        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        String url = driver.getCurrentUrl();

        if(url.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }
        else{
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
