package com.srm.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.ProductsPage;

public class ProblemUserTest extends BaseTest {

	@Test
	public void problemUserBrokenImages() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login("problem_user", "secret_sauce");

	    List<WebElement> images =
	            driver.findElements(By.tagName("img"));

	    java.util.Set<String> uniqueImages = new java.util.HashSet<>();

	    for (WebElement img : images) {
	        uniqueImages.add(img.getAttribute("src"));
	    }

	    if (uniqueImages.size() < images.size()) {
	        System.out.println("Duplicate / wrong images found for problem_user");
	        Assert.fail("Duplicate / wrong images found for problem_user");
	    } else {
	        System.out.println("Images look correct");
	    }
	}

	@Test
	public void problemUserAddToCart() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login("problem_user", "secret_sauce");

	    ProductsPage pp = new ProductsPage(driver);

	    pp.addProduct();

	    String count = "";

	    try {
	        count = pp.getCartCount();
	    } catch (Exception e) {
	        count = "";
	    }

	    if (count.equals("1")) {
	        System.out.println("Cart working for problem user");
	        Assert.assertTrue(true);
	    } else {
	        Assert.fail("Cart not working properly");
	    }
	}
}