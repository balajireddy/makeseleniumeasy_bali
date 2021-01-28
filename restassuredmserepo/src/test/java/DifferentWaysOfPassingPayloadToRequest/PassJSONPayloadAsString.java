package DifferentWaysOfPassingPayloadToRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PassJSONPayloadAsString {

	

		@Test
		public void passPayloadJosnAsString() {
		// There is no need to add escape character manually. Just paste string within double 
		// quotes. It will automatically add escape sequence as required. 
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		
		//GIVEN
		RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.contentType(ContentType.JSON)
			.body(jsonString)
		// WHEN
		.when()
			.post()
		// THEN
		.then()
			.assertThat()
			.statusCode(200);
		}
		
}
