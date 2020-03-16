package com.automation.tests.my_practices.day6_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectByIndex2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(2);

        Select selectState = new Select(driver.findElement(By.id("state")));

        selectState.selectByIndex(11);

        BrowserUtils.wait(2);

        //selecting last option
        selectState.selectByIndex(selectState.getOptions().size()-1);

        //selecting first option
        selectState.selectByIndex(1);


        driver.quit();

    }
}
