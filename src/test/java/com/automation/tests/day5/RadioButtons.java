package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class RadioButtons {

    public static void main(String[] args)  {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        //<input type="radio">, radio buttinlarin ortal ozelligi bu, bunu kullanarak toplucam
        //butun input;ari toplucam simdi

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));


        for(WebElement eachButton : radioButtons){
            //if button i eligible to click
            //returns true if you can click on the  button

           String id = eachButton.getAttribute("id");

           boolean isSelected = eachButton.isSelected();
            System.out.println(id+" is selected? "+isSelected);

            if(eachButton.isEnabled()){
                eachButton.click();
                System.out.println("Clicked on: "+eachButton.getAttribute("id"));
            }else{
                System.out.println("Button is disabled, not clicked : :");
            }

            BrowserUtils.wait(1);
        }

        driver.quit();
    }
}
