package ThreadCommunication;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumer obj = new ProducerConsumer();
		Thread ryan = new Thread(obj, "Ryan");
		Thread monica = new Thread(obj, "Monica");
		
		ryan.start();
		monica.start();
	}

}
