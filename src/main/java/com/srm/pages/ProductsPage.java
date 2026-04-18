package com.srm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import com.srm.base.BasePage;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    By title = By.className("title");

    By allProductNames = By.className("inventory_item_name");
    By allProductPrices = By.className("inventory_item_price");

    By addToCartBtn = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartBadge = By.className("shopping_cart_badge");

  
    By sortDropdown = By.cssSelector("select.product_sort_container");

    By menuBtn = By.id("react-burger-menu-btn");
    By logoutBtn = By.id("logout_sidebar_link");
    
    public boolean isProductPageDisplayed() {
        return isDisplayed(title);
    }

    public void addProduct() {
        click(addToCartBtn);
    }

    public String getCartCount() {
        return getText(cartBadge);
    }

    public void sortBy(String value) {
        Select select = new Select(waitForElement(sortDropdown));
        select.selectByVisibleText(value);
    }

    public List<String> getAllProductNames() {

        List<String> names = new ArrayList<>();

        List<WebElement> elements = driver.findElements(allProductNames);

        for (WebElement e : elements) {
            names.add(e.getText().trim());
        }

        return names;
    }

    public List<Double> getAllProductPrices() {

        List<Double> prices = new ArrayList<>();

        List<WebElement> elements = driver.findElements(allProductPrices);

        for (WebElement e : elements) {
            String text = e.getText().replace("$", "").trim();
            prices.add(Double.parseDouble(text));
        }

        return prices;
    }

}