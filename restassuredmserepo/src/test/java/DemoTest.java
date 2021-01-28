import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DemoTest {
	@Test
	public void demoAPI() throws JsonMappingException, JsonProcessingException
	{
		String data = RestAssured.get("https://ssd-api.jpl.nasa.gov/fireball.api?date-min=2017-01-01&req-alt=true&sort=-energy").asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		LinkedHashMap<String,Object> jsonResponse = objectMapper.readValue(data, LinkedHashMap.class);
		ArrayList<ArrayList<String>> dataArray = (ArrayList<ArrayList<String>>) jsonResponse.get("data");
		System.out.println(dataArray.size());
		for(ArrayList<String> s : dataArray)
		{
			for(String s1 : s)
			{
				System.out.println(s1);
			}
		}
	}
	
	
	@Test
	public void demo2()
	{
		String s= RestAssured.given().log().all()
		.auth()
		.oauth2("sk_test_51HKyscK97epSfFxrrz5rsTh7KfcPvwpuwvBTdJVjlj77kbg2II0OFVucPHPeVt101cwyDJDfFDrNozumMGJkftcA00a7k40H4J")
		.contentType(ContentType.URLENC)
		.formParam("description", "afa")
		.post("https://api.stripe.com/v1/customers").asString();
		
		System.out.println("bidus : s"+ s);
	}

}
