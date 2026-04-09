package saucetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucetest.locator.WaitReadyElementLocatorFactory;
import saucetest.model.User;

public class LoginPage extends AbstractPage {
	private final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private static final String LOGIN_URL = "https://www.saucedemo.com/";

	// different selectors for the task, all of these could be located just by id

	@FindBy(how = How.ID, using = "user-name")
	private WebElement loginField;

	@FindBy(how = How.CSS, using = "[data-test='password']")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//form/input[@name='login-button']")
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	private WebElement sidebarButton;

	@FindBy(how = How.ID, using = "logout_sidebar_link")
	private WebElement sidebarLogoutButton;

	private final User user;

	public LoginPage(WebDriver driver, User user) {
		super(driver);
		this.user = user;
		initElements(new WaitReadyElementLocatorFactory(defaultFluentWait()), this);
	}

	public LoginPage navigateToPage() {
		navigateTo(LOGIN_URL);
		logger.info("Navigated to login page.");
		return this;
	}

	public LoginPage logIn() {
		fillInField(loginField, user.login());
		fillInField(passwordField, user.password());
		click(loginButton);
		logger.info("Entered credentials and clicked login.");
		return this;
	}

	public boolean logOut() {
		click(sidebarButton);
		click(sidebarLogoutButton);
		logger.info("Logged out.");
		return loginButton.isDisplayed();
	}

	public boolean isSuccessfulLogin() {
		return getCurrentURL().endsWith("inventory.html");
	}
}
