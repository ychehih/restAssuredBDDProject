package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {

	int empID = 931;
	
	@BeforeClass
	public void deletedata() {

		// Specify the base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/" + empID;
	}

	@Test
	public void testDeleteEmployeeRecord() {
		
		Response response =
		
		given()
			//.log().all()
		.when()
			.delete()
		.then()
			.log().all()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType("text/html; charset=UTF-8")
			.header("server", equalTo("nginx/1.16.0"))
			.extract().response();
		
			String jsonAsString = response.asString();
			Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"), true);
	}
}
