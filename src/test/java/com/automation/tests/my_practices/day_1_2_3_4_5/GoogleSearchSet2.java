package com.automation.tests.my_practices.day_1_2_3_4_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class GoogleSearchSet2 {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);

        WebElement search =  driver.findElement(By.name("q"));

        search.sendKeys("Java", Keys.ENTER);

        Thread.sleep(2000);

        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(2000);
        

        driver.close();
    }
}
