package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	
	private String accountHolderName;
	private String accountNumber;
	private BigDecimal balance;
	
	public BankAccount(String accountHolderName, String accountNumber) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = BigDecimal.ZERO;
	}
	
	public BankAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		balance =  getBalance().add(amountToDeposit);
		return balance;
	}
	
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		balance = getBalance().subtract(amountToWithdraw);
		return balance;
	}
	
	
	
	
	

}
