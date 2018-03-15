package com.test;

import org.testng.annotations.Test;

public class TestngFeatures {

    @Test
    public void loginTest(){
        System.out.println("Login Page");
        //int y = 8/0;

    }


    @Test(dependsOnMethods = "loginTest")
    public void homePage(){
        System.out.println("Home Page");

    }

@Test(dependsOnMethods = "loginTest")
    public void searchPage(){
        System.out.println("Search Page results");
    }

    @Test(dependsOnMethods = "loginTest")
    public void registrationPage(){
        System.out.println("Registration Page ");
    }
}
