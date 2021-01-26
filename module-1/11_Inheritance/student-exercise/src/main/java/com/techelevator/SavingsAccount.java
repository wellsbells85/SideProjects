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
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(super.getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.ZERO) < 0) {
			return super.getBalance();
		} else if( super.getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.valueOf(150)) < 0) {
			return super.withdraw(amountToWithdraw.add(BigDecimal.valueOf(2)));
		} else {
			return super.withdraw(amountToWithdraw);
		}
	}
}
