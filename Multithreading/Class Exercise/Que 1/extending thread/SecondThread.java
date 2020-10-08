package ClassExercise;

public class SecondThread extends Thread{
		private String threadName;
		private int number;
		
		SecondThread(int number, String name){
			this.number = number;
			this.threadName = name;
			System.out.println("Creating: "+this.threadName);
		}
		
		@Override
		public void run() {
			// square the random number
			System.out.println("Square of random value is: "+number*number);
			System.out.println("Exiting "+this.threadName);
		}
}
