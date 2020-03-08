package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));

        //Select class that comes from Selenium
        //provide webelement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //seelct by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);

        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1988");
        BrowserUtils.wait(2);

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByVisibleText("May");
        BrowserUtils.wait(2);

        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("17");


        //select all months one by one
        //.getOptions(); - returns al options fro dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth : months){
          //get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(5);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Georgia");

        //option that is currently selected
        //getFirstSelectedOption() -- returns a webelement, that's why we need to call getText(
        //getText() retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("Georgia")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }


        List<WebElement> states = stateSelect.getOptions();
        for(WebElement eachState : states){
            System.out.println(eachState.getText());
        }




        BrowserUtils.wait(3);
        driver.quit();
    }
}
