package demoPrograms;

public class RunDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkerThread worker = new WorkerThread();
		Thread t1 = new Thread(worker);
		Thread t2 = new Thread(worker);
		Thread t3 = new Thread(worker);
		Thread t4 = new Thread(worker);
		Thread t5 = new Thread(worker);
		
		// make direct call to run()
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
