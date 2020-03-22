package com.automation.tests.day11;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //see it to tru to make it work
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);//no run browser without GUI. Makes browser invisible
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
    @Test
    public void getColumnNames(){
        //th-represents table header cells
        List<String>expected = Arrays.asList("Last Name","First Name","Email","Due","Web Site","Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        //just to print
        for(WebElement eachColumnName : columnNames){
            System.out.println(eachColumnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);

    }
    @Test
    public void verifyRowCount(){
        // //tbody//tr - to get al rows from tabel body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        Assert.assertEquals(rows.size(),4);
    }
    /**
     * to get secific column, skip row index, adn just provide td index
     */
    @Test
    public void getSpecificColumn(){
        List<WebElement> link = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(link));
    }
    /** TASK until 4:45
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */

    //table[1]//tbody//tr//following-sibling::td//a[2]
    @Test
    public void verifyDeleted(){
        driver.findElement(By.xpath("//table[1]//tbody//tr//following-sibling::td//a[2]")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),3);

    }
    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size() ; i++) {
            if(columnNames.get(i).getText().equals(columnName)){
                index = i+1;
                break;
            }

        }
        Assert.assertEquals(index,3);
    }

    @Test
    public void getSpecificCell(){
        String expected ="http://www.jdoe.com";
        int row=3;
        int column=5;
        String xpath="//table[1]//tbody//tr[" +row+ "]//td["+column+"]";

        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(),expected);

    }



}
