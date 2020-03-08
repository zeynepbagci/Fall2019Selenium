package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelected = new Select(driver.findElement(By.id("state")));

        //index starts from 0
        stateSelected.selectByIndex(9);//District Of Columbia

        //select last option
        stateSelected.selectByIndex(stateSelected.getOptions().size()-1);

        driver.quit();
    }
}
