package com.automation.tests.my_practices.day6_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();

        String popUpText = driver.switchTo().alert().getText();

        System.out.println(popUpText);

        driver.switchTo().alert().accept();

        String expected = "You successfuly clicked an alert";

        String actual = driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        buttons.get(1).click();
        BrowserUtils.wait(3);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        String expected2 = "You clicked: Ok";
        String actual2 =driver.findElement(By.id("result")).getText();
        BrowserUtils.wait(3);
        if(expected2.equals(actual2)){
            System.out.println("TEST2 PASSED!");
        }else {
            System.out.println("TEST2 FAILED");
            System.out.println("expected result: "+expected2);
            System.out.println("actual result: "+actual2);
        }

        buttons.get(2).click();
        driver.switchTo().alert().sendKeys("Ben geldimmmmm");
        driver.switchTo().alert().accept();

        String expectedResult = "You entered: Ben geldimmmmm";
        String actualResult = driver.findElement(By.id("result")).getText();








        driver.quit();
    }
}
