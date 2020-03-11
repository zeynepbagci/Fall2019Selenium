package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        WebElement button1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement button2 = driver.findElement(By.cssSelector("[name='button2']"));
        WebElement button3 = driver.findElement(By.cssSelector("[id^='button_']"));
        WebElement button4 =driver.findElement(By.cssSelector("[onclick='button4()']"));
        WebElement button5 = driver.findElement(By.cssSelector("[onclick='button5()']"));
        WebElement button6 = driver.findElement(By.cssSelector("[onclick='button6()']"));

        button1.click();
        BrowserUtils.wait(2);

        button2.click();
        BrowserUtils.wait(2);

        button3.click();
        BrowserUtils.wait(2);

        button4.click();
        BrowserUtils.wait(2);

        button5.click();
        BrowserUtils.wait(2);

        button6.click();
        BrowserUtils.wait(2);

        driver.quit();
    }
}
