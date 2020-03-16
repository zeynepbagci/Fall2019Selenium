package com.automation.tests.my_practices.day_1_2_3_4_5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        //verify that 1st checkbox is not selected and 2nd is selected

        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){

            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(2);

        //let's click on the first checkbox and verify it's clicked
        checkBoxes.get(0).click();
        if(checkBoxes.get(0).isSelected()){
            System.out.println("Test passed");
            System.out.println("CheckBox #1 is selected");
        }
        else{
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}
