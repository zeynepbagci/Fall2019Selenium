package com.automation.tests.my_practices.day7_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        driver.findElement(By.cssSelector(".nav-link"));
        driver.findElement(By.cssSelector(".h3"));

        driver.findElement(By.cssSelector("[onclick='button1()']")).click();
        driver.findElement(By.cssSelector("[onclick='button2()']")).click();
        driver.findElement(By.cssSelector("[onclick='button3()']")).click();
        driver.findElement(By.cssSelector("[onclick='button4()']")).click();
        driver.findElement(By.cssSelector("[onclick='button5()']")).click();


    }
}
