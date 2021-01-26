package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	
	public CheckingAccount(String accountNumber, String accountHolderName) {
		super(accountNumber, accountHolderName);
		super.getBalance();
	}
	
	public CheckingAccount(String accountNumber, String accountHolderName, BigDecimal balance) {
		super(accountNumber, accountHolderName, balance);
	}
	
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(super.getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.valueOf(-100)) <= 0 ) {
			return super.getBalance();
		} else if( super.getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.ZERO) < 0) {
			return super.withdraw(amountToWithdraw.add(BigDecimal.TEN));
		} else {
			return super.withdraw(amountToWithdraw);
		}
	}

}
