package LoggingInRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class LogAllExampleDetailed {

	@Test
	public void logAll() {
		
		// There is no need to add escape character manually. Just paste string within double 
		// quotes. It will automatically add escape sequence as required. 
		String jsonString = "{\r\n" + 
				"    \"firstname\" : \"Amod\",\r\n" + 
				"    \"lastname\" : \"Mahajan\",\r\n" + 
				"    \"totalprice\" : 121,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2020-02-01\",\r\n" + 
				"        \"checkout\" : \"2020-02-05\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}";
		
		// Creating an object of RequestSpecBuilder
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		// Setting Base URI
		reqBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		reqBuilder.setBasePath("/booking");
		// Setting demo headers
		reqBuilder.addHeader("DemoHeader1", "Headervalue1");
		reqBuilder.addHeader("DemoHeader2", "Headervalue2");
		// Setting demo cookies
		reqBuilder.addCookie("DemoCookie1", "DemoCookieValue1");
		reqBuilder.addCookie("DemoCookie2", "DemoCookieValue2");
		// Setting demo params
		reqBuilder.addParam("demoParam1", "demoParam1value");
		reqBuilder.addParam("demoParam2", "demoParam2value");
		// Setting demo path params
		reqBuilder.addPathParam("demoPathParam1", "demoPathParam1value");
		reqBuilder.addPathParam("demoPathParam2", "demoPathParam2value");
		// Setting body
		reqBuilder.setBody(jsonString);
		
		// Getting RequestSpecification reference using builder() method
		RequestSpecification reqSpec = reqBuilder.build();
		
		
		RequestSpecification reqSpecHit = RestAssured.given(reqSpec);
		// Logging everything
		reqSpecHit.log().all();
		// Logging URI
		reqSpecHit.log().uri();
		// Logging request body
		reqSpecHit.log().body();
		// Logging request headers
		reqSpecHit.log().headers();
		// Logging request params
		reqSpecHit.log().params();
		// Logging request cookies
		reqSpecHit.log().cookies();
		  
		reqSpecHit.when()
		     .post().
		  then()
		     .assertThat()
		     .statusCode(500);			
				
	}
}
