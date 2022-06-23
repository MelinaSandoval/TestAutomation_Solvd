package com.solvd.carina.demo.automationpractice;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class LoginPageTest {
    @Test(description = "Test Case 01 - Login Page: The user tries to log in with correct credentials")
    @MethodOwner(owner = "Melina_Sandoval")
    public void successfulLoginAccount() {
        String validUserEmail = "melinasantestacc@hotmail.com";
        String validUserPassword = "testaccount1";
        HomePage homePage = new HomePage(getDriver());
        HeaderMenu headerMenu = homePage.getHeaderMenu();
//		Assert.assertTrue(headerMenu.getSingUpButton().isPresent() , "The user has already logged in");
        if (headerMenu.getSingOutButton().isPresent()) {
            HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
            LoginPage loginPage = newHeaderMenu.openLoginPage();
            loginPage.singInAccount(validUserEmail, validUserPassword);
            MyAccountPage myAccountPage = loginPage.singInAccount(validUserEmail, validUserPassword);
            Assert.assertTrue(myAccountPage.isPageOpened(), "A new My Account Page was not open");
        } else {
            com.solvd.carina.demo.automationpractice.LoginPage loginPage = headerMenu.openLoginPage();
            MyAccountPage myAccountPage = loginPage.singInAccount(validUserEmail, validUserPassword);
            Assert.assertTrue(myAccountPage.isPageOpened(), "A new My Account Page was not open");
        }

    }

    @Test(description = "Test Case 02 - Login Page: The user tries to log in with valid email address and invalid password")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsuccessfulLoginAccountDueToWrongPassWord() {
        String validUserEmail = "melinasantestacc@hotmail.com";
        String invalidUserPassword = "testaccount";
        HomePage homePage = new HomePage(getDriver());
        HeaderMenu headerMenu = homePage.getHeaderMenu();
//			Assert.assertTrue(headerMenu.getSingUpButton().isPresent() , "The user has already logged in");
        if (headerMenu.getSingOutButton().isPresent()) {
            HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
            LoginPage loginPage = newHeaderMenu.openLoginPage();
            loginPage.singInAccount(validUserEmail, invalidUserPassword);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        } else {
            LoginPage loginPage = headerMenu.openLoginPage();
            loginPage.singInAccount(validUserEmail, invalidUserPassword);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        }

    }

    @Test(description = "Test Case 03 - Login Page: Unsuccessfully Authentication on due to invalid email address input and valid password")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsuccessfulLoginAccountDueToWrongEmail() {
        String invalidUserEmail = "melinasantestacc@hotmail.co";
        String validUserPassword = "testaccount1";
        HomePage homePage = new HomePage(getDriver());
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        if (headerMenu.getSingOutButton().isPresent()) {
            HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
            LoginPage loginPage = newHeaderMenu.openLoginPage();
            loginPage.singInAccount(invalidUserEmail, validUserPassword);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        } else {
            com.solvd.carina.demo.automationpractice.LoginPage loginPage = headerMenu.openLoginPage();
            loginPage.singInAccount(invalidUserEmail, validUserPassword);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        }
    }

    @Test(description = "Test Case 04 - Login Page: Unsuccessfully Authentication on due to invalid credentials")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsuccessfulLoginAccount() {
        String invalidUserEmail = "melinasantestacc@hotmail.co";
        String invalidUserPassword = "testaccount";
        HomePage homePage = new HomePage(getDriver());
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        if (headerMenu.getSingOutButton().isPresent()) {
            HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
            LoginPage loginPage = newHeaderMenu.openLoginPage();
            loginPage.singInAccount(invalidUserEmail, invalidUserPassword);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        } else {
            LoginPage loginPage = headerMenu.openLoginPage();
            loginPage.singInAccount(invalidUserEmail, invalidUserPassword);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        }

    }

    @Test(description = "Test Case 05 - Login Page: Unsuccessfully Authentication on due to invalid credentials")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsuccessfulLoginAccountNullCredentials() {
        HomePage homePage = new HomePage(getDriver());
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        if (headerMenu.getSingOutButton().isPresent()) {
            HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
            LoginPage loginPage = newHeaderMenu.openLoginPage();
            loginPage.singInAccount(null, null);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        } else {
            LoginPage loginPage = headerMenu.openLoginPage();
            loginPage.singInAccount(null, null);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "An email address required.");
        }
    }

    @Test(description = "Test Case 06 - Login Page: successful account creation")
    @MethodOwner(owner = "Melina_Sandoval")
    public void successfulAccountCreation() {
        String userEmail = "melinasantestacc@hotmail.com";
        HomePage homePage = new HomePage(getDriver());
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

    @Test(description = "Test Case 07 - Login Page: unsuccessful account creation")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unSuccessfulAccountCreation() {
        String userEmail = "melinasantestacc@hotmail.com";
        HomePage homePage = new HomePage(getDriver());
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        if (headerMenu.getSingOutButton().isPresent()) {
            HeaderMenu newHeaderMenu = headerMenu.singOutAccount().getHeaderMenu();
            LoginPage loginPage = newHeaderMenu.openLoginPage();
            loginPage.createAccount(userEmail);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "Authentication failed.");
        } else {
            LoginPage loginPage = headerMenu.openLoginPage();
            loginPage.createAccount(userEmail);
            Assert.assertTrue(loginPage.getLoginErrorMessage().isElementPresent(), "Login error message was not found");
            Assert.assertEquals(loginPage.getTypeOfLoginError(), "An email address required.");
        }
    }

}
