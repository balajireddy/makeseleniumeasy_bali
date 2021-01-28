package JacksonTutorials;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AnnotationJsonIncludeExample2 {

	public static void main(String[] args) throws JsonProcessingException {

		// Just create an object of Pojo class
		EmployeePojoWithDefaultValues employee = new EmployeePojoWithDefaultValues();
		// Set value as you wish
//		employee.setFirstName("Amod");
		employee.setLastName("Mahajankjhkj");
//		employee.setSalary(3434343);
//		employee.setMarried(true);
		
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(employeeJson);
	}
}
