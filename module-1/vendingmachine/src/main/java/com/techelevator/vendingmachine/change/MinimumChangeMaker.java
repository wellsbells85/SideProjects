package com.techelevator.vendingmachine.change;

import java.math.BigDecimal;

public class MinimumChangeMaker implements ChangeMaker {

	public Change getChangeFor(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("Invalid amount. Amount must be greater than or equal to 0");
		}

		// Quarters
		int quarterCount = 0;
		BigDecimal QUARTER = BigDecimal.valueOf(0.25);
		while (amount.compareTo(QUARTER) >= 0) {
			quarterCount += 1;
			amount = amount.subtract(QUARTER);
		}

		// Dimes
		int dimeCount = 0;
		BigDecimal DIME = BigDecimal.valueOf(0.1);
		while (amount.compareTo(DIME) >= 0) {
			dimeCount += 1;
			amount = amount.subtract(DIME);
		}

		// Nickels
		int nickelCount = 0;
		BigDecimal NICKEL = BigDecimal.valueOf(0.05);
		while (amount.compareTo(NICKEL) >= 0) {
			nickelCount += 1;
			amount = amount.subtract(NICKEL);
		}

		// Pennies
		int pennyCount = 0;
		BigDecimal PENNY = BigDecimal.valueOf(0.01);
		while (amount.compareTo(PENNY) >= 0) {
			pennyCount += 1;
			amount = amount.subtract(PENNY);
		}

		return new Change(quarterCount, dimeCount, nickelCount, pennyCount);
	}
}
