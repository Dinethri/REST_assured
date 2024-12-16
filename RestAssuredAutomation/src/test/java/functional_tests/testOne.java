package functional_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.net.http.HttpResponse.BodyHandler;
import io.restassured.response.Response;

public class testOne {
	@Test
	// create a function
	// void is the return type
	public void test_1() {

		// to display the response
		// to navigate to the request
		Response displayresponse = get("https://reqres.in/api/users?page=2");

		System.out.println(displayresponse.getStatusCode());
		System.out.println(displayresponse.getTime());
		System.out.println(displayresponse.getBody().asString());
		System.out.println(displayresponse.getStatusLine());
		System.out.println(displayresponse.getHeader("content-type"));

		// add validation/assertions
		int statusCode = displayresponse.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
	}
}
