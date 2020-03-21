package com.automation.tests.my_practices.day8_review;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {


    public static String reverseString(String str){

        String reversed = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            reversed+=str.charAt(i);
        }

        return reversed;
    }

    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("Test Passed");
            return true;
        }else{
            System.out.println("Test Failed");
            return false;
        }

    }

    @Test(description = "verify method can reverse a String")
    public void test(){

        String expected="elppa";
        String actual =reverseString("apple");

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test2(){
        String expected = "rac";
        String actual = reverseString("ca");
        Assert.assertEquals(expected,actual);
    }

    public static void main(String[] args) {

        String expected = "cba";
        String str = "abc";
        String actual = reverseString(str);
        verifyEquals(expected,actual);
    }


}
