package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * Test Status Code
 * Log Response
 * Verifying Single content in response body
 * Verifying Multiple contents in response body
 * Settings parameters & Headers 
 */
public class Demo5_BasicValidations_JSON {
	
	@Test(priority = 1)
	public void testStatusCode() {
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200);
	}
	
	//  Log response
	@Test(priority = 2)
	public void testLogging() {
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	}	
	
	// Verifying Single content in response body
	@Test(priority = 3)
	public void testSingleContent() {
		given()
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.body("City", equalTo("Hyderabad"))
			.log().all();
	}	

	//Verifying Multiple contents in response body
	@Test(priority = 4)
	public void testMultipleContent() {
		given()
		.when()
			.get("https://restcountries.eu/rest/v2/all")
		.then()
			.statusCode(200)
			.body("name", hasItems("Algeria","Australia"))
			.log().all();
	}	
	
	// Setting parameters & headers 
	@Test(priority = 5)
	public void testParamsAndHeaders() { 
		given()
			.param("MyName","Yahia")
			.header("MyHeader","Algerian")
		.when()
			.get("https://restcountries.eu/rest/v2/all")
		.then()
			.statusCode(200)
			.log().all();
	}	
	

}
