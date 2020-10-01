package demoPrograms;

public class MyThread extends Thread {
	private String threadName;	
	
	MyThread(String name){
		this.threadName = name;
		System.out.println("Creating: "+this.threadName);
	}
	
	// override the run() method --> to assign the task for my thread object
	public void run(){
		Thread t = Thread.currentThread();
		System.out.println("Priority of John is: "+t.getPriority());
		System.out.println("Running: "+this.threadName);
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("Running for: "+i+" times");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println(this.threadName+" is interrupted");
		}
		System.out.println("Terminating "+this.threadName);
	}
	
}
