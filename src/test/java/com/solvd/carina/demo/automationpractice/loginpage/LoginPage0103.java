package com.solvd.carina.demo.automationpractice.loginpage;

//TC03 - Login Page - Unsuccessfull Authentication on due to invalid email adess input and valid password

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;

public class LoginPage0103 {
	private String userEmail = "melinasantestacc@hotmail.co";
	private String userPassword = "testaccount1";

	private WebDriver driver = new ChromeDriver();

	@Test()
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
			Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
		}

	}
}
