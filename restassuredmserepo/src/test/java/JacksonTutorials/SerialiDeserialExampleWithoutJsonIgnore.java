package JacksonTutorials;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialiDeserialExampleWithoutJsonIgnore {

	@Test
	public void serializationWithoutJsonIgnore() throws JsonProcessingException {
		// Just create an object of Pojo class
		EmployeePojoWithoutJsonIgnore employeePojoWithoutJsonIgnore = new EmployeePojoWithoutJsonIgnore();
		employeePojoWithoutJsonIgnore.setFirstName("Amod");
		employeePojoWithoutJsonIgnore.setLastName("Mahajan");
		employeePojoWithoutJsonIgnore.setAge(29);
		employeePojoWithoutJsonIgnore.setGender("Male");
		employeePojoWithoutJsonIgnore.setSalary(12323.56);
		employeePojoWithoutJsonIgnore.setMarried(false);
		employeePojoWithoutJsonIgnore.setFullName("Animesh Prashant");
		employeePojoWithoutJsonIgnore.setEligibleForVote(false);

		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojoWithoutJsonIgnore);
		System.out.println("Serialization...");
		System.out.println(employeeJson);
	}
	
	@Test
	public void deserializationWithoutJsonIgnore() throws JsonMappingException, JsonProcessingException
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
		EmployeePojoWithoutJsonIgnore employeePojoWithoutJsonIgnore2 = objectMapper.readValue(employeeString, EmployeePojoWithoutJsonIgnore.class);
		System.out.println("Deserialization...");
		System.out.println("First name :- "+employeePojoWithoutJsonIgnore2.getFirstName());
		System.out.println("Last name :- "+employeePojoWithoutJsonIgnore2.getLastName());
		System.out.println("Age :- "+employeePojoWithoutJsonIgnore2.getAge());
		System.out.println("Gender :- "+employeePojoWithoutJsonIgnore2.getGender());
		System.out.println("Salary :- "+employeePojoWithoutJsonIgnore2.getSalary());
		System.out.println("Married :- "+employeePojoWithoutJsonIgnore2.getMarried());
		System.out.println("Eligible for vote :- "+employeePojoWithoutJsonIgnore2.getEligibleForVote());
		System.out.println("Full name :- "+employeePojoWithoutJsonIgnore2.getFullName());
	}
}
