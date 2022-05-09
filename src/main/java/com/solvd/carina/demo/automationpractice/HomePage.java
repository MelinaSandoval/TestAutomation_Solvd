package com.solvd.carina.demo.automationpractice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
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

	@FindBy(xpath = "//*div[contains(@class, 'button ajax_add_to_cart_button_ btn btn-default')]")
	private List<ExtendedWebElement> addToCartButton;

	@FindBy(xpath = "//*div[contains(@class,'button lnk_view btn btn-default')]")
	private List<ExtendedWebElement> productMoreButton;

	public HomePage(WebDriver driver) {
		super(driver);
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

	public List<ExtendedWebElement> getProductContainer() {
		return productContainer;
	}

	public List<ExtendedWebElement> getAddToCartButton() {
		return addToCartButton;
	}

	public List<ExtendedWebElement> getProductMoreButton() {
		return productMoreButton;
	}

}
