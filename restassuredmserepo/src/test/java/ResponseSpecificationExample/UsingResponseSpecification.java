package ResponseSpecificationExample;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class UsingResponseSpecification {
	
	ResponseSpecification responseSpecification = null;
	
	@BeforeClass
	public void setupResponseSpecification()
	{
		// Create a ResponseSpecification 
		responseSpecification=  RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.statusCode(200);
		responseSpecification.time(Matchers.lessThan(5000L));
		responseSpecification.statusLine("HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void getAllBookings()
	{
		// Given
		RestAssured
		  .given()
			 .baseUri("https://restful-booker.herokuapp.com")
		// When
		   .when()
			  .get("/booking")
		// Then
		   .then()
		   // Just pass ResponseSpecification as below
		   .spec(responseSpecification)
		// To verify booking count
		   .body("size()", Matchers.greaterThan(5));
		
	}
	
	@Test
	public void getBookingDetailsWithInvalidFirstName()
	{
		// Given
		RestAssured
		  .given()
			 .baseUri("https://restful-booker.herokuapp.com")
		// When
		   .when()
			  .get("/booking?firstname=jim")
		// Then
		   .then()
		   .spec(responseSpecification)
		// To verify booking count
		   .body("size()", Matchers.equalTo(0));
			
	}

}
