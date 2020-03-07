package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));

        //eger button gercekten varsa, we click edilebiliyorsa
        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("Clicked on black button");

        blackButton.click();}
        else {
            System.out.println("Failed to click black button");
        }

        BrowserUtils.wait(2);

        if(blackButton.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
