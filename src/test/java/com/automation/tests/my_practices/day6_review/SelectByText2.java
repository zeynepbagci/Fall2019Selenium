package com.automation.tests.my_practices.day6_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(2);

        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));

        simpleDropdown.selectByVisibleText("Option 2");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1988");

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByVisibleText("May");

        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("17");
        BrowserUtils.wait(3);

        //select all months one by one
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth : months){
            //get the month name and select based on that
            eachMonth.getText();
            selectMonth.selectByVisibleText(eachMonth.getText());
        }

        BrowserUtils.wait(3);
        Select selectSt = new Select(driver.findElement(By.id("state")));
        selectSt.selectByVisibleText("Georgia");
        //option that is currently selected
        //getFirstSelectedOption() -- returns a webelement, that's why we need to call getText(
        //getText() retrieves visible text from the webelement
        String selectedState = selectSt.getFirstSelectedOption().getText();
        if(selectedState.equals("Georgia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = selectSt.getOptions();
        for(WebElement eachState : states){
            System.out.println("state: "+eachState.getText());
        }








        driver.quit();
    }
}
