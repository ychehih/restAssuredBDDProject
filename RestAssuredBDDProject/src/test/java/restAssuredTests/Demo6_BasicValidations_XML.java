package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo6_BasicValidations_XML {

	// Verifying single content in XML Response
	
	@Test(priority = 1)
	public void testSingleContent() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
	}
	
	// Verifying Multiple  contents in XML Response
	@Test(priority = 2)
	public void testMultipleContents() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"));
	}	
	
	//Verify all the content in XML response in one go
	@Test(priority = 3)
	public void testMultipleInOneGo() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
			
	}		
	
	// Find values using XML Path in XML Response
	
	@Test(priority = 4)
	public void testUsingXPath1() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
	}
	
	@Test(priority = 5)
	public void testUsingXPath2() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	}
	
}
