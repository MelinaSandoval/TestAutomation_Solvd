package com.solvd.carina.demo.automationpractice.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;

public class LoginPage0105 {
	private String userEmail = null;
	private String userPassword = null;

	private WebDriver driver = new ChromeDriver();

	@Test()
	// Unsuccsessful login due to null email and null password;
	public void unsuccessfulLoginAccount() {
		HomePage homePage = new HomePage(driver);
		HeaderMenu headerMenu = homePage.getHeaderMenu();
		if (headerMenu.getSingOutButton().isPresent()) {
			HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
			LoginPage loginPage = newHeaderMenu.openLoginPage();
			loginPage.singInAccount(userEmail, userPassword);
			Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
			Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
		} else {
			LoginPage loginPage = headerMenu.openLoginPage();
			loginPage.singInAccount(userEmail, userPassword);
			Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
			Assert.assertEquals(loginPage.getTypeOfLoginError(), "An email address required.");
		}
	}
}
