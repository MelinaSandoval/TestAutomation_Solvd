package com.solvd.carina.demo.automationpractice.cartmanagement;

//TC01 - Cart Management - Add a product displayed on the home page to the cart

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.automationpractice.HomePage;

public class CartManagement0201 implements IAbstractTest {
	private WebDriver driver = new ChromeDriver();

	@Test()
	public void addAProductFromHomePageToTheCart() {
		HomePage homePage = new HomePage(driver);
		homePage.addFirstProductToTheCart();
	}

}
