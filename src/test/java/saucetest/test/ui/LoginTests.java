package saucetest.test.ui;

import org.testng.annotations.Test;
import saucetest.model.User;
import saucetest.pages.LoginPage;
import saucetest.service.TestDataFactory;

import static org.testng.Assert.assertTrue;

public class LoginTests extends AbstractWebDriverTest {

	@Test
	public void testLogInLogOut() {
		User user = TestDataFactory.getUser();
		boolean loggedOut = new LoginPage(driver, user)
				.navigateToPage()
				.logIn()
				.logOut();
		assertTrue(loggedOut);
	}
}
