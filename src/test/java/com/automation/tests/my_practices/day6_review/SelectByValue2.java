package com.automation.tests.my_practices.day6_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select stateSelection = new Select(driver.findElement(By.id("state")));
        stateSelection.selectByValue("GA");

        String expected = "Georgia";
        String actual = stateSelection.getFirstSelectedOption().getText();
        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();

    }
}
