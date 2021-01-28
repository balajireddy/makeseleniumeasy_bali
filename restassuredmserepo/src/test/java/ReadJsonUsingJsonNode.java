import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonUsingJsonNode {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"address\": [\r\n" + 
				"    {\r\n" + 
				"      \"city\": \"Patna\",\r\n" + 
				"      \"state\": \"Bihar\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"city\": \"Benagluru\",\r\n" + 
				"      \"state\": \"Karnataka\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"mobile\" : {\r\n" + 
				"    \"phone\":\"Samsung\"\r\n" + 
				"  }\r\n" + 
				"}";

		System.out.println(json);
		JsonNode jsonNode = objectMapper.readTree(json);

		JsonNode f2FieldNode = jsonNode.path("address").get(0).path("city"); 
		System.out.println(f2FieldNode.asText());
		System.out.println(f2FieldNode.textValue());
		System.out.println(jsonNode.path("firstName").asText());
		System.out.println(jsonNode.at("/mobile/phone"));
		
		
	}
}
