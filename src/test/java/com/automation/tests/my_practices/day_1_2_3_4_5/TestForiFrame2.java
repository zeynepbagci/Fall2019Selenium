package com.automation.tests.my_practices.day_1_2_3_4_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

       WebElement text =  driver.findElement(By.id("tinymce"));
       text.getText();

       text.clear();

       text.sendKeys("Hello World", Keys.ENTER);



    }
}
