package com.automation.tests.my_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow2 {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(3000);

        String windowHande = driver.getWindowHandle();

        System.out.println("windowHande = " + windowHande);

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles = " + windowHandles);

        System.out.println("Before switch: "+driver.getCurrentUrl());

        for(String each : windowHandles){

            if(!each.equals(windowHande)){

            driver.switchTo().window(each);}

        }

        Thread.sleep(5000);
        System.out.println("After switch: "+driver.getCurrentUrl());

        driver.close();

    }
}
