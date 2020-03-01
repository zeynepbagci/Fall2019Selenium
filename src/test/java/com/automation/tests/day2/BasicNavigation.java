package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {

        //to start selenium script we need:
        //setup webdriver and create webdriver object

        WebDriverManager.chromedriver().setup();

        //we will run tests in ChromeDriver();
        WebDriver driver = new ChromeDriver();
        //because  I'll use chrome
        //in selenium, everything starts from WebDriver Interface
        //ChromeDriver is a class obviously
        //ChromeDriver extends RemoteWebDriver--> implements WebDriver
        driver.get("http://google.com");//to open a website
        Thread.sleep(3000);//for demo, wait 3 seconds
        driver.close();//to close driver

    }
}
