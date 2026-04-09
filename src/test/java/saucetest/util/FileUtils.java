package saucetest.util;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import saucetest.driver.WebDriverProvider;
import saucetest.util.decorator.DateDecorator;
import saucetest.util.decorator.ExactDecorator;
import saucetest.util.decorator.PngExtensionDecorator;
import saucetest.util.decorator.StringDecorator;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	public static final String SCREENSHOT_FOLDER = "screenshots";
	private static final StringDecorator screenshotNameDecorator = new PngExtensionDecorator(new DateDecorator(new ExactDecorator(" fail")));

	public static @Nullable File saveFailScreenshot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverProvider.getDriver();
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(SCREENSHOT_FOLDER + "/" + screenshotNameDecorator.decorate(name));
		try {
			FileHandler.copy(screenshot, destination);
			return destination;
		} catch(IOException e) {
			return null;
		}
	}
}
