package com.techelevator;

import java.util.List;
import java.util.ArrayList;    

public class BankCustomer implements Accountable {
	
	private String name;
	private String address;
	private String phoneNumber;
	private int balance;
	private List<Accountable> accounts = new ArrayList<>();
	
	public BankCustomer() {
	}
	
	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount);
	}
	
	public boolean isVip() {
		if(getBalance() >= 25000) {
			return true;
		} return false;
	}
	
	public int getBalance() {
		for( int i = 0; i < accounts.size(); i++) {
			balance += accounts.get(i).getBalance();
		}
		return balance;
	}
	
	public Accountable[] getAccounts(){
		Accountable[] account = new Accountable[accounts.size()];
		for( int i = 0; i < accounts.size(); i++) {
			account[i] = accounts.get(i);	
		} return account;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	

}
