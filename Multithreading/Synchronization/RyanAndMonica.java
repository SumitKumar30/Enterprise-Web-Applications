package synchronization;

public class RyanAndMonica implements Runnable{
	BankAccount account;
	
	RyanAndMonica(){
		account = new BankAccount();
	}
	@Override
	public void run() {
			for(int i = 0; i <= 4; i++) {
				makeWithdrawl(30);
			}
	}
	
	synchronized void  makeWithdrawl(int amount) {
			// Step 1. Check the balance
			if(account.getBalance() > amount) {
				
				System.out.println(Thread.currentThread().getName()+" is going to withdraw "+ amount+" rupees");
			
				try {
					System.out.println(Thread.currentThread().getName()+" is going to sleep...");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Step 3. Withdraw money
				System.out.println(Thread.currentThread().getName()+" is going to withdraw");
				account.withdraw(amount);
				System.out.println("Accout balance is: "+account.getBalance());
				System.out.println(Thread.currentThread().getName()+" has withdrawn.. "+amount);
			}
			else
				System.out.println("Not sufficient amount for "+Thread.currentThread().getName());
			
	}
}
