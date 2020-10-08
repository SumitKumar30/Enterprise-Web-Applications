package ClassExercise;

public class RandomThread extends Thread {
	private String threadName;
	
	RandomThread(String name){
		this.threadName = name;
		System.out.println("Creating: "+this.threadName);
	}
	
	// Job will go inside run()
	@Override
	public void run() {
//		SecondThread second = new SecondThread(100, "Harry");
		for(int i = 0; i < 5; i++) {
			int random = (int)(Math.random()*100);
			
			// if random value is even --> create a new thread --> SecondThread object
			if(random % 2 == 0) {
				SecondThread second = new SecondThread(random, "Harry");
				second.start();
			}
			else
				System.out.println("Random value is: "+random);
			
			try {
				Thread.sleep(1000); // 1 second pause
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		System.out.println("Exiting "+this.threadName);
	}
}
