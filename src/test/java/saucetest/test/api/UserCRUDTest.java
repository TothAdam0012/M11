package saucetest.test.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserCRUDTest extends AbstractUserApiTest {

	@Test
	public void testGET() {
		given().
		when().
			get(endPoint).
		then().
			assertThat().
				statusCode(200);
	}

	@Test
	public void testPOST() {
		given().
			header("Content-Type", "application/json").
			body("{\"name\": \"test\"}").
		when().
			post(endPoint).
		then().
			assertThat().
				statusCode(201);
	}

	@Test
	public void testPUT() {
		String specificUserEndPoint = endPoint + "/{id}";

		given().
			header("Content-Type", "application/json").
			body("{\"name\": \"test\"}").
		when().
			put(specificUserEndPoint, 1).
		then().
			assertThat().
				statusCode(200);
	}

	@Test
	public void testDELETE() {
		String specificUserEndPoint = endPoint + "/{id}";

		given().
		when().
			delete(specificUserEndPoint, 1).
		then().
			assertThat().
				statusCode(200);
	}
}
