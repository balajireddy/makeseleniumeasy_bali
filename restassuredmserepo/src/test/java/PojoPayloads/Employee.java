package PojoPayloads;

public class Employee {
	
	// fields to store data
	public String firstName;
	public String lastName;
	public double salary;
	public String cityName;
	public boolean isMarried;
	public char gender;
	
	// Create employees with different data
	public Employee(String firstName, String lastName, double salary, String cityName, boolean isMarried,
			char gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.cityName = cityName;
		this.isMarried = isMarried;
		this.gender = gender;
	}
	
	// Public getter setter methods
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
