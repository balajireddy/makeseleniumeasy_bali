package RestfulBooker.getExamples;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;;


public class BDDStyleGetRequest2 extends dddd{
	
	RequestSpecification requestSpecification;
	
	@BeforeSuite
	public void setup()
	{
		requestSpecification = RestAssured.given();
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RestAssured.basePath ="/booking";
		//requestSpecification = RestAssured.given();
		
	}

	@Test
	public void GetBookingIds_VerifyStatusCode111() {
		System.out.println("fdsfsfds");
		// Given
		requestSpecification.log().all()
		.when()
		.get()
		.then()
			.statusCode(400)
			.statusLine("HTTP/1.1 200 OK")
			// To verify booking count
			.body("bookingid.sum()", Matchers.is(56))
			// To verify booking id at index 3
			.body("bookingid[3]", Matchers.equalTo(1000));
		

	}

}
