package com.solvd.carina.demo.automationpractice;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class CheckoutPageTest {
    private String userEmail = "melinasantestacc@hotmail.com";
    private String userPassword = "testaccount1";
    private CartPage cartPage;

    @Test(description = "Test Case 01 - The user goes to the checkout page without logged")
    @MethodOwner(owner = "Melina_Sandoval")
    public void proceedToCheckoutBeingLogged() {
        HomePage homePage = new HomePage(getDriver());
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
