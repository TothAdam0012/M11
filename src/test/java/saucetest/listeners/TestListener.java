package saucetest.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import saucetest.util.FileUtils;

import java.io.File;
import java.util.Arrays;

public class TestListener implements ITestListener {
	private static final boolean shouldTakeFailScreenshot = Boolean.parseBoolean(System.getProperty("failscreenshot"));
	private final Logger logger = LoggerFactory.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test started: " + result.getName() + " with arguments: " + Arrays.toString(result.getParameters()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed: " + result.getName() + " with arguments: " + Arrays.toString(result.getParameters()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Test failed: " + result.getName() + " with arguments: " + Arrays.toString(result.getParameters()));
		if(shouldTakeFailScreenshot) {
			File savedScreenshot = FileUtils.saveFailScreenshot(result.getName());
			if(savedScreenshot == null) {
				logger.error("Could not save screenshot.");
			} else {
				logger.info("Saved screenshot " + savedScreenshot);
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("Test skipped: " + result.getName() + " with arguments: " + Arrays.toString(result.getParameters()));
	}
}
