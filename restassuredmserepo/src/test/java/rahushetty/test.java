package rahushetty;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.entity.ContentType;

import files.payload;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		
		String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type" ,"application/json")
		.body(payload.Addplace()).when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
				System.out.println(response);
				
				JsonPath js =new JsonPath(response); //parshing json 
				String placeid=js.get("place_id");
				
				System.out.println(placeid);
				
				String newaddress ="summarwalk Africa";
				given().log().all().queryParam("key","qaclick123").header("Content-Type" ,"application/json")
				.body("{\r\n"
						+ "   \"place_id\":\""+placeid+"\",\r\n"
						+ "   \"address\":\""+newaddress+",\r\n"
						+ "   \"key\":\"qaclick123\"\r\n"
						+ "}").
				when().put("maps/api/place/update/json").
				then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
				
				
	String getPlace=given().log().all().queryParam("key","qaclick")
				.queryParam("place_id", placeid)
				.when().get("maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().response().asString();
				
				
			JsonPath js1=new JsonPath(getPlace);
			String actualaddress=js1.getString("address");
			
			System.out.println("!!!!!!!!!!!" +actualaddress);
	
		//https://rahulshettyacademy.com/maps/api/place/add/json?key =qaclick123

	}

	

}
