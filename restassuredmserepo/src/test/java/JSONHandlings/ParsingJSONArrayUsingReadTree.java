package JSONHandlings;

import java.util.Iterator;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ParsingJSONArrayUsingReadTree {
	
	@Test
	public void printAllKeys() throws JsonMappingException, JsonProcessingException
	{
		String json = "[\r\n" + 
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
				"  },\r\n" + 
				"  \r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"city\": \"Patna\",\r\n" + 
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
		// It will be an ArrayNode.
		JsonNode parsedJson = objectMapper.readTree(json);
		
		if(parsedJson instanceof ArrayNode) {
		System.out.println(parsedJson.size());
		// It will be two json objects
		Iterator<JsonNode> jsonObjects = parsedJson.iterator();
		
		while(jsonObjects.hasNext())
		{
			JsonNode jsonObject = jsonObjects.next();
			Iterator<String> allKeys = jsonObject.fieldNames();
			allKeys.forEachRemaining(k -> {
				System.out.println(k);
			});
		}
		}
		
	}

}
