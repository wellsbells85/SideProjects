package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String accountNumber, String accountHolderName) {
		super(accountNumber, accountHolderName);
		super.getBalance();
	}
	
	public SavingsAccount(String accountNumber, String accountHolderName, BigDecimal balance) {
		super(accountNumber, accountHolderName, balance);
	}
	
	@Override
	public int withdraw(int amountToWithdraw) {
		if(super.getBalance() - amountToWithdraw < 0) {
			return super.getBalance();
		} else if( super.getBalance() - amountToWithdraw < 150) {
			return super.withdraw(amountToWithdraw + 2);
		} else {
			return super.withdraw(amountToWithdraw);
		}
	}
}
