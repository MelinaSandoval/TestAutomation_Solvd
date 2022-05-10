package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class HeaderMenu extends AbstractUIObject {
	@FindBy(xpath = "//*[@id=\"header_logo\"]/a")
	private ExtendedWebElement homeLink;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private ExtendedWebElement myAccountPageLink;

	@FindBy(xpath = "//*[@id=\"contact-link\"]/a")
	private ExtendedWebElement contactUsLink;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private ExtendedWebElement singUpButton;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	private ExtendedWebElement singOutButton;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/span")
	private ExtendedWebElement shopPhone;

	@FindBy(xpath = "//*[@id=\"searchbox\"]")
	private SearchBox searchBar;

	public SearchBox getSearchBar() {
		return searchBar;
	}

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/div")
	private ExtendedWebElement categoryDropMenu;

	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[3]")
	private ExtendedWebElement shoppingCartLink;

	public HeaderMenu(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getSingUpButton() {
		return singUpButton;
	}

	public ExtendedWebElement getSingOutButton() {
		return singOutButton;
	}

	public MyAccountPage openMyAccountPage() {
		myAccountPageLink.click();
		return new MyAccountPage(driver);
	}

	public HomePage singOutAccount() {
		singOutButton.click();
		return new HomePage(driver);
	}

	public LoginPage openLoginPage() {
		singUpButton.click();
		return new LoginPage(driver);
	}

	public ContactUsPage openContactUsPage() {
		contactUsLink.click();
		return new ContactUsPage(driver);
	}

	public String readShopPhone() {
		return shopPhone.getText();
	}

	public HomePage openHomePage() {
		homeLink.click();
		return new HomePage(driver);
	}

	public CartPage openOrdersPage() {
		shoppingCartLink.click();
		return new CartPage(driver);
	}

}
