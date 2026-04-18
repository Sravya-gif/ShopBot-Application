package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();

        CartPage cp = new CartPage(driver);
        cp.openCart();
        cp.clickCheckout();

        CheckoutPage ch = new CheckoutPage(driver);

        ch.completeCheckout("Sravya", "Alahari", "522034");

        Assert.assertTrue(ch.getMessage().contains("Thank you"));

        System.out.println("Checkout completed successfully");
    }
}