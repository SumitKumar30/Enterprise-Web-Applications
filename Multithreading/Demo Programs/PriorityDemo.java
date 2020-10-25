package demoPrograms;

public class PriorityDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Priority p1 = new Priority(0);
		Priority p2 = new Priority(0);
//		Priority p = new Priority();
		
		Thread t1 = new Thread(p1); 
		Thread t2 = new Thread(p2);
		
		t1.setName("John");
		t2.setName("Harry");
		
		t1.setPriority(Thread.MAX_PRIORITY); // John has maximum priority
		t2.setPriority(Thread.MIN_PRIORITY); // Harry has minimum priority
		
		t1.start();
		t2.start();
		
		
		
//		p1.t.start();
//		p2.t.start();
		
		// main thread will wait
			t1.join();
			t2.join();
		
//		System.out.println(t1.getName()+" counted to: "+p.count);
//		System.out.println(t2.getName()+" counted to: "+p.count);
		
		System.out.println("Main Thread Exiting...");
	}

}
