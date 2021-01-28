package JacksonTutorials;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class GetAllKeysFromJsonArray {
	
	@Test
	public void getAllKeysFromJsonArrayUsingArrayList() throws JsonMappingException, JsonProcessingException {
 
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"city\": \"Katihar\",\r\n" + 
				"    \"state\": \"Bihar\"\r\n" + 
				"  }\r\n" + 
				"]";
		ObjectMapper objectMapper = new ObjectMapper();
		// Deserializing into a ArrayList. You can use LinkedList as well
		ArrayList<Map<String,String>> parsedJsonArray = objectMapper.readValue(jsonArray,
				new TypeReference<ArrayList<Map<String,String>>>(){});
		// Get all keys
		for(Map<String,String> jsonObj : parsedJsonArray)
		{
			Set<String> keysOfJsonObj = jsonObj.keySet();
			keysOfJsonObj.stream().forEach(k->System.out.println(k));
			
		}
 
	}
	
	@Test
	public void getAllKeysFromJsonObjectUsingObjectMapper() throws JsonMappingException, JsonProcessingException
	{
		
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"city\": \"Katihar\",\r\n" + 
				"    \"state\": \"Bihar\"\r\n" + 
				"  }\r\n" + 
				"]";
		ObjectMapper objectMapper = new ObjectMapper();
		// Converting JSON Object string to JsonNode
		JsonNode parsedJsonArray = objectMapper.readTree(jsonArray);
		// Get all fields or keys
		Iterator<JsonNode> it = parsedJsonArray.elements();
		while(it.hasNext())
		{
			JsonNode n = (JsonNode) it.next();
			Iterator<String> allKeys= n.fieldNames();
			System.out.println("All keys are : ");
			allKeys.forEachRemaining(k -> System.out.println(k));
			
		}
	}
	
	@Test
	public void getAllKeysFromNestedJsonArrayUsingArrayList() throws JsonMappingException, JsonProcessingException
	{
		
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Katihar\",\r\n" + 
				"        \"state\": \"Bihar\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Bengaluru\",\r\n" + 
				"        \"state\": \"Karnataka\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
		ObjectMapper objectMapper = new ObjectMapper();
		// Deserialize into Map
		ArrayList<Map<String,Object>> parsedJsonArray = objectMapper.readValue(jsonArray, new TypeReference<ArrayList<Map<String,Object>>>(){});
		
		for(Map<String,Object> jsonObj : parsedJsonArray)
		{
			Set<String> allKeys = jsonObj.keySet();
			allKeys.stream().forEach(key -> {
				Object value = jsonObj.get(key);
				// If value is a String. You may need to add more if value is of different types
				if(value instanceof String)
					System.out.println(key);
				// If value is another JSON Object which will be LinkedHashMap. You can see this while debugging
				else if(value instanceof List<?>)
				{
					for(Map<String,String> nestedJsonObj : (List<Map<String,String>>)value)
					{
						Set<String> allNestedKeys = nestedJsonObj.keySet();
						allNestedKeys.forEach(ke -> System.out.println(ke));
					}
				}
			});
			
		}
		
	}

	@Test
	public void getAllKeysFromNestedJsonObjectUsingJsonNode() throws JsonMappingException, JsonProcessingException
	{
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Katihar\",\r\n" + 
				"        \"state\": \"Bihar\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Bengaluru\",\r\n" + 
				"        \"state\": \"Karnataka\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayNode parsedJsonArray = (ArrayNode) objectMapper.readTree(jsonArray);
			Iterator<JsonNode> it = parsedJsonArray.elements();
			while(it.hasNext())
			{
				JsonNode n = it.next();
				if(n instanceof ObjectNode)
				{
					Iterator<String> allKeys= n.fieldNames();
					System.out.println("All keys are : ");
					allKeys.forEachRemaining(k -> {
						if(n.get(k) instanceof TextNode)
							System.out.println(k);
						else if(n.get(k) instanceof ArrayNode)
						{
							System.out.println("sdfsd");
							Iterator<JsonNode> i =n.get(k).iterator();
							while(i.hasNext())
							{
								Iterator<String> ss = i.next().fieldNames();
								ss.forEachRemaining(ke -> System.out.println(ke));
							}
						}
						
					});
				}
			}
			
	
	}
	
	@Test
	public void getAllKeysFromNestedJsonObjectUsingJsonNode123() throws JsonMappingException, JsonProcessingException
	{
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Katihar\",\r\n" + 
				"        \"state\": \"Bihar\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Bengaluru\",\r\n" + 
				"        \"state\": \"Karnataka\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayNode parsedJsonArray = (ArrayNode) objectMapper.readTree(jsonArray); // json ARAY WILL be parsed as ArrayNode.
			// Inside array node we have ObjectNode
			Iterator<JsonNode> it = parsedJsonArray.elements();
			while(it.hasNext())
			{
				ObjectNode n = (ObjectNode) it.next();
					Iterator<String> allKeys= n.fieldNames();
					System.out.println("All keys are : ");
					allKeys.forEachRemaining(k -> {
						if(n.get(k) instanceof TextNode)
							System.out.println(k);
						else if(n.get(k) instanceof ArrayNode)
						{
							System.out.println("sdfsd");
							Iterator<JsonNode> i =n.get(k).iterator();
							while(i.hasNext())
							{
								Iterator<String> ss = i.next().fieldNames();
								ss.forEachRemaining(ke -> System.out.println(ke));
							}
						}
						
					});	
			}
			
	
	}
	
}
