package JavaConcepts;

public class Usages {
	
	// Return type is I1 but returning an object of ImplementInterface1 which implements I1
	public static I1 someMethod1()
	{
		return new ImplementInterface1();
	}
	
	// Return type is I1 but returning an object of ImplementInterface2 which implements I1
	public static I1 someMethod2()
	{
		return new ImplementInterface2();
	}

}
