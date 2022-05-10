package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class MyAccountPage extends AbstractPage {
	private final String myAccountPageUrl = "http://automationpractice.com/index.php?controller=my-account";

	@FindBy(xpath = "//*[@id=\"page\"]/div[1]")
	private HeaderMenu headerMenu;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
		setPageAbsoluteURL(myAccountPageUrl);
	}

	public HomePage openHomePage() {
		return headerMenu.openHomePage();
	}

}
