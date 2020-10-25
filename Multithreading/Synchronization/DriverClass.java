package synchronization;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RyanAndMonica obj = new RyanAndMonica();
		Thread t1 = new Thread(obj, "Ryan");
		Thread t2 = new Thread(obj,"Monica");
		
		t1.start();
		t2.start();
	}

}
