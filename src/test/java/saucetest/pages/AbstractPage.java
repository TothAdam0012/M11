package saucetest.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import saucetest.util.HighlightUtil;

import java.time.Duration;

public abstract class AbstractPage extends PageFactory {
	protected final WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	protected void navigateTo(String url) {
		driver.get(url);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	protected void fillInField(WebElement field, String content) {
		HighlightUtil.highlightCurrent(field);
		field.sendKeys(content);
	}

	protected void click(WebElement element) {
		HighlightUtil.highlightCurrent(element);
		element.click();
	}

	protected void moveToAndClick(WebElement element) {
		new Actions(driver)
				.moveToElement(element)
				.click()
				.perform();
	}

	protected Wait<WebDriver> defaultFluentWait() {
		return new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
	}

	protected Wait<WebDriver> defaultWebDriverWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	protected void setImplicitWait(Duration timeout) {
		driver.manage().timeouts().implicitlyWait(timeout);
	}
}
