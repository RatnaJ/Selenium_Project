package com.test;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PropertiesTest extends BasePage{
   // WebDriver driver;


    public PropertiesTest() {
        super();
    }

    @BeforeClass
    public void setUp(){
        initialize();
        //prop.getProperty("uName");


    }

    @Test
    public void titleTest(){

    System.out.println(driver.getTitle());
    }

    //@Parameters({ "uName" })
    @Test
    public void testMethod() {

        driver.findElement(By.xpath(".//*[@id='login-username']")).clear();
        driver.findElement(By.xpath(".//*[@id='login-username']")).sendKeys(prop.getProperty("uName"));
        driver.findElement(By.xpath(".//*[@id='login-signin']")).click();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}