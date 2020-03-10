package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        //value can be inside single quotes or double quotes
        //if you don't know the tag name, or want to skip tag name, use *
        //for example //*[@onclick='button1()']
        //* means any tag name
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());




        BrowserUtils.wait(3);
        driver.quit();
    }
}
