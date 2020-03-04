package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        WebElement name = driver.findElement(By.name("username"));
        name.sendKeys("tomsmith");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("wooden_spoon"));

        Thread.sleep(2000);

        button.click();

        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        String actual = driver.findElement(By.tagName("h4")).getText();

        if(expected.equals(actual)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed");
        }

        //let's click on logout button
        //it looks like a button but it is actually a link
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkText instad of Linktest
        //linkTest - equals()
        //partialLinkText - contains() - complete match doesn't required
        //don't put space

        //WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        //logout.click();
        //Thread.sleep(2000);

        //orange-->attribute
        WebElement logout = driver.findElement(By.linkText("Logout"));

        String href = logout.getAttribute("href");

        String classNAme = logout.getAttribute("class");

        System.out.println(href);

        System.out.println(classNAme);

        //let's enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());

        Thread.sleep(2000);

        driver.close();

    }
}
