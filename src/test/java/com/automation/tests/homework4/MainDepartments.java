package com.automation.tests.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainDepartments {

    private WebDriver driver;
    private String URL = "https://www.amazon.com/gp/site-directory";
    private By allDepartmentsDropdown = By.cssSelector("#searchDropdownBox");
    private By mainDepartmentNames = By.cssSelector("h2[class='fsdDeptTitle']");

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);


    }

    @Test
    public void mainDepartmentsTest(){

      List <WebElement> departments = driver.findElements(mainDepartmentNames);

      List<String> departmentNames = new ArrayList<>();

      for(WebElement eachDepartment : departments){
          eachDepartment.getText();
          departmentNames.add(eachDepartment.getText().trim());
      }
        Select deprtments = new Select(driver.findElement(allDepartmentsDropdown));

      List<WebElement> departmentsDropDown = deprtments.getOptions();
      List<String> dropDownName = new ArrayList<>();

      for(WebElement eachDropDown : departmentsDropDown){

          eachDropDown.getText();
          dropDownName.add(eachDropDown.getText().trim());
      }

      for(String eachName : departmentNames){
          Assert.assertTrue(dropDownName.contains(eachName),"Expected");
      }
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
