package com.test;


import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class ExceptionTimeOutTest {
    @Test(expectedExceptions = NumberFormatException.class)
    public void infiniteLoopTest(){

        String s = "1C";
       Integer.parseInt(s);
    }
}
