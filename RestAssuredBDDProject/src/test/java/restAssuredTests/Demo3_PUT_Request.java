package restAssuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import io.restassured.RestAssured;

public class Demo3_PUT_Request {
	
	public static HashMap map = new HashMap(); 
	String empName = RestUtils.getEmpName();
	String salary = RestUtils.getEmpSal();
	String age = RestUtils.getEmpAge();
	int empID = 1693;
			
	@BeforeClass
	public void putdata() {
		map.put("name", empName);
		map.put("salary", salary);
		map.put("age", age);

		// Specify the base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/"+empID;
	}
	
	@Test
	public void testPut() {
		given()
			.contentType("application/json")
			.body(map)
			.log().all()
		.when()
			.put()
		.then()
			.log().all()
			.statusCode(200);
	}
}
