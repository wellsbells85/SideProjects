package com.techelevator;

public class CreditCardAccount extends BankAccount {
	
	private int debt;
	private String accountHolder;
	private String accountNumber;
	
	public CreditCardAccount(String accountHolder, String accountNumber) {
		super(accountHolder, accountNumber);
		debt = 0;
	}
	
	public int pay(int amountToPay) {
		debt = debt - amountToPay;
		return getDebt();
	}
	
	public int charge(int amountToCharge) {
		debt = debt + amountToCharge;
		return getDebt();
	}
	
	public String getAccountHolder() {
		return super.getAccountHolderName();
	}
	
	public String getAccountNumber() {
		return super.getAccountNumber();
	}
	
	public int getDebt() {
		return debt;
	}
	
	public int getBalance() {
		return -debt;
	}
}