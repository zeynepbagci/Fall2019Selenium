package com.automation.tests.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class DepartmentsSort {

    private WebDriver driver;
    private By defaultSearchLabel = By.cssSelector("span[class='nav-search-label']");

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        driver.get("https://www.amazon.com/");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
       WebElement all = driver.findElement(By.cssSelector("option[selected='selected']"));
       Assert.assertTrue(all.isSelected());
    }

    @Test
    public void test2() {

        List<WebElement> allDepartmenst = driver.findElements(By.cssSelector("#searchDropdownBox>option"));
        for (int i = 0; i < allDepartmenst.size()-1 ; i++) {
            String first = allDepartmenst.get(i).getText();
            String second = allDepartmenst.get(i+1).getText();

            if(first.compareTo(second)>0){
                System.out.println("not alphabetically");
                break;
            }

        }

        
    }
    @AfterMethod
    public void terDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
