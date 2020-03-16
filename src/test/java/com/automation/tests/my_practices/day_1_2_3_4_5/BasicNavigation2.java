package com.automation.tests.my_practices.day_1_2_3_4_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation2 {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        Thread.sleep(2000);

        driver.navigate().to("https://cybertekschool.okta.com/app/UserHome");

        Thread.sleep(2000);

        driver.navigate().back();

        String title = driver.getTitle();

        String expectedTitle = "Amazon";

        if(title.equals(expectedTitle)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.navigate().forward();

        if(driver.getCurrentUrl().contains("cybertekschool")){
            System.out.println("Test Passed!!!");
        }else{
            System.out.println("Test Failed!!!");
        }

        System.out.println("Current url is: "+driver.getCurrentUrl());

        driver.quit();
    }
}
