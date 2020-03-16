package com.automation.tests.my_practices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(3);
        for (int i = 0; i < checkBoxes.size(); i++) {
            if(checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled()){
                checkBoxes.get(i).click();
                System.out.println("check box "+(i+1) +" is clicked");
            }else{
                System.out.println("check box " +(i+1) +" is not clicked");
            }

        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
