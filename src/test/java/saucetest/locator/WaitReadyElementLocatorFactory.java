package saucetest.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;

import java.lang.reflect.Field;

public class WaitReadyElementLocatorFactory implements ElementLocatorFactory {
	private final Wait<WebDriver> wait;

	public WaitReadyElementLocatorFactory(Wait<WebDriver> wait) {
		this.wait = wait;
	}

	@Override
	public ElementLocator createLocator(Field field) {
		return new WaitReadyElementLocator(wait, field);
	}
}
