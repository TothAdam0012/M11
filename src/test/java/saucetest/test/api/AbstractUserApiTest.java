package saucetest.test.api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import saucetest.service.TestDataFactory;

public class AbstractUserApiTest {
	protected String endPoint;

	@BeforeClass
	public void setup() {
		endPoint = TestDataFactory.getUserApiEndpoint();
	}

	@AfterClass
	public void end() {
		endPoint = null;
	}
}
