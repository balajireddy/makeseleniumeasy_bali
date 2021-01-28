package PojoPayloads;

public class EmployeeDetails {

	public static void main(String[] args) {
		
		Employee amod = new Employee("Amod", "Mahajan", 100000, "Benagluru", false, 'M');
		Employee animesh = new Employee("Animesh", "Prashant", 200000, "Benagluru", true, 'M');
		
		// Get married status of Amod
		System.out.println("Is Amod married? : "+amod.isMarried());
		
		// Amod is married now and change data
		amod.setMarried(true);
		System.out.println("Is Amod married now ? : "+amod.isMarried());
		
		// Increase salary of animesh
		animesh.setSalary(500000);
		System.out.println("Updated salary of animesh : "+ animesh.getSalary());
	}
}
