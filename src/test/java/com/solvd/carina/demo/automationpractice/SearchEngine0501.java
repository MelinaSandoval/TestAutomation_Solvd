package com.solvd.carina.demo.automationpractice;

//TC01 - Products Search Engine - Searching for an existen product by keyword

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.annotations.Test;

public class SearchEngine0501 implements IAbstractTest {
    private String existentProduct = "dresses";

    @Test()
    public void searchAnExistentProduct() {
        HomePage homepage = new HomePage(getDriver());
        HeaderMenu headerMenu = homepage.getHeaderMenu();
        SearchBox searchBox = headerMenu.getSearchBar();
        searchBox.search(existentProduct);
    }

}
