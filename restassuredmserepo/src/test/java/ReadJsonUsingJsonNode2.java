import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonUsingJsonNode2 {

	public static void main(String[] args) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\amomahaj\\git\\master\\src\\test\\resources\\jsonFiles\\details.json"));
		System.out.println(jsonNode.get("sampleData").get("firstName").asText());
		System.out.println(jsonNode.at("/sampleData/firstName").asText());
		System.out.println(jsonNode.get("sampleData").get("address").get(0).get("city").asText());
		System.out.println(jsonNode.get("sampleDataUpdated").get("firstName").asText());
		System.out.println(jsonNode.get("sampleDataUpdated").get("address").get(0).get("city").asText());	
	}
}
