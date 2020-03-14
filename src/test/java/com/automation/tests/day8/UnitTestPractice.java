package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {

        //unit test
        //to chech if our method works properly
        //if assertion fails, that means our method doesn't work correctly
        //that means we need to fox methos
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        //assertion
        verifyEquals(expected,actual);

    }
    @Test(description= "Verify if method can reverse a string")
    public void test(){

        String expected = "elppa";
        String actual = reverseString("apple");
        Assert.assertEquals(actual,expected);
        //to verify if expected result is equals to actual.
        //it comes from testng, junit also has this class
        //you can compare any data types here: strings, primitives, arrays, object

    }


    public static boolean verifyEquals(String expected,String actual){
        if(expected.equals(actual)){
            System.out.println("Test Passed");
            return true;
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
            return false;
        }
    }

    /**
     * This methos stands for reversing Strings
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str){
        String reversed = "";
        for (int i = str.length()-1; i>=0 ; i--) {

            reversed+=str.charAt(i);

        }
        return reversed;
    }
}
