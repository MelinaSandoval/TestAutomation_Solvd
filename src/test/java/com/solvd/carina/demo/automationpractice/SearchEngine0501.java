package com.solvd.carina.demo.automationpractice;

//TC01 - Products Search Engine - Searching for an existen product by keyword

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.Test;

public class SearchEngine0501 implements IAbstractTest {

    @Test(description = "Test Case 01 - Search Engine: The user tries to add a product from the home page to the cart")
    @MethodOwner(owner = "Melina_Sandoval")
    public void searchAnExistentProduct() {
        String existentProduct = "dresses";
        HomePage homepage = new HomePage(getDriver());
        HeaderMenu headerMenu = homepage.getHeaderMenu();
        SearchBox searchBox = headerMenu.getSearchBar();
        searchBox.search(existentProduct);
    }

}
