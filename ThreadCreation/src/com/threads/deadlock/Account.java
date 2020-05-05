package com.threads.deadlock;

public class Account {

	public Double balance = 10000d;

	public void withdraw(Double amount) {
		balance -= amount;
	}

	public void addAmount(Double amount) {
		balance += amount;
	}

	public Double getBalance() {
		return balance;
	}

	public static void transfer(Account withDrawAcc, Account depositAccount, Double amount) {
		withDrawAcc.withdraw(amount);
		depositAccount.addAmount(amount);
	}
}
