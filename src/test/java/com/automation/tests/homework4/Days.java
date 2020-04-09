package com.automation.tests.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Days {

    private WebDriver driver = Driver.getDriver();

    @Test
    public void daysTest(){

        //step1 --> go to the link
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(5);

        //step2 --> butun gunleri bir list altinda topladim
        List<WebElement> days = driver.findElements(By.xpath("//input[@type='checkbox']//following-sibling::label"));
        int counter = 0;

        //step3 --> counter sifirda oldugu icin, 3 defa yazmasini istedigimden <3 condition koydum
        while (counter<3){

            //step4 --> random class olusturdum
            Random random = new Random();

            int dayToSelect = random.nextInt(days.size());
            //step5 --> eger bu listtedn rastgele aldigim bir gun enable ise tikla , bastir, tejrar tikla ki unclick olsun dedim
            if(days.get(dayToSelect).isEnabled()){
                days.get(dayToSelect).click();
                System.out.println("Selected :: "+ days.get(dayToSelect).getText());
                days.get(dayToSelect).click();
                //step6 --> ama bu tikladigim gun friday ise max 3 kere buu islemi yap, sonra cik dedim
                if(days.get(dayToSelect).getText().toLowerCase().equals("friday")){
                    counter++;
                }
            }
        }

        driver.quit();
    }
}
