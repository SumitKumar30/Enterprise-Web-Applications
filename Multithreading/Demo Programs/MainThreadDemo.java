package demoPrograms;

public class MainThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Get a reference to main thread object using currentThread() 
		Thread main = Thread.currentThread();
		MyThread t1 = new MyThread("John"); // New state
		t1.setPriority(8);
//		System.out.println("Priority of John is: "+t1);
		t1.start();       // Runnable state, JVM calls the run() method
		main.setName("UniversalThread");
		System.out.println("Main thread is: "+main.getName());
		main.setPriority(2);
		System.out.println("Priority of Main thread is: "+main.getPriority());
		System.out.println(main.getName()+" is running");
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("This is iteration: " +i);
			    Thread.sleep(1000);  // sleep method will throw an InterruptedException
			}
		}
		catch(InterruptedException e) {
//			e.printStackTrace();
			System.out.println("Thread is interrupted");
		}
		
		System.out.println(main.getName()+" is terminating");
	}

}

