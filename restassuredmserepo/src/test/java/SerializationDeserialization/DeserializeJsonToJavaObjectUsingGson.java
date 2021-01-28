package SerializationDeserialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

public class DeserializeJsonToJavaObjectUsingGson {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException, FileNotFoundException {

		// De-serializing from JSON String
		String jsonString = "{\r\n" + "  \"firstName\" : \"Amod\",\r\n" + "  \"lastName\" : \"Mahajan\",\r\n"
				+ "  \"gender\" : \"M\",\r\n" + "  \"age\" : 29,\r\n" + "  \"salary\" : 10987.77,\r\n"
				+ "  \"married\" : false\r\n" + "}";

		Gson gson = new Gson();
		// Pass JSON string and the POJO class
		Employee employeeObject = gson.fromJson(jsonString, Employee.class);
		// Now use getter method to retrieve values
		String firsName = employeeObject.getFirstName();
		String lastName = employeeObject.getLastName();
		String gender = employeeObject.getGender();
		int age = employeeObject.getAge();
		double salary = employeeObject.getSalary();
		boolean married = employeeObject.getMarried();

		System.out.println("Details of Employee is as below:-");
		System.out.println("First Name : " + firsName);
		System.out.println("Last Name : " + lastName);
		System.out.println("Gender : " + gender);
		System.out.println("Age : " + age);
		System.out.println("Salary : " + salary);
		System.out.println("Married : " + married);

		// De-serializing from a json file
		String userDir = System.getProperty("user.dir");
		File inputJsonFile = new File(userDir + "\\src\\test\\resources\\EmployeePayloadUsingGson.json");
		FileReader fileReader = new FileReader(inputJsonFile);
		Employee employeeObject1 = gson.fromJson(fileReader, Employee.class);

		// Now use getter method to retrieve values
		String firsName1 = employeeObject1.getFirstName();
		String lastName1 = employeeObject1.getLastName();
		String gender1 = employeeObject1.getGender();
		int age1 = employeeObject1.getAge();
		double salary1 = employeeObject1.getSalary();
		boolean married1 = employeeObject1.getMarried();

		System.out.println("Details of Employee from json file is as below:-");
		System.out.println("First Name : " + firsName1);
		System.out.println("Last Name : " + lastName1);
		System.out.println("Gender : " + gender1);
		System.out.println("Age : " + age1);
		System.out.println("Salary : " + salary1);
		System.out.println("Married : " + married1);
	}
}
