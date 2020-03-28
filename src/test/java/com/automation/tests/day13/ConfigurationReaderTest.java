package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){

        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
        String url = ConfigurationReader.getProperty("qa1");
        System.out.println(url);
        String color = ConfigurationReader.getProperty("color");
        System.out.println(color);
        String storeManager = ConfigurationReader.getProperty("store_manager");
        System.out.println(storeManager);
        String password = ConfigurationReader.getProperty("password");
        System.out.println(password);
        String driver = ConfigurationReader.getProperty("driver");
        System.out.println(driver);
    }

}
