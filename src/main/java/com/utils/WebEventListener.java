package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

import static com.utils.Screenshot.takeScreenshotAtEndOfTest;

public class WebEventListener extends BasePage implements WebDriverEventListener {
    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        System.out.println("Before navigating to "+ url);

    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        System.out.println("Navigated To "+ url);

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }


    /**
     * This will throw the error and take the screen shot immediately
     */
    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception Occured " + throwable);
        try {
            Screenshot.takeScreenshotAtEndOfTest();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
