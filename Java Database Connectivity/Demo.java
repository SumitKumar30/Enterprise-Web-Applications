package jdbcDemo;

public class Demo {

	static {
		System.out.println("This is Demo Static");
	}
	
	{
		System.out.println("This is instance of Demo");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("jdbcDemo.Dummy");
//		Dummy dm = new Dummy();
//		Demo demo = new Demo();
	}
	
	
}

class Dummy{
	static {
		System.out.println("This is inside static");
	}
	
	// instance block
	{
		System.out.println("This is instance block"); 
	}
}
