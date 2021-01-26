package com.techelevator;

public class CheckingAccount extends BankAccount {
	
	public CheckingAccount(String accountNumber, String accountHolderName) {
		super(accountNumber, accountHolderName);
		super.getBalance();
	}
	
	public CheckingAccount(String accountNumber, String accountHolderName, int balance) {
		super(accountNumber, accountHolderName, balance);
	}
	
	@Override
	public int withdraw(int amountToWithdraw) {
		if(super.getBalance() - amountToWithdraw <= -100 ) {
			return super.getBalance();
		} else if( super.getBalance() - amountToWithdraw < 0) {
			return super.withdraw(amountToWithdraw + 10);
		} else {
			return super.withdraw(amountToWithdraw);
		}
	}

}
