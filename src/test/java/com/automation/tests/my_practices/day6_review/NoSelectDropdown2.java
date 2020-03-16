package com.automation.tests.my_practices.day6_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropdown2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click();

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));

        for(WebElement eachLink : allLinks){
            System.out.println(eachLink.getText()+" ---> "+eachLink.getAttribute("href"));
        }


        driver.findElement(By.linkText("Amazon")).click();

        driver.quit();

    }

}
