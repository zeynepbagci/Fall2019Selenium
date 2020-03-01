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

        driver.manage().window().maximize();//to maximize screen
       // driver.manage().window().fullscreen();
        Thread.sleep(3000);

        String title = driver.getTitle();//returns <title>Some title</title> text
        //method that returns page title
        //you can also see it as tab name int the browser
        //Console will have Google
        System.out.println("Title is: "+title);

        String expectedTitle = "Google";

        if(expectedTitle.equals(title)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }

        //go to another website within the same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        //come back to google
        driver.navigate().back();
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(),"Google");

        //move forward in the browser history
        driver.navigate().forward();
        System.out.println("Title: "+driver.getTitle());//-->again going to amazon
        //driver.getTitle() returns the page name that ve currently opened



        Thread.sleep(3000);//for demo, wait 3 seconds


        System.out.println("URL: "+driver.getCurrentUrl());//to get current url


        driver.navigate().refresh();//to reload page
        Thread.sleep(3000);



        //must be at the end
        driver.close();//to close driver
        //browser can't close itself

    }
    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }


    }
}
