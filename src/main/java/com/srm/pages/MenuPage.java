package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    By menuBtn = By.id("react-burger-menu-btn");
    By logoutBtn = By.id("logout_sidebar_link");

    public void logout() {

        click(menuBtn);

        waitForElement(logoutBtn);

        click(logoutBtn);
    }
}