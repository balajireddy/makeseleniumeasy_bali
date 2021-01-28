package ResponseSpecificationExample;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithoutUsingResponseSpecification2 {
	
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
		   .contentType(ContentType.JSON)
		   .time(Matchers.lessThan(5000L))
		   .statusLine("HTTP/1.1 200 OK")
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
			  .get("/booking?firstname=Rahul")
		// Then
		   .then()
		// Repetitive validation as first test above
		   .contentType(ContentType.JSON)
		   .time(Matchers.lessThan(5000L))
		   .statusLine("HTTP/1.1 200 OK")
		// To verify booking count
		   .body("size()", Matchers.equalTo(0));
			
	}

}
