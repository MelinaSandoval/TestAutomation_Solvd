package com.solvd.carina.demo.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LoginPage extends AbstractPage {
	private final String authenticationPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	@FindBy(xpath = "//*[@id=\"columns\"]/div[1]/a")
	private ExtendedWebElement homeLink;

	@FindBy(xpath = "//*[@id=\"email_create\"]")
	private WebElement emailFieldCA;

	@FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
	private ExtendedWebElement createAccountButton;

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement emailFieldSU;

	@FindBy(xpath = "//*[@id=\"passwd\"]")
	private WebElement passwordFieldSU;

	@FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
	private ExtendedWebElement forgotMyPasswordLink;

	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
	private ExtendedWebElement singInButton;

	@FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
	private ExtendedWebElement loginErrorMessage;

	@FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/p")
	private ExtendedWebElement oneLoginErrorMessage;

	@FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li/text()")
	private ExtendedWebElement typeOfLoginError;

	public LoginPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
		setPageAbsoluteURL(authenticationPageUrl);
	}

	public ExtendedWebElement getLoginErrorMessage() {
		return loginErrorMessage;
	}

	public ExtendedWebElement getTypeOfLoginError() {
		return typeOfLoginError;
	}

	public AccountCreationPage createAccount(String email) {
		emailFieldCA.sendKeys(email);
		createAccountButton.click();
		return new AccountCreationPage(driver);
	}

	public MyAccountPage singInAccount(String email, String ppassword) {
		emailFieldSU.sendKeys(email);
		passwordFieldSU.sendKeys(ppassword);
		singInButton.click();
		return new MyAccountPage(driver);
	}

}
