package com.automation.tests.my_practices.day6_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_review {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick = 'button1()']"));
        button1.click();
        System.out.println(driver.findElement(By.id("result")).getText());

        WebElement button2 = driver.findElement(By.xpath("//*[@onclick ='button2()']"));
        button2.click();
        System.out.println(driver.findElement(By.id("result")).getText());

        WebElement button3 = driver.findElement(By.xpath("//button[@onclick='button3()']"));
        button3.click();
        System.out.println(driver.findElement(By.id("result")).getText());

        WebElement button4 = driver.findElement(By.xpath("//button[@onclick='button4()']"));
        button4.click();
        System.out.println(driver.findElement(By.id("result")).getText());

        WebElement button5 = driver.findElement(By.xpath("//button[@onclick='button5()']"));
        button5.click();
        System.out.println(driver.findElement(By.id("result")).getText());

        WebElement button6 = driver.findElement(By.xpath("//button[@onclick='button6()']"));
        button6.click();
        System.out.println(driver.findElement(By.id("result")).getText());









        driver.quit();
    }
}
