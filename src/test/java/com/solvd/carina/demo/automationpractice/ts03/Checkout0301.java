package com.solvd.carina.demo.automationpractice.ts03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.automationpractice.CartPage;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;
import com.solvd.carina.demo.automationpractice.MyAccountPage;

public class Checkout0301 {
	private WebDriver driver = new ChromeDriver();
	private String userEmail = "melinasantestacc@hotmail.com";
	private String userPassword = "testaccount1";
	private CartPage cartPage;

	@Test()
	public void proceedToCheckoutBeingLogged() {
		HomePage homePage = new HomePage(driver);
		HeaderMenu headerMenu = homePage.getHeaderMenu();
		// Sing in
		if (headerMenu.getSingOutButton().isPresent()) {
			HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
			LoginPage loginPage = newHeaderMenu.openLoginPage();
			loginPage.singInAccount(userEmail, userPassword);
			MyAccountPage myAccountPage = loginPage.singInAccount(userEmail, userPassword);
			Assert.assertTrue(myAccountPage.isPageOpened(), "A new My Account Page was not open");
			cartPage = newHeaderMenu.openOrdersPage();
		} else {
			LoginPage loginPage = headerMenu.openLoginPage();
			MyAccountPage myAccountPage = loginPage.singInAccount(userEmail, userPassword);
			Assert.assertTrue(myAccountPage.isPageOpened(), "A new My Account Page was not open");
			cartPage = headerMenu.openOrdersPage();
		}
		cartPage.getProceedToCheckoutButton().click();

	}
}
