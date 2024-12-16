package functional_tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("Rachel", "George"));

	}

	@Test
	public void testPost() {
		Map<String, Object> mp = new HashMap<String, Object>();
//		mp.put("name", "Nuwani");
//		mp.put("job", "Teacher");
//		
//		System.out.println(mp);

		JSONObject request = new JSONObject(mp);
		request.put("name", "Nuwani");
		request.put("job", "teacher");
		System.out.println(request.toJSONString());// print and check whether it's in jason format

		baseURI = "https://reqres.in/api";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}

}
