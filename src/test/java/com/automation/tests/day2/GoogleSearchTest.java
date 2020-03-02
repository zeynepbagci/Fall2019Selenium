package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class GoogleSearchTest {

    public static void main(String[] args) throws  Exception {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("q"));//google search box kodunun adi q
        //web element represents one particular object
        //By.name("q")--> name = "q"
        //name - it's one of the seleniu locators
        //there are 8 locators
        //we use locators to find elements
        //to choose locator, just use By.locator
        //once we found an element, how to enter text?
        //ti enter text, use sendKeys method
        //how to press enter after entering the text?
        //use Keys.ENTER
        //Keys.ENTER--> perform keyboard click
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);
        //Thread.sleep() - is used to pause Java program



        //if see <a> element, it calls link
        //visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();//to click on the element
        Thread.sleep(3000);

        driver.quit();
    }
}
