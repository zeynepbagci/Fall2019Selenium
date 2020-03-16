package com.automation.tests.my_practices.day_1_2_3_4_5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.findElement(By.name("firstname")).sendKeys("Zeynep", Keys.ENTER);

        driver.findElement(By.name("lastname")).sendKeys("Bagci",Keys.ENTER);

        driver.findElement(By.name("username")).sendKeys("zezezeze",Keys.ENTER);

        driver.findElement(By.name("email")).sendKeys("zeze@gmail.com",Keys.ENTER);

        driver.findElement(By.name("password")).sendKeys("zeze123123",Keys.ENTER);

        driver.findElement(By.name("phone")).sendKeys("123-456-7890",Keys.ENTER);

        List<WebElement> genders = driver.findElements(By.name("gender"));

        genders.get(1).click();

        driver.findElement(By.name("birthday")).sendKeys("05/17/1988",Keys.ENTER);


        List<WebElement> departments = driver.findElements(By.name("department"));
        departments.get(1).click();
        BrowserUtils.wait(2);

        List<WebElement> jobTitles = driver.findElements(By.name("job_title"));
        jobTitles.get(5).click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(2);
        driver.quit();

    }
}
