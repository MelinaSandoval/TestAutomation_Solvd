package com.solvd.carina.demo.automationpractice.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;
import com.solvd.carina.demo.automationpractice.MyAccountPage;

public class LoginPage0101 implements IAbstractTest {
	private String userEmail = "melinasantestacc@hotmail.com";
	private String userPassword = "testaccount1";

	private WebDriver driver = new ChromeDriver();

	@Test()
	public void successfulLoginAccount() {
		HomePage homePage = new HomePage(driver);
		HeaderMenu headerMenu = homePage.getHeaderMenu();
//		Assert.assertTrue(headerMenu.getSingUpButton().isPresent() , "The user has already logged in");
		if (headerMenu.getSingOutButton().isPresent()) {
			HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
			LoginPage loginPage = newHeaderMenu.openLoginPage();
			loginPage.singInAccount(userEmail, userPassword);
			MyAccountPage myAccountPage = loginPage.singInAccount(userEmail, userPassword);
			Assert.assertTrue(myAccountPage.isPageOpened(), "A new My Account Page was not open");
		} else {
			LoginPage loginPage = headerMenu.openLoginPage();
			MyAccountPage myAccountPage = loginPage.singInAccount(userEmail, userPassword);
			Assert.assertTrue(myAccountPage.isPageOpened(), "A new My Account Page was not open");
		}

	}
}
