package PojoPayloads;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class MSE_EmployeePojo {

	private String firstName;
	private String lastName;
	private String gender;

	private int age;
	private double salary;
	private boolean married;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean getMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}
}

public class UsageOfMSE_EmployeePojo {
	
	public static void main(String[] args) throws IOException {
		
		MSE_EmployeePojo mse_EmployeePojo = new MSE_EmployeePojo();
		mse_EmployeePojo.setFirstName("Amod");
		mse_EmployeePojo.setLastName("Mahajan");
		mse_EmployeePojo.setAge(29);
		mse_EmployeePojo.setSalary(10987.77);
		mse_EmployeePojo.setMarried(false);
		mse_EmployeePojo.setGender("M");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String convertedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mse_EmployeePojo);
		System.out.println(convertedJson);
		
		String userDir = System.getProperty("user.dir");
		File outputJsonFile = new File(userDir+ "\\src\\test\\resources\\EmployeePayload.json");
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, mse_EmployeePojo);
		
		
		MSE_EmployeePojo mse_EmployeePojo2 = objectMapper.readValue(convertedJson, MSE_EmployeePojo.class);
		System.out.println(mse_EmployeePojo2.getFirstName());
		System.out.println(mse_EmployeePojo2.getLastName());
		System.out.println(mse_EmployeePojo2.getGender());
		System.out.println(mse_EmployeePojo2.getSalary());
		System.out.println(mse_EmployeePojo2.getAge());
		System.out.println(mse_EmployeePojo2.getFirstName());
	}

}
