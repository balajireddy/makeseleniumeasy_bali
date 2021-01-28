package JavaConcepts;

import org.testng.annotations.Test;


public class SomeTest {
	
	@Test
	public void m1()
	{
		// Same reference type but different implementation is called
		I1 ref1 = Usages.someMethod1();
		ref1.printSomething();
		ref1.printAnything();
		
		
		I1 ref2 = Usages.someMethod2();
		ref2.printSomething();
		ref2.printAnything();
	}

}
