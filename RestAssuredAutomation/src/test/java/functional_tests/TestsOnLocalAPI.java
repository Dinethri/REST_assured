package functional_tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class TestsOnLocalAPI {

	@Test
	public void get() {

		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();

	}

	@Test
	public void post() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Ragav");
		request.put("lastName", "Geak");
		request.put("subjectId", 1);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.post("/users").then().statusCode(201);
	}

	@Test
	public void patch() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Albert");

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.put("/users/2").then().statusCode(200);
	}
}
