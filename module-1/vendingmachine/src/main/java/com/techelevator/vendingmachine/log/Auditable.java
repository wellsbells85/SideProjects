package com.techelevator.vendingmachine.log;

import java.math.BigDecimal;

public interface Auditable {

	boolean logMoneyFed(BigDecimal amountFed, BigDecimal balance);
	
	boolean logPurchaseMade(String itemPurchased, BigDecimal priorBalance, BigDecimal postBalance);
	
	boolean logTransactionFinished(BigDecimal priorBalance, BigDecimal postBalance);
}
