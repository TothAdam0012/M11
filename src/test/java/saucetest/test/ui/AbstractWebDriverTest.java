package saucetest.test.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import saucetest.driver.WebDriverProvider;
import saucetest.listeners.TestListener;

@Listeners({TestListener.class})
public class AbstractWebDriverTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setupDriver() {
		driver = WebDriverProvider.getDriver();
	}

	@AfterMethod
	public void quitDriver() {
		WebDriverProvider.quitDriver();
	}
}
