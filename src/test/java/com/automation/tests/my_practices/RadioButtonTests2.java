package com.automation.tests.my_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTests2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //black tiklanip tiklanmiyor mu onu test edicem simdi

        WebElement blackButton = driver.findElement(By.id("black"));

        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            blackButton.click();

        }else{
            System.out.println("Not able to click");
        }
        if( blackButton.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        driver.quit();
    }
}
