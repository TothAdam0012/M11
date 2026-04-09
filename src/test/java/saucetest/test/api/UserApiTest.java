package saucetest.test.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends AbstractUserApiTest {

	@Test
	public void testGetUsers() {
		given().
		when().
			get(endPoint).
		then().
			assertThat().
				statusCode(200);
	}

	@Test
	public void validateResponseHeader() {
		given().
		when().
			get(endPoint).
		then().
			assertThat().
				header("content-type", equalTo("application/json; charset=utf-8"));
	}

	@Test
	public void validateResponseBody() {
		given().
		when().
			get(endPoint).
		then().
			assertThat().
				body("size()", equalTo(10));
	}

}
