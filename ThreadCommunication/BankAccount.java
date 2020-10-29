package ThreadCommunication;

public class BankAccount {
	int balance = 10000; // initial balance is 10000 Rupees
	
	void withdraw(int amount) {
		balance = balance - amount; 
	}
	
	void deposit(int amount) {
		balance = balance + amount;
	}
	
	int getBalance() {
		return balance;
	}
}
