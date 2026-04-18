package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.MenuPage;
import com.srm.utils.ExcelReader;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);

        boolean isProductPage =
                driver.getCurrentUrl().contains("inventory");

        if (isProductPage) {

            System.out.println("Logged in successfully");
            Assert.assertTrue(true);

        } else {

            System.out.println("Login failed due to invalid credentials");
            Assert.fail();
        }
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        MenuPage mp = new MenuPage(driver);
        mp.logout();
        System.out.println("Logged out successfully");
    }

    @DataProvider
    public Object[][] loginData() {
        return ExcelReader.getData("Sheet1");
    }   
}