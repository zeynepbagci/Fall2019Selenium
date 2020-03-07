package com.automation.tests.my_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice1 {

    public static void main(String[] args) throws Exception{

        //simdi ben practice sayfasindan sign up yapicam
        //sonra basariyla sign in olup olmadigimi text leri kiyaslayarak gorcem

        WebDriverManager.chromedriver().setup();

        WebDriver driver =  new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.name("full_name")).sendKeys("Zeynep Bagci");

        driver.findElement(By.name("email")).sendKeys("zenepozcan@gmail.com");

        driver.findElement(By.name("wooden_spoon")).click();

        Thread.sleep(3000);

        String text = driver.findElement(By.name("signup_message")).getText();

        String myText = "Thank you for signing up. Click the button below to return to the home page.";

        if(text.equals(myText)){
            System.out.println("TEST PASSED!");
        }
        else{
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
