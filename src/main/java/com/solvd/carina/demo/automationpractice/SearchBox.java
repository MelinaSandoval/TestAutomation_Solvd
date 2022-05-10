package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class SearchBox extends AbstractUIObject {
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	private WebElement searchBar;

	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	private ExtendedWebElement searchButton;

	public SearchBox(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public void search(String target) {
		searchBar.sendKeys(target);
		searchButton.click();
	}
}
