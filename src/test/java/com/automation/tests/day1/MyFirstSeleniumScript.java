package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {

        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedrover object
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("https://www.google.com/");
    }
}
