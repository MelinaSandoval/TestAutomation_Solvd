package com.solvd.carina.demo.automationpractice.cartmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.automationpractice.CartPage;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;

public class CartManagement0203 implements IAbstractTest {
	private WebDriver driver = new ChromeDriver();

	@Test()
	public void deleteAProductFromTheShoppingCart() {
		HomePage homePage = new HomePage(driver);
		HeaderMenu headerMenu = homePage.getHeaderMenu();
		CartPage cartPage = headerMenu.openOrdersPage();
		cartPage.deleteProductFromCart();
	}

}
