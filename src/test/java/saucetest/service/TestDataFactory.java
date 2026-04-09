package saucetest.service;

import saucetest.model.CartManipulation;
import saucetest.model.User;

public class TestDataFactory {
	public static final String USER_LOGIN = "testdata.ui.user.login";
	public static final String USER_PASSWORD = "testdata.ui.user.password";
	public static final String USER_FIRST_NAME = "testdata.ui.user.first_name";
	public static final String USER_LAST_NAME = "testdata.ui.user.last_name";
	public static final String USER_ZIPCODE = "testdata.ui.user.zipcode";

	public static final String CART_AMOUNT = "testdata.ui.cart.amount";
	public static final String CART_MANIPULATION_AMOUNT = "testdata.ui.cart.manipulation_amount";

	public static final String USER_API_ENDPOINT = "testdata.api.user.endpoint";

	public static User getUser() {
		return new User(TestDataReader.getData(USER_LOGIN),
				TestDataReader.getData(USER_PASSWORD),
				TestDataReader.getData(USER_FIRST_NAME),
				TestDataReader.getData(USER_LAST_NAME),
				TestDataReader.getData(USER_ZIPCODE));
	}

	public static CartManipulation getCartManipulation() {
		return new CartManipulation(Integer.parseInt(TestDataReader.getData(CART_AMOUNT)), Integer.parseInt(TestDataReader.getData(CART_MANIPULATION_AMOUNT)));
	}

	public static String getUserApiEndpoint() {
		return TestDataReader.getData(USER_API_ENDPOINT);
	}
}
