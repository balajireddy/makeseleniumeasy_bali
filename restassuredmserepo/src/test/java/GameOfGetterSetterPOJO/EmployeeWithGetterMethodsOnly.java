package GameOfGetterSetterPOJO;


public class EmployeeWithGetterMethodsOnly {

	// private variables or data members of pojo class
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean married;
	
	// Getter methods only
	public String getFirstName() {
		System.out.println("Getter - First Name : "+ firstName);
		return firstName;
	}
	
	public String getLastName() {
		System.out.println("Getter - Last Name : "+ lastName);
		return lastName;
	}
	
	public String getGender() {
		System.out.println("Getter - Gender : "+ gender);
		return gender;
	}
	
	public int getAge() {
		System.out.println("Getter - Age : "+ age);
		return age;
	}
	
	public double getSalary() {
		System.out.println("Getter - Salary : "+ salary);
		return salary;
	}
	
	public boolean getMarried() {
		System.out.println("Getter - Married : "+ married);
		return married;
	}
		
}

