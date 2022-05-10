package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CartPage extends AbstractPage {
	private final String cartPageUrl = "http://automationpractice.com/index.php?controller=order";

	@FindBy(xpath = "//*[@id=\"order_step\"]/li[1]/span")
	private ExtendedWebElement summaryTab;

	@FindBy(xpath = "//*[@id=\"1_1_0_683266\"]/i")
	private ExtendedWebElement iconTrashButton;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	private ExtendedWebElement proceedToCheckoutButton;

	public CartPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
		setPageAbsoluteURL(cartPageUrl);
	}

	public ExtendedWebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}

	public void deleteProductFromCart() {
		summaryTab.click();
		iconTrashButton.click();

	}

}
