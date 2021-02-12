package com.techelevator.vendingmachine.log;

import java.math.BigDecimal;

public class FakeAuditLog implements Auditable {
	@Override
	public boolean logMoneyFed(BigDecimal amountFed, BigDecimal balance) {
		return true;
	}

	@Override
	public boolean logPurchaseMade(String itemPurchased, BigDecimal priorBalance, BigDecimal postBalance) {
		return true;
	}

	@Override
	public boolean logTransactionFinished(BigDecimal priorBalance, BigDecimal postBalance) {
		return true;
	}
}
