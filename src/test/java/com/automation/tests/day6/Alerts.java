package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();//to click on first button
        BrowserUtils.wait(3);

        String popUpText = driver.switchTo().alert().getText();
        System.out.println(popUpText);
        driver.switchTo().alert().accept();//to click ok
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("EXPECTED: "+expected);
            System.out.println("ACTUAL: "+actual);
        }
        //it will fail because there is a typo
        //###########################################################################

        //let's call another alert
        buttons.get(1).click();
        BrowserUtils.wait(3);
        driver.switchTo().alert().dismiss();//->to click cancel

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You clicked: Cancel";

        if(actualText.equals(expectedText)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expectedText);
            System.out.println("Actual: "+actualText);
        }
        System.out.println("Result Text: "+actualText);

        //TASK-> click on button3
        //enter some text
        //Verify that reslt text ends with it

        //###########################################################################

        buttons.get(2).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Happy Women's Day!");
        alert.accept();

        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "Happy Women's Day!";
        BrowserUtils.wait(3);

        if(actualResult.equals(expectedResult)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected: "+expectedResult);
            System.out.println("Actual: "+actualResult);
        }





        BrowserUtils.wait(3);
        driver.quit();
    }
}
