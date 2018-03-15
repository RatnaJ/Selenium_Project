package com.test;

import org.testng.annotations.Test;

public class InvocationCount {

    @Test(invocationCount = 5)
    public void sumInt(){
        int a = 10;
        int b = 20;
        int sum = a+b;
        System.out.println("Sum "+ sum);
    }
}
