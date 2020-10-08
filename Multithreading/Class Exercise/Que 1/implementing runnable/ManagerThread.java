package ClassExercise;

public class ManagerThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JohnThread john = new JohnThread("John");		// object of John class
		Thread t1 = new Thread(john);		// will assign job to John thread
		t1.start();
	}

}
