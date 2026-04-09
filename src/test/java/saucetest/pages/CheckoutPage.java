package saucetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucetest.model.User;

import java.time.Duration;

public class CheckoutPage extends AbstractPage {
	private final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

	@FindBy(how = How.CSS, using = "#checkout")
	private WebElement checkoutButton;

	@FindBy(how = How.CSS, using = "#continue")
	private WebElement continueButton;

	@FindBy(how = How.CSS, using = "#finish")
	private WebElement finishButton;

	@FindBy(how = How.ID, using = "first-name")
	private WebElement firstNameField;

	@FindBy(how = How.ID, using = "last-name")
	private WebElement lastNameField;

	@FindBy(how = How.ID, using = "postal-code")
	private WebElement zipCodeField;

	@FindBy(how = How.CSS, using = "img.pony_express")
	private WebElement checkmarkImg;


	private final User user;

	public CheckoutPage(WebDriver driver, User user) {
		super(driver);
		this.user = user;
		initElements(driver, this);
		setImplicitWait(Duration.ofSeconds(5));
	}

	public CheckoutPage navigateToCheckout() {
		click(checkoutButton);
		logger.info("Navigated to checkout page.");
		return this;
	}

	public CheckoutPage fillInFieldsAndContinue() {
		fillInField(firstNameField, user.firstName());
		fillInField(lastNameField, user.lastName());
		fillInField(zipCodeField, user.zipCode());
		click(continueButton);
		logger.info("Entered name and zipcode and clicked 'continue'.");
		return this;
	}

	public CheckoutPage clickFinish() {
		click(finishButton);
		logger.info("Clicked 'finish'.");
		return this;
	}

	public boolean isSuccessfulCheckout() {
		return checkmarkImg.isDisplayed();
	}
}
