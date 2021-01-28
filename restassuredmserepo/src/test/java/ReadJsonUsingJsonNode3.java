import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonUsingJsonNode3 {

	public static void main(String[] args) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> m = objectMapper.readValue(new File("C:\\Users\\amomahaj\\git\\master\\src\\test\\resources\\jsonFiles\\details.json"), 
				new TypeReference<Map<String,Object>>(){});
//		JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\amomahaj\\git\\master\\src\\test\\resources\\jsonFiles\\details.json"));
//		System.out.println(jsonNode.get("sampleData").get("firstName").asText());
//		System.out.println(jsonNode.at("/sampleData/firstName").asText());
//		System.out.println(jsonNode.get("sampleData").get("address").get(0).get("city").asText());
//		System.out.println(jsonNode.get("sampleDataUpdated").get("firstName").asText());
//		System.out.println(jsonNode.get("sampleDataUpdated").get("address").get(0).get("city").asText());	
		
		JsonNode node = objectMapper.valueToTree(m.get("sampleData"));
		System.out.println(node.get("firstName").asText());
		System.out.println(node.get("address").get(0).get("city").asText());
	}
}
