package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AccountCreationPage extends AbstractPage {
	private final String accountCreationPageUrl = "http://automationpractice.com/index.php?controller=authentication#account-creation";

	public AccountCreationPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
		setPageAbsoluteURL(accountCreationPageUrl);
	}

}
