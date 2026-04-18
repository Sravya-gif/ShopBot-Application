package com.srm.base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import com.srm.utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(
                        Integer.parseInt(ConfigReader.get("timeout"))))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
    }

    public WebElement waitForElement(By locator) {
        return wait.until(d -> d.findElement(locator));
    }

    public void click(By locator) {
        waitForElement(locator).click();
    }

    public void type(By locator, String value) {
        WebElement ele = waitForElement(locator);
        ele.clear();
        ele.sendKeys(value);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return waitForElement(locator).isDisplayed();
    }
    
    public void waitForSeconds(int seconds) {

        try {
            new org.openqa.selenium.support.ui.WebDriverWait(driver,
                    java.time.Duration.ofSeconds(seconds))
                    .until(d -> false);
        } catch (Exception e) {
         
        }
    }
}