package JacksonTutorials;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationWithMissingKnownProperties {

	@Test
	public void deserializationWithMissingKnownProperties() throws JsonMappingException, JsonProcessingException
	{
		String employeeString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\"\r\n" +
				"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.con
		Employee employee = objectMapper.readValue(employeeString, Employee.class);
		System.out.println("Deserialization...");
		System.out.println("First name :- "+employee.getFirstName());
		System.out.println("Last name :- "+employee.getLastName());
		System.out.println("Age :- "+employee.getAge());
		System.out.println("Gender :- "+employee.getGender());
		System.out.println("Salary :- "+employee.getSalary());
		System.out.println("Married :- "+employee.getMarried());

	}
}
