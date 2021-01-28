package JSONHandlings;

import java.util.Iterator;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ParsingJSONObjectUsingReadTree {
	
	@Test
	public void printAllKeys() throws JsonMappingException, JsonProcessingException
	{
		String json = "{\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\"\r\n" + 
				"    \r\n" + 
				"  }";
		
		ObjectMapper objectMapper = new ObjectMapper();
		// It will be an ArrayNode.
		JsonNode parsedJson = objectMapper.readTree(json);
		
		
		
	}

}
