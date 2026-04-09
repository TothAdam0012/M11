package saucetest.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.Wait;

import java.lang.reflect.Field;
import java.util.List;

public class WaitReadyElementLocator implements ElementLocator {
	private final Wait<WebDriver> wait;
	private final By by;

	public WaitReadyElementLocator(Wait<WebDriver> wait, Field field) {
		this.wait = wait;
		this.by = new Annotations(field).buildBy();
	}

	@Override
	public WebElement findElement() {
		return wait.until(d -> {
			WebElement element = d.findElement(by);
			return isReady(element) ? element : null;
		});
	}

	@Override
	public List<WebElement> findElements() {
		return wait.until(d -> {
			List<WebElement> elementList = d.findElements(by);
			if(elementList.isEmpty()) return null;
			for(WebElement element : elementList) if(!isReady(element)) return null;
			return elementList;
		});
	}

	private boolean isReady(WebElement element) {
		return element.isDisplayed() && element.isEnabled();
	}
}
