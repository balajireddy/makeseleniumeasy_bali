package JacksonTutorials;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserializationGetterSetterExamples {
	
	/*
	 * Output
	 * ======
	 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class 
	 * JacksonTutorials.Employee_PrivateFieldsWithoutAnyGetterSetterMethods and no properties discovered 
	 * to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
	 */
	@Test
	public void serializePrivateFieldsWithoutAnyGetterSetter() throws JsonProcessingException
	{
		// We do not have setter method in POJO class so can not set any value.
		Employee_PrivateFieldsWithoutAnyGetterSetterMethods employee_PrivateFieldsWithoutAnyGetterSetterMethods = 
				new Employee_PrivateFieldsWithoutAnyGetterSetterMethods();
		ObjectMapper objectMapper = new ObjectMapper();
		String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee_PrivateFieldsWithoutAnyGetterSetterMethods);
		System.out.println(serializedJson);		
	}
	
	/*
	 * Output
	 * =====
	 * com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "firstName" 
	 * (class JacksonTutorials.Employee_PrivateFieldsWithoutAnyGetterSetterMethods), not marked as ignorable (0 known properties)
	 */
	@Test
	public void deserializePrivateFieldsWithoutAnyGetterSetter() throws JsonProcessingException
	{	
		String jsonToDeserialized = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\"\r\n" + 
				"}\r\n" + 
				"";
		ObjectMapper objectMapper = new ObjectMapper();
		Employee_PrivateFieldsWithoutAnyGetterSetterMethods employee_PrivateFieldsWithoutAnyGetterSetterMethods = 
				objectMapper.readValue(jsonToDeserialized, Employee_PrivateFieldsWithoutAnyGetterSetterMethods.class);
		System.out.println(employee_PrivateFieldsWithoutAnyGetterSetterMethods);
		
	}
	
	/*
	 * Output
	 * ======
	 * {
  			"firstName" : null
	   }
	 */
	@Test
	public void serializePrivateFieldsWithSomeGetterMethods() throws JsonProcessingException
	{
		Employee_PrivateFieldsWithSomeGetterMethods employee_PrivateFieldsWithSomeGetterMethods = 
				new Employee_PrivateFieldsWithSomeGetterMethods();
		ObjectMapper objectMapper = new ObjectMapper();
		String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee_PrivateFieldsWithSomeGetterMethods);
		System.out.println(serializedJson);		
	}
	
	@Test
	public void deserializePrivateFieldsWithSomeGetterMethods() throws JsonProcessingException
	{	
		String jsonToDeserializedWithoutLastName = "{\r\n" + 
				"  \"firstName\": \"Amod\"\r\n" +  
				"}\r\n" + 
				"";
		
		String jsonToDeserializedWithLastName = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\"\r\n" + 
				"}\r\n" + 
				"";
		ObjectMapper objectMapper = new ObjectMapper();
		Employee_PrivateFieldsWithSomeGetterMethods employee_PrivateFieldsWithSomeGetterMethods1 = 
				objectMapper.readValue(jsonToDeserializedWithoutLastName, Employee_PrivateFieldsWithSomeGetterMethods.class);
		System.out.println(employee_PrivateFieldsWithSomeGetterMethods1.getFirstName());
		Employee_PrivateFieldsWithSomeGetterMethods employee_PrivateFieldsWithSomeGetterMethods2 = 
				objectMapper.readValue(jsonToDeserializedWithLastName, Employee_PrivateFieldsWithSomeGetterMethods.class);
		System.out.println(employee_PrivateFieldsWithSomeGetterMethods2);
	

}
	
	@Test
	public void serializePrivateFieldsWithSomeSetterMethods() throws JsonProcessingException
	{
		Employee_PrivateFieldsWithSomeSetterMethods employee_PrivateFieldsWithSomeSetterMethods = 
				new Employee_PrivateFieldsWithSomeSetterMethods();
		employee_PrivateFieldsWithSomeSetterMethods.setFirstName("Amod");
		ObjectMapper objectMapper = new ObjectMapper();
		String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee_PrivateFieldsWithSomeSetterMethods);
		System.out.println(serializedJson);		
	}
	
	@Test
	public void deserializePrivateFieldsWithSomeSetterMethods() throws JsonProcessingException
	{	
		String jsonToDeserializedWithoutLastName = "{\r\n" + 
				"  \"firstName\": \"Amod\"\r\n" +  
				"}\r\n" + 
				"";
		
		String jsonToDeserializedWithLastName = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\"\r\n" + 
				"}\r\n" + 
				"";
		ObjectMapper objectMapper = new ObjectMapper();
		Employee_PrivateFieldsWithSomeSetterMethods employee_PrivateFieldsWithSomeGetterMethods1 = 
				objectMapper.readValue(jsonToDeserializedWithoutLastName, Employee_PrivateFieldsWithSomeSetterMethods.class);
		System.out.println(employee_PrivateFieldsWithSomeGetterMethods1);
		Employee_PrivateFieldsWithSomeSetterMethods employee_PrivateFieldsWithSomeGetterMethods2 = 
				objectMapper.readValue(jsonToDeserializedWithLastName, Employee_PrivateFieldsWithSomeSetterMethods.class);
		System.out.println(employee_PrivateFieldsWithSomeGetterMethods2);
	

}
}
