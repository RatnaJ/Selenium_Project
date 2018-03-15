package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

public static Properties prop;
public static WebDriver driver;
public EventFiringWebDriver e_drive;
    public WebEventListener eventListener;

    public BasePage() {
        prop = new Properties();
        FileInputStream fis;

        {
            try {
                fis = new FileInputStream("/Users/ratnajalla/testNgProject/src/main/java/config.properties");
                prop.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/ratnajalla/Downloads/chromedriver");
            driver = new ChromeDriver();

        }
        else if(browserName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/ratnajalla/Downloads/geckodriver");
            driver = new FirefoxDriver();

        }

        e_drive = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_drive.register(eventListener);
        driver = e_drive;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
