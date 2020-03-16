package com.automation.tests.my_practices.day_1_2_3_4_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class FindElementBuild1 {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);

        Thread.sleep(2000);

        String expectedText = "Welcome to the Secure Area. When you are done click logout below.";

        String actualText = driver.findElement(By.className("subheader")).getText();

        if(expectedText.equals(actualText)){
            System.out.println("TEST PASSED");
        }
        else{
            System.out.println("TEST FAILED");
        }

        WebElement logout = driver.findElement(By.linkText("Logout"));

        System.out.println("href attribute of Logout WebElement: "+logout.getAttribute("href"));

        System.out.println("class attribute of Logout WebElement: "+logout.getAttribute("class"));

        Thread.sleep(2000);

        //WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        logout.click();
        Thread.sleep(2000);

        //Lets enter invalid credentials

        driver.findElement(By.name("username")).sendKeys("wrong");

        driver.findElement(By.name("password")).sendKeys("wrong",Keys.ENTER);

        String errorMessage = driver.findElement(By.id("flash-messages")).getText();


        System.out.println(errorMessage);

        driver.quit();

    }
    }

