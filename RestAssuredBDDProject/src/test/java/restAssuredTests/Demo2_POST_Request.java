package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Demo2_POST_Request {

	public static HashMap map = new HashMap();

	@BeforeClass
	public void postdata() {
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());

		// Specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RestAssured.basePath = "/register";
	}

	@Test
	public void testPost() {
		given()
			.contentType("application/json")
			.body(map)
			.log().all()
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(201)
			.body("SuccessCode",equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));
	}
}
