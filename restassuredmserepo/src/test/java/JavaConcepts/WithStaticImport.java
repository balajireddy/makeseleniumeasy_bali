// Class in same package as of StaticMembers
package JavaConcepts;

import static JavaConcepts.StaticMembers.*;

public class WithStaticImport {
	
	public static void main(String[] args) {
		
		// No need to Use class name to call static members
		System.out.println(name);
		printName();
	}

}
