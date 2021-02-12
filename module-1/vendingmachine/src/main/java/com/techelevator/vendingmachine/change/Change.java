package com.techelevator.vendingmachine.change;

public class Change {
	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;
	
	public Change(int quarters, int dimes, int nickels, int pennies) {
		if(quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0) {
			throw new IllegalArgumentException("Invalid amount of coins. You must supply a positive integer value.");
		}
		
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickels = nickels;
		this.pennies = pennies;
	}
	
	public int getQuarters() {
		return quarters;
	}
	
	public int getDimes() {
		return dimes;
	}
	
	public int getNickels() {
		return nickels;
	}
	
	public int getPennies() {
		return pennies;
	}
	
	@Override
	public String toString() {
		if(quarters == 0 && dimes == 0 && nickels == 0 && pennies == 0) {
			return "No change";
		}
	
		String changeString = "";
		
		if(quarters == 1) {
			changeString += "1 quarter ";
		} else {
			changeString += quarters + " quarters ";
		}
		
		if(dimes == 1) {
			changeString += "1 dime ";
		} else {
			changeString += dimes + " dimes ";
		}
		
		if(nickels == 1) {
			changeString += "1 nickel ";
		} else {
			changeString += nickels + " nickels ";
		}
		
		if(pennies == 1) {
			changeString += "1 penny ";
		} else {
			changeString += pennies + " pennies ";
		}
		
		return changeString.substring(0, changeString.length() - 1); // remove last space
	}
}
