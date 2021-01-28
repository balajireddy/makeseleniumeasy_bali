package JavaConcepts;

public class NonBuilderPattern {
	
	public void M1()
	{
		System.out.println("M1");
	}
	
	public void M2(String str)
	{
		System.out.println("Pass string is "+str);
	}
	
	public void M3()
	{
		System.out.println("M3");
	}

	public static void main(String[] args) {
		
		NonBuilderPattern nbp = new NonBuilderPattern();
		nbp.M1();
		nbp.M2("Amod");
		nbp.M3();
	}
}
