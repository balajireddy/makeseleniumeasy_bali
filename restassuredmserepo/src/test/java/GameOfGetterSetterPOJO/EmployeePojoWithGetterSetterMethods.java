package GameOfGetterSetterPOJO;

import com.fasterxml.jackson.annotation.JsonInclude;

public class EmployeePojoWithGetterSetterMethods {

	// private variables or data members of pojo class
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean married;
	
	// Getter and setter methods
	public String getFirstName() {
		System.out.println("Getter - First Name : "+ firstName);
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("Setter - First Name : "+ firstName);
		this.firstName = firstName;
	}
	public String getLastName() {
		System.out.println("Getter - Last Name : "+ lastName);
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("Setter - Last Name : "+ lastName);
		this.lastName = lastName;
	}
	public String getGender() {
		System.out.println("Getter - Gender : "+ gender);
		return gender;
	}
	public void setGender(String gender) {
		System.out.println("Setter - Gender : "+ gender);
		this.gender = gender;
	}
	public int getAge() {
		System.out.println("Getter - Age : "+ age);
		return age;
	}
	public void setAge(int age) {
		System.out.println("Setter - Age : "+ age);
		this.age = age;
	}
	public double getSalary() {
		System.out.println("Getter - Salary : "+ salary);
		return salary;
	}
	public void setSalary(double salary) {
		System.out.println("Setter - Salary : "+ salary);
		this.salary = salary;
	}
	public boolean getMarried() {
		System.out.println("Getter - Married : "+ married);
		return married;
	}
	public void setMarried(boolean married) {
		System.out.println("Setter - Married : "+ married);
		this.married = married;
	} 	
}

