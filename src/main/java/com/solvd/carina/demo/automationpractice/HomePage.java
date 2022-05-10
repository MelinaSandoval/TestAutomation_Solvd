package com.solvd.carina.demo.automationpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
	private final String automationPracticePageUrl = "https://www.http://automationpractice.com/index.php";

	@FindBy(xpath = "//*[@id=\"page\"]/div[1]")
	private HeaderMenu headerMenu;

	@FindBy(xpath = "//*[@id=\"footer\"]")
	private FooterMenu footerMenu;

	@FindBy(xpath = "//*[@id=\"home-page-tabs\"]/li[1]/a")
	private ExtendedWebElement popularTab;

	@FindBy(xpath = "//*[@id=\"home-page-tabs\"]/li[2]/a")
	private ExtendedWebElement bestSellerTab;

	@FindBy(xpath = "//div[contains(@class,'product_img_link')]")
	private List<ExtendedWebElement> productLink;

	@FindBy(xpath = "//*[@id=\"htmlcontent_home\"]")
	private List<ExtendedWebElement> contenHomeLink;

	@FindBy(xpath = "//*[@id=\"editorial_block_center\"]")
	private List<ExtendedWebElement> editorialHomeText;

	@FindBy(xpath = "//*[@class=\"product-container\"]")
	private List<ExtendedWebElement> productContainer;

	WebElement singleProductContainer = driver
			.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));

//First Product in the list
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")
	private ExtendedWebElement addToCartButton;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private ExtendedWebElement proceedToCheckoutButton;

//	@FindBy(xpath = "//*div[contains(@class,'button lnk_view btn btn-default')]")
//	private List<ExtendedWebElement> productMoreButton;

	public HomePage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
		setPageAbsoluteURL(automationPracticePageUrl);
	}

	public HeaderMenu getHeaderMenu() {
		return headerMenu;
	}

	public FooterMenu getFooterMenu() {
		return footerMenu;
	}

	public ExtendedWebElement getPopularTab() {
		return popularTab;
	}

	public ExtendedWebElement getBestSellerTab() {
		return bestSellerTab;
	}

	public List<ExtendedWebElement> getProductLink() {
		return productLink;
	}

	public List<ExtendedWebElement> getContenHomeLink() {
		return contenHomeLink;
	}

	public List<ExtendedWebElement> getEditorialHomeText() {
		return editorialHomeText;
	}

	public ExtendedWebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}

	public void addFirstProductToTheCart() {
		Actions action = new Actions(driver);
		action.moveToElement(singleProductContainer);
		addToCartButton.click();
	}

	public CartPage proceedToCheckout() {
		proceedToCheckoutButton.click();
		return new CartPage(driver);
	}

}
