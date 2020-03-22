package com.automation.utilities;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static void wait(int seconds){

        try{
        Thread.sleep(1000*seconds);}catch (InterruptedException e){
            e.printStackTrace();//what we see on the console output
        }
    }
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for(WebElement element : elements){
            textValues.add(element.getText());
        }
        return textValues;
    }

}
