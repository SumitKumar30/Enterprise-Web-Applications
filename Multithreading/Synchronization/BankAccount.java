package synchronization;

public class BankAccount {
	int balance = 100; // initial balance is 100 Rupees
	
	void withdraw(int amount) {
		balance = balance - amount; 
	}
	
	int getBalance() {
		return balance;
	}
}
