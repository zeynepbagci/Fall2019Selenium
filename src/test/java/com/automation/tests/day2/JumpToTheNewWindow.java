package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.jcp.xml.dsig.internal.SignerOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        //getWindowHandles() this method return id's of all currently opened windows
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH "+driver.getCurrentUrl());

        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window id

        //since Set has no get method
        for (String eachWindowID: windowHandles){
            if(!eachWindowID.equals(windowHandle)){

                //to jump to the new window
                driver.switchTo().window(eachWindowID);
            }
        }
        System.out.println("AFTER SWITCH "+ driver.getCurrentUrl());
        driver.close();
    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){

        Set<String> windows = driver.getWindowHandles();
        for(String eachWindow :windows){
            driver.switchTo().window(eachWindow);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
