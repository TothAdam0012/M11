package saucetest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucetest.locator.WaitReadyElementLocatorFactory;

import java.util.List;
import static org.testng.Assert.*;

public class ItemsPage extends AbstractPage {
	private final Logger logger = LoggerFactory.getLogger(ItemsPage.class);

	@FindBy(how = How.CSS, using = "div.inventory_item button")
	private List<WebElement> addButtons;

	@FindBy(how = How.CSS, using = ".shopping_cart_badge")
	private WebElement cartIcon;

	@FindBy(how = How.CSS, using = "a.shopping_cart_link")
	private WebElement shoppingCart;

	@FindBy(how = How.CSS, using = "[data-test='inventory-item-desc']")
	private WebElement productDesc;

	public ItemsPage(WebDriver driver) {
		super(driver);
		initElements(new WaitReadyElementLocatorFactory(defaultWebDriverWait()), this);
	}

	public ItemsPage addItemsToCart(int itemsToAdd) {
		List<WebElement> addItemButtons = addButtons;
		for(int i = 0; i < itemsToAdd; i++) {
			click(addItemButtons.get(i));
		}
		logger.info("Added " + itemsToAdd + " items to cart.");
		return this;
	}

	public ItemsPage removeItemsFromCart(int itemsToRemove) {
		List<WebElement> removeItemButtons = addButtons;
		for(int i = 0; i < itemsToRemove; i++) {
			click(removeItemButtons.get(i));
		}
		logger.info("Removed " + itemsToRemove + " items from cart.");
		return this;
	}

	public int getCartAmountAndClickCart() {
		int amount = getCartAmount();
		click(shoppingCart);
		logger.info("Clicked cart icon.");
		return amount;
	}

	public boolean productHasDescription() {
		logger.info("Checking if product has description.");
		return !productDesc.getText().isEmpty();
	}

	public int getCartAmount() {
		try {
			return Integer.parseInt(cartIcon.getText());
		} catch(NumberFormatException e) {
			fail("Cart amount is not a number: " + e);
			return 0;
		} catch(NoSuchElementException e) {
			// don't fail if element is not present, it means cart is empty
			return 0;
		}
	}

}
