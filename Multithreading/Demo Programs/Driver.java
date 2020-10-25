package demoPrograms;

//How many threads get created in the following program?

class MyThreadDemo extends Thread { 
@Override
public void run() 
	{ 
		System.out.println("Run"); 
	} 
} 
public class Driver { 
public static void main(String[] args) 
	{ 
		MyThreadDemo t = new MyThreadDemo(); 
		t.run(); 
		System.out.println("Number of threads created: "+Thread.activeCount());
	} 
}

