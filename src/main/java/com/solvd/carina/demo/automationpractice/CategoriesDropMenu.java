package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class CategoriesDropMenu extends AbstractUIObject {
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private ExtendedWebElement womenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/a")
	private ExtendedWebElement topsWomenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	private ExtendedWebElement tShirtTopsWomenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	private ExtendedWebElement dressesWomenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a")
	private ExtendedWebElement casualDressesDressesWomenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a")
	private ExtendedWebElement eveningDressesDressesWomenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
	private ExtendedWebElement summerDressesDressesWomenCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private ExtendedWebElement dressesCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
	private ExtendedWebElement casualDressesDressesCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
	private ExtendedWebElement summerDressesDresesCategory;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private ExtendedWebElement tShirtCategory;

	private enum CatalogCategories {
		WOMEN, DRESSES, T_SHIRTS;
	}

	private enum WomenMenuCategories {
		TOPS, DRESSES;
	}

	private enum WomenTopsMenu {
		T_SHIRT, BLOUSES;
	}

	private enum womenDressesMenu {
		CASUAL_DRESSES, EVENING_DRESSES, SUMER_DRESSES;
	}

	public CategoriesDropMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public void openProductCategoryPage(CatalogCategories catalogCategories) {
		// ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		switch (catalogCategories) {
		case WOMEN:
			womenCategory.click();
		case DRESSES:
			dressesCategory.click();
		case T_SHIRTS:
			tShirtCategory.click();

		}
	}

}
