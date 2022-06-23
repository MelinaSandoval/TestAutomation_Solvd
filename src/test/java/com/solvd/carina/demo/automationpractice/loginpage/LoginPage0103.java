package com.solvd.carina.demo.automationpractice.loginpage;

//TC03 - Login Page - Unsuccessfull Authentication on due to invalid email adess input and valid password

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class LoginPage0103 {
    private String userEmail = "melinasantestacc@hotmail.co";
    private String userPassword = "testaccount1";

    private WebDriver driver = new ChromeDriver();

    @Test(description = "Test Case 02 - Login Page: The user tries to log in with incorrect credentials")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsuccessfulLoginAccount() {
        HomePage homePage = new HomePage(getDriver());
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
