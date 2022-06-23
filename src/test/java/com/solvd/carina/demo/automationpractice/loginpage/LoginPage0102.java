package com.solvd.carina.demo.automationpractice.loginpage;

//###############################################################################################################
//TC02 - Login Page - Unsuccessful Authentication due to valid email adress and wrong password
//###############################################################################################################

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage0102 implements IAbstractTest {
	private String userEmail = "melinasantestacc@hotmail.com";
	private String userPassword = "testaccount";

	@Test(description = "Test Case 02 - Login Page: The user tries to log in with incorrect credentials")
	@MethodOwner(owner = "Melina_Sandoval")
	public void unsuccessfulLoginAccount() {
		HomePage homePage = new HomePage(getDriver());
		HeaderMenu headerMenu = homePage.getHeaderMenu();
//			Assert.assertTrue(headerMenu.getSingUpButton().isPresent() , "The user has already logged in");
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
