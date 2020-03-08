package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));

        //Whether this select element support selecting multiple options at the same time?
        //This is done by checking the value of the "multiple" element.
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);//-->if this is true, you can select more than one option

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");


        //Let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for(WebElement eachLanguage : selectedLanguages){
            System.out.println(eachLanguage.getText());
        }

        BrowserUtils.wait(3);
        languagesSelect.deselectByVisibleText("Python");//to unselect something

        BrowserUtils.wait(3);
        languagesSelect.deselectAll();


        BrowserUtils.wait(3);
        driver.quit();
    }
}
