package JacksonTutorials;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialiDeserialExampleWithJsonIgnore {

	@Test
	public void serializationWithJsonIgnore() throws JsonProcessingException {
		// Just create an object of Pojo class
		EmployeePojoWithJsonIgnore employeePojoWithJsonIgnore = new EmployeePojoWithJsonIgnore();
		employeePojoWithJsonIgnore.setFirstName("Amod");
		employeePojoWithJsonIgnore.setLastName("Mahajan");
		employeePojoWithJsonIgnore.setAge(29);
		employeePojoWithJsonIgnore.setGender("Male");
		employeePojoWithJsonIgnore.setSalary(12323.56);
		employeePojoWithJsonIgnore.setMarried(false);
		employeePojoWithJsonIgnore.setFullName("Animesh Prashant");
		employeePojoWithJsonIgnore.setEligibleForVote(false);

		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojoWithJsonIgnore);
		System.out.println("Serialization...");
		System.out.println(employeeJson);
		
	}
	
	@Test
	public void deserializationWithJsonIgnore() throws JsonMappingException, JsonProcessingException
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
		EmployeePojoWithJsonIgnore employeePojoWithJsonIgnore2 = objectMapper.readValue(employeeString, EmployeePojoWithJsonIgnore.class);
		System.out.println("Deserialization...");
		System.out.println("First name :- "+employeePojoWithJsonIgnore2.getFirstName());
		System.out.println("Last name :- "+employeePojoWithJsonIgnore2.getLastName());
		System.out.println("Age :- "+employeePojoWithJsonIgnore2.getAge());
		System.out.println("Gender :- "+employeePojoWithJsonIgnore2.getGender());
		System.out.println("Salary :- "+employeePojoWithJsonIgnore2.getSalary());
		System.out.println("Married :- "+employeePojoWithJsonIgnore2.getMarried());
		System.out.println("Eligible for vote :- "+employeePojoWithJsonIgnore2.getEligibleForVote());
		System.out.println("Full name :- "+employeePojoWithJsonIgnore2.getFullName());
	}
}
