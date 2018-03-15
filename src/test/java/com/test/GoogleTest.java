package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System is "+os);
        if (os.contains("mac")) {
//            System.setProperty("webdriver.chrome.driver", "/Users/ratnajalla/Downloads/chromedriver");
//            driver = new ChromeDriver();

            //System.setProperty("webdriver.chrome.driver", "/Users/ratnajalla/Downloads/chromedriver");
            driver = new FirefoxDriver();


            driver.get("http://www.google.com");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
    }

    @Test(priority = 1, groups = "Title Verification")
    public void verifyPageTile(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Google", "Title is not "+title);
    }

    @Test(priority = 2, groups = "Logo Verification")
    public void verifyLogo(){
        boolean check = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        System.out.println(check);

    }


    @Test(priority = 3, groups = "LinkCheck")
    public void linkCheck(){
        boolean check1 = driver.findElement(By.linkText("Gmail")).isDisplayed();
        System.out.println(check1);

    }

    @Test(priority = 4, groups = "Title Verification")
    public void verifyPageTile1(){
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test(priority = 5, groups = "Logo Verification")
    public void verifyLogo1(){
        boolean check = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        System.out.println(check);

    }


    @Test(priority = 6, groups = "LinkCheck")
    public void linkCheck1() {
        boolean check1 = driver.findElement(By.linkText("Gmail")).isDisplayed();
        System.out.println(check1);
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
