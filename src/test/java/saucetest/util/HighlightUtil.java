package saucetest.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import saucetest.driver.WebDriverProvider;

public class HighlightUtil {
	public static final String HIGHLIGHT_BORDER_STYLE = "5px solid red";

	public static void highlightCurrent(WebElement element) {
		// TODO: figure out how to reset style without triggering PageFactory lazy init
		JavascriptExecutor js = (JavascriptExecutor) WebDriverProvider.getDriver();
		js.executeScript("arguments[0].style.border='" + HIGHLIGHT_BORDER_STYLE + "'", element);
	}
}
