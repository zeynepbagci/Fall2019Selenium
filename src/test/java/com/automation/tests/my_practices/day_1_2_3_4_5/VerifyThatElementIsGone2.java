package com.automation.tests.my_practices.day_1_2_3_4_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone2 {

    public static void main(String[] args) throws Exception {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();

        Thread.sleep(2000);

        if(driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }


        //to find all buttons
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for(WebElement  eachButton : buttons){

            System.out.println(eachButton.getText());

        }


        driver.quit();

    }
}
