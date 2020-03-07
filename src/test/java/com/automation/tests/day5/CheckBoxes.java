package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        DriverFactory.createDriver("chrome");

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        //checkBoxes.get(0).click();//click on the first checkbox

        BrowserUtils.wait(2);


        for (int i = 0; i <checkBoxes.size(); i++) {


            //if visible                    and     //eligible to click          and  //not clicked yet
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(i).isSelected())) {

                checkBoxes.get(i).click();//clcik on the second checkbox
                System.out.println(i+1+". checkbox is clicked!");
            }else{
                System.out.println(i+1+". checkbox wasn't clicked!");
            }

        }
        BrowserUtils.wait(2);


        driver.quit();
    }
}
