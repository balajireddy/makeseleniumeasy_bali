package ResponseSpecificationExample;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderExample {
	
ResponseSpecification responseSpecification = null;
	
	@BeforeClass
	public void setupResponseSpecification()
	{
		// Create a ResponseSpecification using ResponseSpecBuilder
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder.expectStatusCode(200);
		responseSpecBuilder.expectStatusLine("HTTP/1.1 200 OK");
		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecBuilder.expectResponseTime(Matchers.lessThan(5000L));	
		responseSpecification = responseSpecBuilder.build();
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
