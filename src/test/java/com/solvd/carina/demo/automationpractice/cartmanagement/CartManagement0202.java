package com.solvd.carina.demo.automationpractice.cartmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.automationpractice.CartPage;
import com.solvd.carina.demo.automationpractice.HomePage;

public class CartManagement0202 implements IAbstractTest {
	private WebDriver driver = new ChromeDriver();

	@Test()
	public void addAProductFromHomePageToTheCart() {
		HomePage homePage = new HomePage(driver);
		homePage.addFirstProductToTheCart();
		CartPage cartPage = homePage.proceedToCheckout();
		Assert.assertTrue(cartPage.isPageOpened(), "Orders page was not open");
	}

}
