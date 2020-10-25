package demoPrograms;

public class Priority implements Runnable{
//	static int count;
	int count = 0;
	String threadName = "";
	static boolean stop; // shared among both thread
	Thread t;
//	Priority(){
////			t = new Thread(this, name);
//			count = 0;
//			this.threadName = name;
//	}
	Priority(int count){
		this.count = count;
		stop = false;
	}
	
	@Override
	public void run() {
//		int count = 0;
		
		// iterate for 10 Million times
		Thread curr = Thread.currentThread();
		
//		threadName = curr.getName();
		
		System.out.println("Starting thread "+curr.getName());
		
		do {
				count++;
//				if(this.threadName.compareTo(t.getName()) != 0) {
//					System.out.println("Executing "+t.getName()+" inside loop");
//				}
				System.out.println("count is: "+count);
		}while(stop == false && count < 10 );
		stop = true;
		System.out.println("Terminating "+curr.getName()+" count is: "+count);
	}
}
