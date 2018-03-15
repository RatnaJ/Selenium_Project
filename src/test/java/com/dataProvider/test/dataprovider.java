package com.dataProvider.test;

import com.util.UtillityTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class dataprovider {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System is "+os);
        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ratnajalla/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
    }
@DataProvider
    public Iterator<Object[]> getTestData(){
        UtillityTest util = new UtillityTest();
        ArrayList<Object[]> testData = util.getDataFromExcel("/Users/ratnajalla/testNgProject/src/test/java/com/testdata/TestData.xlsx");
        return testData.iterator();
    }


    @Test(dataProvider = "getTestData")
    public void testDataMethod(String fname, String lname, String email, String passwd){
        driver.findElement(By.cssSelector("input#firstname")).clear();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(fname);

        driver.findElement(By.cssSelector("input#lastname")).clear();
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lname);

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);

        driver.findElement(By.cssSelector("input#PASSWORD")).clear();
        driver.findElement(By.cssSelector("input#PASSWORD")).sendKeys(passwd);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
