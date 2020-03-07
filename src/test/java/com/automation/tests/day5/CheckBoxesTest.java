package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {

        DriverFactory.createDriver("chrome");

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        //verify that 1st checkbox is not selected and 2nd is selected

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
        }


        BrowserUtils.wait(2);

        //let's click on the first checkbox and verify it's clicked
        WebElement checkBox1 = checkBoxes.get(0);
        checkBox1.click();

        if (checkBox1.isSelected()) {
            System.out.println("Test Passed");
            System.out.println("checkBox #1 is selected");
        } else {
            System.out.println("Test Failed");
            System.out.println("checkBox #1 is NOT selected");
        }

        BrowserUtils.wait(2);

        driver.quit();
    }
}

