package com.solvd.carina.demo.automationpractice.loginpage;

//TC04 - Login Page - Unsuccesfull authentication due to invalid email adress and invalid password

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;

public class LoginPage0104 {
	private String userEmail = "melinasantestacc@hotmail.co";
	private String userPassword = "testaccount";

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
