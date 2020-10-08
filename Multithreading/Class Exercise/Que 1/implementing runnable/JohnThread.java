package ClassExercise;

public class JohnThread implements Runnable{
	private String threadName;
	
	JohnThread(String name){
		this.threadName = name;
		System.out.println(this.threadName+" created!");
	}
	
	// Define the job of John thread
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			// Generate random numbers
			int random = (int)(Math.random()*100);
			if(random % 2 == 0) {
				HarryThread harry = new HarryThread("Harry", random);
				Thread harryThread = new Thread(harry);
				harryThread.start();
			}
			else
				System.out.println("Number generated is: "+random);
			// sleep of 1 second --> waiting/blocking state
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.threadName+" says Job is done!!"); 
	}
}
