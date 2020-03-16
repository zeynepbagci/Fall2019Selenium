package com.automation.tests.my_practices.day6_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByTextMultipleOption2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select selectLanguage = new Select(driver.findElement(By.name("Languages")));

        if(selectLanguage.isMultiple()) {
            selectLanguage.selectByVisibleText("Java");
            selectLanguage.selectByVisibleText("JavaScript");

        }

    }
}
