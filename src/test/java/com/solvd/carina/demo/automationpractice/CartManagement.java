package com.solvd.carina.demo.automationpractice;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartManagement implements IAbstractTest {
    private WebDriver driver = new ChromeDriver();

    @Test(description = "Test Case 01 - Cart: The user tries to add a product from the home page to the cart")
    @MethodOwner(owner = "Melina_Sandoval")
    public void addAProductFromHomePageToTheCart() {
        HomePage homePage = new HomePage(driver);
        homePage.addFirstProductToTheCart();
    }

    @Test(description = "Test Case 02 - Cart: The user tries to add a product from the home page to the cart and then proceed with checkout")
    @MethodOwner(owner = "Melina_Sandoval")
    public void addProductFromHomePageToTheCart() {
        HomePage homePage = new HomePage(driver);
        homePage.addFirstProductToTheCart();
        CartPage cartPage = homePage.proceedToCheckout();
        Assert.assertTrue(cartPage.isPageOpened(), "Orders page was not open");
    }

    @Test(description = "Test Case 03 - Cart: The user tries to delete a product from the cart")
    @MethodOwner(owner = "Melina_Sandoval")
    public void deleteAProductFromTheShoppingCart() {
        HomePage homePage = new HomePage(driver);
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        CartPage cartPage = headerMenu.openOrdersPage();
        cartPage.deleteProductFromCart();
    }

}
