// Different package
package AnotherPackage;

import JavaConcepts.StaticMembers;

public class AnotherClassWithoutStaticImport {

	public static void main(String[] args) {

		// Use class name to call static members
		// need to import class StaticMembers
		System.out.println(StaticMembers.name);
		StaticMembers.printName();
	}
}
