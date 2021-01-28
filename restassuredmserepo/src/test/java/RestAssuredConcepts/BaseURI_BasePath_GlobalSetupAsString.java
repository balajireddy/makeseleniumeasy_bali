package RestAssuredConcepts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseURI_BasePath_GlobalSetupAsString {

	final String BASE_URI = "https://restful-booker.herokuapp.com";
	final String BASE_PATH = "/booking";
	
	
	@BeforeClass
	public void setup() {
		// Setting BaseURI once
		RestAssured.baseURI = BASE_URI;
		// Setting BasePath once
		RestAssured.basePath = BASE_PATH;
	}
	
	@Test
	public void request1() {
		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		System.out.println(response.asString());
	}
	
	@Test
	public void request2() {
		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		System.out.println(response.asString());
	}

	
}
