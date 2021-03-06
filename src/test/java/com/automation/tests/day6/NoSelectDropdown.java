package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropdown {
    //how to handle no select dropdown ?
//click on menu click on options

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click();//to expand dropdown

        BrowserUtils.wait(2);

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));

        for(WebElement eachLink : allLinks){
            System.out.println(eachLink.getText()+" : "+eachLink.getAttribute("href"));
        }

        driver.findElement(By.linkText("Amazon")).click();//click on option


        //INTERVIEW QUESTION
//From selenium perspective there are 2 types of dropdowns : select and other
//To handle select drop-downs, use Select class from selenium
//In case of any other dropdown, just click on, wait until options become visible and click on the option
//how to determine which option is drop down and which is not?
//just look at tag name, if it is select than dropdown type is select

        BrowserUtils.wait(3);
        driver.quit();
    }
}
