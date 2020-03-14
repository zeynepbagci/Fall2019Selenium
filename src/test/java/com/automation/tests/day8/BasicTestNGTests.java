package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    //runs only once before class and
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }


    //runs only once in the class before @beforemethod and before any test
    //regardless on number of tests, it runs only once
    //So if we want to run something before all methods we use it
    //Before class and after class used only once

    @BeforeClass
    //something that should be done only once in the class before all tests
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }
    //runs before every test automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public void setup(){//names are whatever we pick
        System.out.println("BEFORE METHOD");
    }
    //runs automatically after every test
    @AfterMethod
    public void teardown(){//names are whatever we pick
        System.out.println("AFTER METHOD");
    }


    @Test
    public void test1(){
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test2(){
        System.out.println("TEST 2");
        int num1 =5;
        int num2 = 10;
        Assert.assertTrue(num1<num2);
    }




}
