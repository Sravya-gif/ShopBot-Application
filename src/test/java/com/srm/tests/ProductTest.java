package com.srm.tests;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void verifyAllSortingOptions() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductsPage pp = new ProductsPage(driver);

        Assert.assertTrue(pp.isProductPageDisplayed());

        pp.sortBy("Name (A to Z)");
        pp.waitForSeconds(2);

        List<String> namesAZ = pp.getAllProductNames();
        List<String> sortedAZ = new ArrayList<>(namesAZ);
        Collections.sort(sortedAZ);

        Assert.assertEquals(namesAZ, sortedAZ);
        System.out.println("Name A to Z sorting is working");

        pp.sortBy("Name (Z to A)");
        pp.waitForSeconds(2);

        List<String> namesZA = pp.getAllProductNames();
        List<String> sortedZA = new ArrayList<>(namesZA);
        Collections.sort(sortedZA, Collections.reverseOrder());

        Assert.assertEquals(namesZA, sortedZA);
        System.out.println("Name Z to A sorting is working");

        
        pp.sortBy("Price (low to high)");
        pp.waitForSeconds(2);

        List<Double> priceLowHigh = pp.getAllProductPrices();
        List<Double> sortedLowHigh = new ArrayList<>(priceLowHigh);
        Collections.sort(sortedLowHigh);

        Assert.assertEquals(priceLowHigh, sortedLowHigh);
        System.out.println("Price low to high sorting is working");

        pp.sortBy("Price (high to low)");
        pp.waitForSeconds(2);

        List<Double> priceHighLow = pp.getAllProductPrices();
        List<Double> sortedHighLow = new ArrayList<>(priceHighLow);
        Collections.sort(sortedHighLow, Collections.reverseOrder());

        Assert.assertEquals(priceHighLow, sortedHighLow);
        System.out.println("Price high to low sorting is working");
    }
}