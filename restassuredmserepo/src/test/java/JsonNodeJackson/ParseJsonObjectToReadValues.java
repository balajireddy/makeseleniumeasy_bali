package JsonNodeJackson;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJsonObjectToReadValues {
	
	@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"married\": false,\r\n" + 
				"  \"salary\": 2000.54,\r\n" + 
				"  \"addressPin\": 45324\r\n" + 
				"}";
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonObject);
		// Get value of firstName as string
		String firstName = jsonTree.get("firstName").asText();
		String lastName = jsonTree.get("lastName").asText();
		// Get value of married as boolean
		boolean married = jsonTree.get("married").asBoolean();
		double salary = jsonTree.get("salary").asDouble();
		long addressPin = jsonTree.get("addressPin").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Married is   : "+married);
		System.out.println("Salary is    : "+salary);
		System.out.println("Addresspin is: "+addressPin);
		
		
		// Checking the type of value hold by node
		System.out.println(jsonTree.get("firstName").isTextual());
		System.out.println(jsonTree.get("lastName").isTextual());
		System.out.println(jsonTree.get("married").isBoolean());
		System.out.println(jsonTree.get("salary").isDouble());
		System.out.println(jsonTree.get("addressPin").isLong());

		// Retrieving value of non-existing key using get
		try {
		String s = jsonTree.get("nonExistingNode").asText("Default value");
		System.out.println(s);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// Retrieving value of non-existing key using path
		String s1 = jsonTree.path("nonExistingNode").asText("Default value");
		System.out.println(s1);
		
		
	}

}
