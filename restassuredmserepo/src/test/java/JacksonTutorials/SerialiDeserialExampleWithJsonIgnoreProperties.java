package JacksonTutorials;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialiDeserialExampleWithJsonIgnoreProperties {

	@Test
	public void serializationWithJsonIgnoreProperties() throws JsonProcessingException {
		// Just create an object of Pojo class
		EmployeePojoWithJsonIgnoreProperties employeePojoWithJsonIgnoreProperties = new EmployeePojoWithJsonIgnoreProperties();
		employeePojoWithJsonIgnoreProperties.setFirstName("Amod");
		employeePojoWithJsonIgnoreProperties.setLastName("Mahajan");
		employeePojoWithJsonIgnoreProperties.setAge(29);
		employeePojoWithJsonIgnoreProperties.setGender("Male");
		employeePojoWithJsonIgnoreProperties.setSalary(12323.56);
		employeePojoWithJsonIgnoreProperties.setMarried(false);
		employeePojoWithJsonIgnoreProperties.setFullName("Animesh Prashant");
		employeePojoWithJsonIgnoreProperties.setEligibleForVote(false);

		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojoWithJsonIgnoreProperties);
		System.out.println("Serialization...");
		System.out.println(employeeJson);
		
	}
	
	@Test
	public void deserializationWithJsonIgnoreProperties() throws JsonMappingException, JsonProcessingException
	{
		String employeeString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\",\r\n" + 
				"  \"age\" : 29,\r\n" + 
				"  \"salary\" : 12323.56,\r\n" + 
				"  \"married\" : false,\r\n" + 
				"  \"fullName\" : \"Amod Mahajan Gupta\",\r\n" + 
				"  \"eligibleForVote\" : false\r\n" + 
				"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.con
		EmployeePojoWithJsonIgnoreProperties employeePojoWithJsonIgnoreProperties = objectMapper.readValue(employeeString, EmployeePojoWithJsonIgnoreProperties.class);
		System.out.println("Deserialization...");
		System.out.println("First name :- "+employeePojoWithJsonIgnoreProperties.getFirstName());
		System.out.println("Last name :- "+employeePojoWithJsonIgnoreProperties.getLastName());
		System.out.println("Age :- "+employeePojoWithJsonIgnoreProperties.getAge());
		System.out.println("Gender :- "+employeePojoWithJsonIgnoreProperties.getGender());
		System.out.println("Salary :- "+employeePojoWithJsonIgnoreProperties.getSalary());
		System.out.println("Married :- "+employeePojoWithJsonIgnoreProperties.getMarried());
		System.out.println("Eligible for vote :- "+employeePojoWithJsonIgnoreProperties.getEligibleForVote());
		System.out.println("Full name :- "+employeePojoWithJsonIgnoreProperties.getFullName());
	}
}
