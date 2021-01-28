package GameOfGetterSetterPOJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeDeserialzeExamples {

	@Test
	public void serializeWithBothGetterSetter() throws JsonProcessingException {
		// Just create an object of Pojo class
		EmployeePojoWithGetterSetterMethods employeePojoWithGetterSetterMethods = new EmployeePojoWithGetterSetterMethods();
		employeePojoWithGetterSetterMethods.setFirstName("Amod");
		employeePojoWithGetterSetterMethods.setLastName("Mahajan");
		employeePojoWithGetterSetterMethods.setAge(29);
		employeePojoWithGetterSetterMethods.setGender("Male");
		employeePojoWithGetterSetterMethods.setSalary(12323.56);
		employeePojoWithGetterSetterMethods.setMarried(false);
		
		// Converting a Java class object to a JSON payload as string
		System.out.println("Serialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(employeePojoWithGetterSetterMethods);
		System.out.println(employeeJson);
	}
	
	@Test
	public void deserializeWithBothGetterSetter() throws JsonProcessingException {
		String jsonString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\",\r\n" + 
				"  \"age\" : 29,\r\n" + 
				"  \"salary\" : 12323.56,\r\n" + 
				"  \"married\" : false\r\n" + 
				"}";
		
		System.out.println("Deserialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeePojoWithGetterSetterMethods employeePojoWithGetterSetterMethods = objectMapper.readValue(jsonString, EmployeePojoWithGetterSetterMethods.class);
		
		System.out.println("First name :- "+employeePojoWithGetterSetterMethods.getFirstName());
		System.out.println("Last name :- "+employeePojoWithGetterSetterMethods.getLastName());
		System.out.println("Age :- "+employeePojoWithGetterSetterMethods.getAge());
		System.out.println("Gender :- "+employeePojoWithGetterSetterMethods.getGender());
		System.out.println("Salary :- "+employeePojoWithGetterSetterMethods.getSalary());
		System.out.println("Married :- "+employeePojoWithGetterSetterMethods.getMarried());
		
		
	}
	
	
	@Test
	public void serializeWithGetterOnly() throws JsonProcessingException {
		// Just create an object of Pojo class but we can set values as we do not have any setter methods
		EmployeeWithGetterMethodsOnly employeeWithGetterMethodsOnly = new EmployeeWithGetterMethodsOnly();
			
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(employeeWithGetterMethodsOnly);
		System.out.println("Serialization...");
		System.out.println(employeeJson);
	}
	
	@Test
	public void deserializeWithGetterOnly() throws JsonProcessingException {
		String jsonString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\",\r\n" + 
				"  \"age\" : 29,\r\n" + 
				"  \"salary\" : 12323.56,\r\n" + 
				"  \"married\" : false\r\n" + 
				"}";
		
		System.out.println("Deserialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeWithGetterMethodsOnly employeeWithGetterMethodsOnly = objectMapper.readValue(jsonString, EmployeeWithGetterMethodsOnly.class);
		
		System.out.println("First name :- "+employeeWithGetterMethodsOnly.getFirstName());
		System.out.println("Last name :- "+employeeWithGetterMethodsOnly.getLastName());
		System.out.println("Age :- "+employeeWithGetterMethodsOnly.getAge());
		System.out.println("Gender :- "+employeeWithGetterMethodsOnly.getGender());
		System.out.println("Salary :- "+employeeWithGetterMethodsOnly.getSalary());
		System.out.println("Married :- "+employeeWithGetterMethodsOnly.getMarried());
		
		
	}
	
	
	@Test
	public void serializeWithSetterOnly() throws JsonProcessingException {
		// Just create an object of Pojo class
		EmployeePojoWithSetterMethodsOnly employeePojoWithSetterMethodsOnly = new EmployeePojoWithSetterMethodsOnly();
		employeePojoWithSetterMethodsOnly.setFirstName("Amod");
		employeePojoWithSetterMethodsOnly.setLastName("Mahajan");
		employeePojoWithSetterMethodsOnly.setAge(29);
		employeePojoWithSetterMethodsOnly.setGender("Male");
		employeePojoWithSetterMethodsOnly.setSalary(12323.56);
		employeePojoWithSetterMethodsOnly.setMarried(false);
		
		// Converting a Java class object to a JSON payload as string
		System.out.println("Serialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(employeePojoWithSetterMethodsOnly);
		System.out.println(employeeJson);
	}
	
	@Test
	public void deserializeWithSetterOnly() throws JsonProcessingException {
		String jsonString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\",\r\n" + 
				"  \"age\" : 29,\r\n" + 
				"  \"salary\" : 12323.56,\r\n" + 
				"  \"married\" : false\r\n" + 
				"}";
		
		System.out.println("Deserialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeePojoWithSetterMethodsOnly employeePojoWithSetterMethodsOnly = objectMapper.readValue(jsonString, EmployeePojoWithSetterMethodsOnly.class);
		
		System.out.println("First name :- "+employeePojoWithSetterMethodsOnly.alternateGetFirstName());
		System.out.println("Last name :- "+employeePojoWithSetterMethodsOnly.alternateGetLastName());
		System.out.println("Age :- "+employeePojoWithSetterMethodsOnly.alternateGetAge());
		System.out.println("Gender :- "+employeePojoWithSetterMethodsOnly.alternateGetGender());
		System.out.println("Salary :- "+employeePojoWithSetterMethodsOnly.alternateGetSalary());
		System.out.println("Married :- "+employeePojoWithSetterMethodsOnly.alternateGetMarried());
		
		
	}
}
