package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementsIsGone {

    //how to verify if element does not exist anymore
    //InterviewQoestion
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if(driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }

        //to find all buttons
        //make sure that you use findElements----ending is important
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for(WebElement eachButton : buttons){
            //click on every button
            eachButton.click();
            Thread.sleep(2000);
            //burada sayfa refresh etmicek dedi o yuzden sorun yokmus
            //bu kismi pek anlamadim ama, zamanla oturack insaallah

        }

        driver.quit();
    }
}
