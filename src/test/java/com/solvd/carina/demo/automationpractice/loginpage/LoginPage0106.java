package com.solvd.carina.demo.automationpractice.loginpage;

//TC06-Login Page-Succesfull registration using valid email adress

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.automationpractice.AccountCreationPage;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;

public class LoginPage0106 {
	private String userEmail = "melinasantestacc@hotmail.com";

	private WebDriver driver = new ChromeDriver();

	@Test()
	public void successfullAccountCreation() {
		HomePage homePage = new HomePage(driver);
		HeaderMenu headerMenu = homePage.getHeaderMenu();

		if (headerMenu.getSingOutButton().isPresent()) {
			HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
			LoginPage loginPage = newHeaderMenu.openLoginPage();
			loginPage.createAccount(userEmail);
			Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
			Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
		} else {
			LoginPage loginPage = headerMenu.openLoginPage();
			AccountCreationPage accountCreationPage = loginPage.createAccount(userEmail);
			Assert.assertTrue(accountCreationPage.isPageOpened(), "A new My Account page was not open");
		}
	}
}
