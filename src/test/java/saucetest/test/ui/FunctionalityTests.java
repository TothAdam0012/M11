package saucetest.test.ui;

import org.testng.annotations.Test;
import saucetest.model.CartManipulation;
import saucetest.model.User;
import saucetest.pages.CheckoutPage;
import saucetest.pages.ItemsPage;
import saucetest.pages.LoginPage;
import saucetest.service.TestDataFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FunctionalityTests extends AbstractWebDriverTest {

	@Test
	public void testItemHasDescription() {
		User user = TestDataFactory.getUser();
		new LoginPage(driver, user)
				.navigateToPage()
				.logIn();
		boolean hasDescription = new ItemsPage(driver)
				.productHasDescription();
		assertTrue(hasDescription);
	}

	@Test
	public void testUserScenario() {
		User user = TestDataFactory.getUser();
		CartManipulation cartManipulation = TestDataFactory.getCartManipulation();
		boolean successfulLogin = new LoginPage(driver, user)
				.navigateToPage()
				.logIn()
				.isSuccessfulLogin();
		assertTrue(successfulLogin);

		int itemsInCart = new ItemsPage(driver)
				.addItemsToCart(cartManipulation.cartAmount())
				.removeItemsFromCart(cartManipulation.manipulationAmount())
				.addItemsToCart(cartManipulation.manipulationAmount())
				.getCartAmountAndClickCart();
		assertEquals(itemsInCart, cartManipulation.cartAmount());

		boolean checkoutState = new CheckoutPage(driver, user)
				.navigateToCheckout()
				.fillInFieldsAndContinue()
				.clickFinish()
				.isSuccessfulCheckout();
		assertTrue(checkoutState);
	}
}
