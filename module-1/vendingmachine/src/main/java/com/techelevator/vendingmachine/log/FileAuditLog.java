package com.techelevator.vendingmachine.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.techelevator.MoneyFormatter;

public class FileAuditLog implements Auditable {
	private final File inputFile;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	private static final String FEED_MONEY = "FEED MONEY";
	private static final String GIVE_CHANGE = "GIVE CHANGE";
	
	
	public FileAuditLog(File inputFile) {
		this.inputFile = inputFile;
		
		// Create from scratch
		if(this.inputFile.exists()) {
			this.inputFile.delete();
		}
	}

	@Override
	public boolean logMoneyFed(BigDecimal amountFed, BigDecimal balance) {
		return log(FEED_MONEY, amountFed, balance);
	}

	@Override
	public boolean logPurchaseMade(String itemPurchased, BigDecimal priorBalance, BigDecimal postBalance) {
		return log(itemPurchased, priorBalance, postBalance);
	}

	@Override
	public boolean logTransactionFinished(BigDecimal priorBalance, BigDecimal postBalance) {
		return log(GIVE_CHANGE, priorBalance, postBalance);
	}
	
	private boolean log(String action, BigDecimal priorBalance, BigDecimal postBalance) {
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile, true))) {
			String formattedDate = LocalDateTime.now().format(formatter);
			String priorBalanceFormatted = MoneyFormatter.formatMoney(priorBalance);
			String postBalanceFormatted = MoneyFormatter.formatMoney(postBalance);
			
			writer.println(formattedDate + " " + action + " " + priorBalanceFormatted + " " + postBalanceFormatted);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}
