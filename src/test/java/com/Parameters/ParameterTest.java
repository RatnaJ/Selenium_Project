package com.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParameterTest {
    WebDriver driver;

    @Parameters({ "url" })
    @Test
    public void paranterMethod(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ratnajalla/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
    }

    @Parameters({ "uName" })
    @Test
    public void testMethod(String uName) {
        driver.findElement(By.xpath(".//*[@id='login-username']")).clear();
        driver.findElement(By.xpath(".//*[@id='login-username']")).sendKeys(uName);
        driver.findElement(By.xpath(".//*[@id='login-signin']")).click();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}