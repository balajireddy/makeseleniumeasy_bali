package rahushetty;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class serializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		addPlace p=new addPlace();
		p.setAccuracy(50);
		p.setAddress("30, Rt nager, blore");
		p.setLanguage("English-UK");
		p.setPhone_number("123456789");
		p.setWebsite("https://rahulbalaji.com");
		p.setName("Frontline");
		
		List<String> mylist=new ArrayList<String>();
		mylist.add("dinnur road");
		mylist.add("shop");
		p.setTypes(mylist);
		
		
		location loc =new location();
		loc.setLat(56.53);
		loc.setLng(-45.36);
		
		
		
		p.setLocation(loc);
		
		
		
		Response res=given().queryParam("key", "qaclick123").body(p)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		
		
		String responseString= res.asString();
		System.out.println(responseString);
		
		
		
		}

}

