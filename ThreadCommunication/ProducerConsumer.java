package ThreadCommunication;

public class ProducerConsumer implements Runnable{
	BankAccount account;
	
	ProducerConsumer(){
		account = new BankAccount();
		System.out.println("Initial amount is: "+account.getBalance());
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().compareTo("Ryan") == 0) {
			synchronized(this) {
				
				for(int i = 0; i < 3; i++) {
					System.out.println("Ryan is going to withdraw for... "+(i+1)+" time");
					makewithdrawl(5000);
				}
			}
		}
		else {
			System.out.println(Thread.currentThread().getName()+" is Waiting for deposit...");
			synchronized(this) {
				makeDeposit(10000);
			}
			
		}
	}
	 void makewithdrawl(int amount) {
		if(account.getBalance() > 5000) {
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+" has withdrawn.. "+amount);
			System.out.println("Account balance is: "+account.getBalance());
		}
		else {
			System.out.println("Insufficient balance!! waiting for deposit..");
			notify(); // will wake up Monica 
			try {
				wait(); // wait for Monica to perform deposit
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	void makeDeposit(int amount) {	
		if(account.getBalance() > 5000) {
			try {
				wait(); // Monica will wait
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println(Thread.currentThread().getName()+" is going to Deposit");
			account.deposit(amount);
			System.out.println(Thread.currentThread().getName()+" has deposited "+amount);
			System.out.println("Account balance is: "+account.getBalance());
			notify(); // notify Ryan to withdraw now
		}
			
	}
	
	
}
