package com.automation.tests.my_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class FIndElementTest1 {

    public static void main(String[] args) throws Exception{


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);

        //yukaridaki sayfada cikan butun linkleri bul dedi
        //ana sayfadaki butun linkleri buraya topladim

       List<WebElement> links = driver.findElements(By.tagName("a"));

       //bu linkleri basicam simdi konsola

        for(WebElement eachLink : links){
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
            //href gets attributes so we can read these properties.
            System.out.println();

        }

        for (int i = 1; i <links.size() ; i++) {

            List<WebElement> links2 = driver.findElements(By.tagName("a"));

            links2.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);

        }

        driver.quit();
    }
}
