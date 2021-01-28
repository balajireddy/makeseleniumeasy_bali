package RestAssuredConcepts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MultipleCombineRequestSpecificationExample {
	
	
	public static void main(String[] args) {
		

		// Creating request specification using given()
		RequestSpecification request1= RestAssured.given();
		// Setting Base URI
		request1.baseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		//request1.basePath("/ping");
		request1.header("h1","v1");

				
		// Creating request specification using with()
		RequestSpecification request2= RestAssured.given();
		// Setting Base URI
		//request2.baseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		//request2.basePath("/booking");
		request2.header("h2","v2");
		
		
		RestAssured
		   .given()
		   // Using multiple request specification
		   .spec(request1)
		   .spec(request2)
		   // Logging all details
		   .log()
		   .all()
		.when()
		   .get();
		   	
	
	}

}
