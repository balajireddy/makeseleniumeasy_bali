package JacksonTutorials;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareTwoJsons {
	
	@Test
	public void compareTwoJsons() throws JsonMappingException, JsonProcessingException
	{
		String firstJson = "{\r\n" + 
				"  \"firstName\": \"Amod\"\r\n" + 
				"}";
		String secondJson = "{\r\n" + 
				"  \"firstName\": \"Amod\"\r\n" + 
				"}";
		
		// You can directly check equality using equals() method of String class
		Assert.assertEquals(firstJson, secondJson);
		ObjectMapper objectMapper = new ObjectMapper();
		
		// COnvert both strong to JSONNode then call equals() method
		JsonNode firstJsonNode = objectMapper.readTree(firstJson);
		JsonNode secondJsonNode = objectMapper.readTree(secondJson);
		boolean isEqual = firstJsonNode.equals(secondJsonNode);
		Assert.assertTrue(isEqual, "Both JSONs are not equal.");
		
	}
	
	@Test
	public void compareTwoJsons2() throws JsonMappingException, JsonProcessingException
	{
		String firstJson = "{\r\n" + 
				"  \"firstName\": \"Amod\"\r\n" + 
				"}";
		String secondJson = "{\r\n" + 
				"  \"firstName\": \"Amod Mahajan\"\r\n" + 
				"}";
		
		// COnvert both strong to JSONNode then call equals() method
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode firstJsonNode = objectMapper.readTree(firstJson);
		JsonNode secondJsonNode = objectMapper.readTree(secondJson);
		boolean isEqual = firstJsonNode.equals(secondJsonNode);
		Assert.assertTrue(isEqual, "Both JSONs are not equal.");
		
	}
	
	
	@Test
	public void compareTwoJsonsArrays() throws JsonMappingException, JsonProcessingException
	{
		String firstJson = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\"\r\n" + 
				"  }\r\n" + 
				"]";
		String secondJson = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\"\r\n" + 
				"  }\r\n" + 
				"]";
		
		// COnvert both strong to JSONNode then call equals() method
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode firstJsonNode = objectMapper.readTree(firstJson);
		JsonNode secondJsonNode = objectMapper.readTree(secondJson);
		boolean isEqual = firstJsonNode.equals(secondJsonNode);
		Assert.assertTrue(isEqual, "Both JSONs are not equal.");
		
	}
	
	@Test
	public void compareTwoJsonsArrays2() throws JsonMappingException, JsonProcessingException
	{
		String firstJson = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\"\r\n" + 
				"  }\r\n" + 
				"]";
		String secondJson = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\"\r\n" + 
				"  }\r\n" + 
				"]";
		
		// COnvert both strong to JSONNode then call equals() method
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode firstJsonNode = objectMapper.readTree(firstJson);
		JsonNode secondJsonNode = objectMapper.readTree(secondJson);
		boolean isEqual = firstJsonNode.equals(secondJsonNode);
		Assert.assertTrue(isEqual, "Both JSONs are not equal.");
		
	}

}
