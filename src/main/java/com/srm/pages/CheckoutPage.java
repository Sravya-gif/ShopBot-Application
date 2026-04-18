package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");

    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    By successMsg = By.className("complete-header");

    public void completeCheckout(String fname, String lname, String zip) {

        type(firstName, fname);
        type(lastName, lname);
        type(postalCode, zip);

        click(continueBtn);
        click(finishBtn);
    }

    public String getMessage() {
        return getText(successMsg);
    }
}