package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    By errorMsg = By.xpath("//h3");

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public boolean isErrorDisplayed() {
        try {
            return isDisplayed(errorMsg);
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
}