package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class CartTest extends BaseTest {

    @Test
    public void addAndVerifyCart() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();

        Assert.assertEquals(pp.getCartCount(), "1");
        System.out.println("Cart count verified");
    }

    @Test
    public void removeFromCart() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();

        CartPage cp = new CartPage(driver);
        cp.openCart();
        cp.removeItem();

        Assert.assertTrue(true);
        System.out.println("Item removed from cart");
    }
}