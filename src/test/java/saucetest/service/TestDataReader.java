package saucetest.service;

import java.util.ResourceBundle;

public class TestDataReader {
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "normal"));

	public static String getData(String key) {
		return resourceBundle.getString(key);
	}
}
