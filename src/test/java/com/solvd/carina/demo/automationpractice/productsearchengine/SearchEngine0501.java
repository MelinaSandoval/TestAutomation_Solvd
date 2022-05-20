package com.solvd.carina.demo.automationpractice.productsearchengine;

//TC01 - Products Search Engine - Searching for an existen product by keyword

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.automationpractice.HeaderMenu;
import com.solvd.carina.demo.automationpractice.HomePage;
import com.solvd.carina.demo.automationpractice.SearchBox;

public class SearchEngine0501 implements IAbstractTest {
	private WebDriver driver = new ChromeDriver();
	private String existentProduct = "dresses";

	@Test()
	public void searchAnExistentProduct() {
		HomePage homepage = new HomePage(driver);
		HeaderMenu headerMenu = homepage.getHeaderMenu();
		SearchBox searchBox = headerMenu.getSearchBar();
		searchBox.search(existentProduct);
	}

}
