package com.automation.tests.my_practices.day_1_2_3_4_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for(WebElement eachRadioButton : radioButtons){

            //if button i eligible to click
            //returns true if you can click on the  button

            String id = eachRadioButton.getAttribute("id");

            if(eachRadioButton.isEnabled()){
                eachRadioButton.click();
                System.out.println(id+ " is clicked");
            }else{
                System.out.println("not able to click "+id);
            }

        }













        driver.quit();
    }
}
