// Different package
package AnotherPackage;

import static JavaConcepts.StaticMembers.*;

public class AnotherClassWithStaticImport {

	public static void main(String[] args) {

		// Do not Use class name to call static members
		System.out.println(name);
		printName();
	}
}
