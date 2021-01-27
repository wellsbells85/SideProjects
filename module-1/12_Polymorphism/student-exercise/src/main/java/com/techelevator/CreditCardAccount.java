package com.techelevator;

public class CreditCardAccount extends BankAccount {
	
	private int debt;
	
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
	
	public int getDebt() {
		return debt;
	}
	
	public String getAccountHolder() {
		return super.getAccountHolderName();
	}
	
	public String getAccountNumber() {
		return super.getAccountNumber();
	}
	
	
	@Override
	public int getBalance() {
		return -debt;
	}
}