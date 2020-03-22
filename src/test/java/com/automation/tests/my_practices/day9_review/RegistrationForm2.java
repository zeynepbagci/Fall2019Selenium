package com.automation.tests.my_practices.day9_review;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationForm2 {

    private WebDriver driver;

    private By firstName = By.name("firstname");

    private By lastName = By.name("lastname");

    private By userName = By.name("username");

    private By email = By.name("email");

    private By password = By.name("password");

    private By phone = By.name("phone");

    private By male = By.cssSelector("input[value='male']");

    private By female = By.cssSelector("input[value='female']");

    private By other = By.cssSelector("input[value='other']");

    private By birthday = By.name("birthday");

    private By department = By.name("department");

    private By jobTitle = By.name("job_title");

    private By cPlus = By.id("inlineCheckbox1");

    private By Java = By.id("inlineCheckbox2");

    private By JavaScript = By.id("inlineCheckbox3");

    private By signUp = By.id("wooden_spoon");


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

    }

    @Test(description = "signing in")
    public void test1(){

        driver.findElement(firstName).sendKeys("Zeynep");
        BrowserUtils.wait(2);
        driver.findElement(lastName).sendKeys("Bagci");
        BrowserUtils.wait(2);
        driver.findElement(userName).sendKeys("as123456");
        BrowserUtils.wait(2);
        driver.findElement(email).sendKeys("acbg@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(password).sendKeys("ahmet2928");
        BrowserUtils.wait(2);
        driver.findElement(phone).sendKeys("123-456-7889");
        BrowserUtils.wait(2);
        driver.findElement(female).click();
        BrowserUtils.wait(2);
        driver.findElement(birthday).sendKeys("05/17/1988");
        BrowserUtils.wait(2);
        driver.findElement(department).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("option[value='DE']")).click();
        BrowserUtils.wait(2);
        driver.findElement(jobTitle).click();
        BrowserUtils.wait(2);
        List<WebElement> jobTitles = driver.findElements(By.cssSelector("select[name='job_title']>option"));
        jobTitles.get(5).click();
        BrowserUtils.wait(2);
        driver.findElement(Java).click();
        BrowserUtils.wait(2);
        driver.findElement(signUp).click();

        String actualText = driver.findElement(By.xpath("//h4[@class='alert-heading']//following-sibling::p")).getText();

        String expectedText = "You've successfully completed registration!";

        Assert.assertEquals(actualText,expectedText);

    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }






}

