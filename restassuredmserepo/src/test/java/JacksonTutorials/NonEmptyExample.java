package JacksonTutorials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class NonEmptyExample {

	@Test(priority = 1)
	public void noValuesSetForAnyField() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of noValuesSetForAnyField...");
		System.out.println(employeeJson);
	}
	
	@Test(priority = 2)
	public void valueSetForFields() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		seniorEmployee.setFirstName("Amod");
		seniorEmployee.setLastName("Mahajan");
		seniorEmployee.setAge(29);
		seniorEmployee.setGender("Male");
		seniorEmployee.setSalary(12323.56);
		seniorEmployee.setMarried(false);
		
		String[] mobileNo = new String[2];
		mobileNo[0] = "12345";
		mobileNo[1] = "67890";
		seniorEmployee.setMobileNo(mobileNo);
		
		List<String> cars = new ArrayList<String>();
		cars.add("Audi");
		cars.add("bmw");
		seniorEmployee.setCars(cars);
		
		Map<String,String> familyMembers = new HashMap<>();
		familyMembers.put("1", "Father");
		familyMembers.put("2", "Mother");
		familyMembers.put("3", "Brother");
		seniorEmployee.setFamilyMembers(familyMembers);
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of valueSetForFields...");
		System.out.println(employeeJson);
	}
	
	@Test(priority = 3)
	public void noValueSetForArrayListMap() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		seniorEmployee.setFirstName("Amod");
		seniorEmployee.setLastName("Mahajan");
		seniorEmployee.setAge(29);
		seniorEmployee.setGender("Male");
		seniorEmployee.setSalary(12323.56);
		seniorEmployee.setMarried(false);
		
		// Empty array
		String[] mobileNo = {};
		seniorEmployee.setMobileNo(mobileNo);
		
		// Empty list
		List<String> cars = new ArrayList<String>();
		seniorEmployee.setCars(cars);
		
		// Empty Map
		Map<String,String> familyMembers = new HashMap<>();
		seniorEmployee.setFamilyMembers(familyMembers);
		
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of noValueSetForArrayListMap...");
		System.out.println(employeeJson);
	}
	
	@Test(priority = 4)
	public void noValueSetForArrayListMap1() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		seniorEmployee.setFirstName("Amod");
		seniorEmployee.setLastName("Mahajan");
		//seniorEmployee.setAge(29);
		seniorEmployee.setGender("Male");
		seniorEmployee.setSalary(12323.56);
		seniorEmployee.setMarried(false);
		
		// Array will be initialized with default value i.e. null
		String[] mobileNo = new String[2];
		seniorEmployee.setMobileNo(mobileNo);
		
		// List with null value but isEmpty() return true.
		List<String> cars = new ArrayList<String>();
		seniorEmployee.setCars(null);
		seniorEmployee.setCars(null);
		System.out.println(cars.isEmpty());
		
		// Empty Map
		Map<String,String> familyMembers = new HashMap<>();
		familyMembers.put("1", null);
		familyMembers.put("2", "Aaditya");
		System.out.println(familyMembers.isEmpty());
		seniorEmployee.setFamilyMembers(familyMembers);
		
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY);
		//objectMapper.setDefaultPropertyInclusion(Include.NON_DEFAULT);
		
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of valueSetForFields...");
		System.out.println(employeeJson);
	}

}
