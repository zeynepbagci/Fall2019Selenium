package com.automation.tests.my_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-right");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        driver.findElement(By.tagName("body")).getText();
    }
}
