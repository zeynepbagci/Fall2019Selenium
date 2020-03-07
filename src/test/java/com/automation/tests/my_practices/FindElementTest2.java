package com.automation.tests.my_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.SortedSet;

public class FindElementTest2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> links =  driver.findElements(By.tagName("a"));

        for(WebElement eachLink : links){

            System.out.println(eachLink.getAttribute("href"));
        }

        for (int i = 1; i < links.size(); i++) {
            List<WebElement> links2 =  driver.findElements(By.tagName("a"));
            links2.get(i);
            driver.navigate().back();
            
        }
        driver.quit();

    }
}
