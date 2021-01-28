package JacksonTutorials;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class GetAllKeysFromJsonObject {
	
	@Test
	public void getAllKeysFromJsonObjectUsingMap() throws JsonMappingException, JsonProcessingException {
 
		String jsonObject = "{\r\n" + "  \"firstName\": \"Animesh\",\r\n" + "  \"lastName\": \"Prashant\"\r\n" + "}";
		ObjectMapper objectMapper = new ObjectMapper();
		// Deserializing into a Map
		Map<String, String> parsedJsonObject = objectMapper.readValue(jsonObject,
				new TypeReference<Map<String, String>>() {
				});
		// Get all keys
		Set<String> allKeys = parsedJsonObject.keySet();
		System.out.println("All keys are : ");
		allKeys.stream().forEach(k -> System.out.println(k));
 
	}
	
	@Test
	public void getAllKeysFromJsonObjectUsingObjectMapper() throws JsonMappingException, JsonProcessingException
	{
		
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Animesh\",\r\n" + 
				"  \"lastName\": \"Prashant\"\r\n" + 
				"}";
		ObjectMapper objectMapper = new ObjectMapper();
		// Converting JSON Object string to JsonNode
		JsonNode parsedJsonObject = objectMapper.readTree(jsonObject);
		// Get all fields or keys
		Iterator<String> allKeys= parsedJsonObject.fieldNames();
		System.out.println("All keys are : ");
		allKeys.forEachRemaining(k -> System.out.println(k));
	}
	
	@Test
	public void getAllKeysFromNestedJsonObjectUsingMap() throws JsonMappingException, JsonProcessingException
	{
		
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Animesh\",\r\n" + 
				"  \"lastName\": \"Prashant\",\r\n" + 
				"  \"address\": {\r\n" + 
				"    \"city\": \"Katihar\",\r\n" + 
				"    \"State\": \"Bihar\"\r\n" + 
				"  }\r\n" + 
				"}";
		ObjectMapper objectMapper = new ObjectMapper();
		// Deserialize into Map
		Map<String,Object> parsedJsonObject = objectMapper.readValue(jsonObject, new TypeReference<Map<String, Object>>(){});
		// Get all keys
		Set<String> allKeys = parsedJsonObject.keySet();
		// Iterate keys
		allKeys.stream().forEach(key -> {
			Object value = parsedJsonObject.get(key);
			// If value is a String. You may need to add more if value is of different types
			if(value instanceof String)
				System.out.println(key);
			// If value is another JSON Object which will be LinkedHashMap. You can see this while debugging
			else if(value instanceof LinkedHashMap<?, ?>)
			{
				@SuppressWarnings("unchecked")
				Set<String> allKeysOfNestedJsonObject  = ((LinkedHashMap<String, ?>)value).keySet();
				allKeysOfNestedJsonObject.stream().forEach(k->System.out.println(k));
			}
		});
		
	}

	@Test
	public void getAllKeysFromNestedJsonObjectUsingJsonNode() throws JsonMappingException, JsonProcessingException
	{
			String jsonObject = "{\r\n" + 
					"  \"firstName\": \"Animesh\",\r\n" + 
					"  \"lastName\": \"Prashant\",\r\n" + 
					"  \"address\": {\r\n" + 
					"    \"city\": \"Katihar\",\r\n" + 
					"    \"State\": \"Bihar\"\r\n" + 
					"  }\r\n" + 
					"}";
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parsedJsonObject = objectMapper.readTree(jsonObject);
			Iterator<String> allKeys= parsedJsonObject.fieldNames();
			allKeys.forEachRemaining(k -> {
				Object value = parsedJsonObject.get(k);
				// TextNode can be related to String from previous example
				// You may need to add IntNode or BooleanNode for different types of values
				if(value instanceof TextNode)
					System.out.println(k);
				// ObjectNode can be related to LinkedHashMap from previous example
				else if(value instanceof ObjectNode)
				{
					Iterator<String> keyss = ((ObjectNode)value).fieldNames();
					keyss.forEachRemaining(ke -> System.out.println(ke));
				}
		
		});
		
	
	}
	
}
