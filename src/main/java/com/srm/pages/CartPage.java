package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By cartIcon = By.className("shopping_cart_link");
    By removeBtn = By.xpath("//button[text()='Remove']");
    By checkoutBtn = By.id("checkout");

    public void openCart() {
        click(cartIcon);
    }

    public void removeItem() {
        click(removeBtn);
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }
}