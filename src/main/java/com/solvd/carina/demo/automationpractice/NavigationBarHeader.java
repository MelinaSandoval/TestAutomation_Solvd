package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class NavigationBarHeader extends AbstractUIObject {
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private ExtendedWebElement accountAccessButton;

	@FindBy(xpath = "//*[@id=\"contact-link\"]/a")
	private ExtendedWebElement contactUsButton;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/span")
	private ExtendedWebElement shopPhone;

	public NavigationBarHeader(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	public MyAccountPage openMyAccountPage() {
		accountAccessButton.click();
		return new MyAccountPage();
		
	}
	
	public ContactUsPage openContactUsPage() {
		contactUsButton.click();
		return new ContactUsPage();
	}
	
	public String readShopPhone() {
		return shopPhone.getText();
	}
	
	
	//Assert.assertTrue(accountAccessButton.getAttribute("title").equals("Log into your costumer account"),"You have already logged in to the account");
	

}
