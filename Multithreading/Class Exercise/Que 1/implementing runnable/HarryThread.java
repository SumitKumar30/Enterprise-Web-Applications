package ClassExercise;

public class HarryThread implements Runnable{
	private String threadName;
	private int number;
	HarryThread(String name, int number){
		this.threadName = name;
		this.number = number;
		System.out.println(this.threadName+" created!");
	}
	// define the job of harry thread
	@Override
	public void run() {
		System.out.println("Running "+this.threadName+" thread....");
		System.out.println("Square of the number is: "+square(this.number));
		System.out.println("Exiting "+this.threadName+" thread....");
	}
	
	// function to compute square of a number 
	int square(int number) {
		return number*number;
	}
}
