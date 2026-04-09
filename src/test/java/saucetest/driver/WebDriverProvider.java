package saucetest.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;

public class WebDriverProvider {
	private static final ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		WebDriver driver = localWebDriver.get();
		if(driver != null)  {
			return driver;
		}

		String browser = System.getProperty("browser");
		switch(browser) {
			case "chrome" -> {
				WebDriverManager.chromedriver().setup();

				// chrome keeps showing a popup about leaked password
				// ugly workaround I found on https://issues.chromium.org/issues/42323769
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", Map.of("profile.password_manager_leak_detection", false));
				//

				driver = new ChromeDriver(options);
			}
			case "firefox" -> {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			case "edge" -> {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			case "safari" -> {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
			case null, default -> throw new IllegalArgumentException("Invalid browser: " + browser + ", supported browsers: chrome, firefox, edge and safari");
		}

		localWebDriver.set(driver);
		return driver;
	}

	public static void quitDriver() {
		localWebDriver.get().quit();
		localWebDriver.remove();
	}
}
