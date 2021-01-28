// Class in same package as of StaticMembers
package JavaConcepts;

public class WithoutStaticImport {
	
	public static void main(String[] args) {
		
		// Use class name to call static members
		// No need to import class
		System.out.println(StaticMembers.name);
		StaticMembers.printName();
	}

}
