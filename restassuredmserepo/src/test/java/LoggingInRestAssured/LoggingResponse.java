package LoggingInRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class LoggingResponse {

	@Test
	public void logResponse() {
		
		// There is no need to add escape character manually. Just paste string within double 
		// quotes. It will automatically add escape sequence as required. 
		String jsonString = "{\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}";
		
		// Creating an object of RequestSpecBuilder
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		// Setting Base URI
		reqBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		reqBuilder.setBasePath("/booking");
		reqBuilder.setContentType(ContentType.JSON);
		// Setting pay load
		reqBuilder.setBody(jsonString);
		
		// Getting RequestSpecification reference using builder() method
		RequestSpecification reqSpec = reqBuilder.build();
		
		// Getting ValidatableResponse
		ValidatableResponse validatableResponse = RestAssured.given(reqSpec).post().then();
		// Logging response
		System.out.println("################Logging everything of response################");
		validatableResponse.log().all();
		System.out.println("################Logging response status code################");
		validatableResponse.log().status();
		System.out.println("################Logging response body################");
		validatableResponse.log().body();
		System.out.println("################Logging cookies of response################");
		validatableResponse.log().cookies();
		System.out.println("################Logging headers of response################");
		validatableResponse.log().headers();		
		
	}
}
