package com.techelevator.vendingmachine;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.snack.Chip;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.vendingmachine.change.Change;
import com.techelevator.vendingmachine.change.ChangeMaker;
import com.techelevator.vendingmachine.change.MinimumChangeMaker;
import com.techelevator.vendingmachine.exception.InsufficientFundsException;
import com.techelevator.vendingmachine.exception.InvalidSlotLocationException;
import com.techelevator.vendingmachine.exception.SoldOutException;
import com.techelevator.vendingmachine.inventory.FakeInventory;
import com.techelevator.vendingmachine.inventory.Inventory;
import com.techelevator.vendingmachine.inventory.Slot;
import com.techelevator.vendingmachine.log.Auditable;
import com.techelevator.vendingmachine.log.FakeAuditLog;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTests {
	private Auditable fakeAuditLog;
	private ChangeMaker changeMaker;
	private Inventory fakeInventory;
	private VendingMachine vendingMachine;

	@Before
	public void setup() {
		Slot a1 = new Slot("A1");
		a1.addItem(new Chip("Stackers", BigDecimal.valueOf(1.45)));
		a1.addItem(new Chip("Stackers", BigDecimal.valueOf(1.45)));
		
		Map<String, Slot> testMap = new LinkedHashMap<String, Slot>();
		testMap.put("A1", a1);
				
		fakeInventory = new FakeInventory(testMap);
		fakeAuditLog = new FakeAuditLog();
		changeMaker = new MinimumChangeMaker();
		vendingMachine = new VendingMachine(fakeInventory, changeMaker, fakeAuditLog);
	}

	@Test
	public void feedMoney_negative_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.valueOf(-1));

		// Assert
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_unacceptable_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.valueOf(100));

		// Assert
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_null_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(null);

		// Assert
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_once_increases_balance() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.ONE);

		// Assert
		Assert.assertTrue(acceptedPayment);
		Assert.assertEquals(BigDecimal.ONE, vendingMachine.getBalance());
	}

	@Test
	public void feedMoney_many_times_increases_balance() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.ONE);
		acceptedPayment &= vendingMachine.feedMoney(BigDecimal.valueOf(2));
		acceptedPayment &= vendingMachine.feedMoney(BigDecimal.valueOf(5));
		acceptedPayment &= vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Assert
		Assert.assertTrue(acceptedPayment);
		Assert.assertEquals(BigDecimal.valueOf(18), vendingMachine.getBalance());
	}

	@Test
	public void toString_displays_items() {
		// Arrange
		String expected = "A1 Stackers $1.45, 2 remaining.\n";

		// Act
		String actual = vendingMachine.toString();

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void toString_displays_sold_out() {
		// Arrange
		String expected = "A1 Sold Out\n";


		// Feed 20 dollars
		vendingMachine.feedMoney(BigDecimal.valueOf(10));
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Vend 5 out of 5 items
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");

		// Act
		String actual = vendingMachine.toString();

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = InvalidSlotLocationException.class)
	public void purchaseItem_invalid_slot_rejects() {
		vendingMachine.purchaseItem("");
	}

	@Test(expected = InvalidSlotLocationException.class)
	public void purchaseItem_null_slot_rejects() {
		vendingMachine.purchaseItem(null);
	}

	@Test(expected = SoldOutException.class)
	public void purchaseItem_sold_out_slot_rejects() {
		// Arrange
		
		// Feed 5 dollars
		vendingMachine.feedMoney(BigDecimal.valueOf(5));

		// Vend 2 out of 2 items
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");

		// Act
		vendingMachine.purchaseItem("A1"); // vending again causes exception
	}

	@Test(expected = InsufficientFundsException.class)
	public void purchaseItem_insufficient_funds_rejects() {
		// Act
		vendingMachine.purchaseItem("A1");
	}

	@Test
	public void purchaseItem_reduces_balance() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		vendingMachine.purchaseItem("A1");

		// Assert
		Assert.assertEquals(BigDecimal.valueOf(8.55), vendingMachine.getBalance());
	}

	@Test
	public void finishTransaction_reduces_balance_to_zero() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		vendingMachine.finishTransaction();

		// Assert
		Assert.assertEquals(BigDecimal.ZERO, vendingMachine.getBalance());
	}

	@Test
	public void finishTransaction_returns_change() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		Change change = vendingMachine.finishTransaction();

		// Assert
		Assert.assertNotNull(change);
	}

//	@Test
//	public void finishTransaction_prefers_quarters_over_other_coins() {
//		// Arrange
//		String expectedChange = "40 quarters";
//		vendingMachine.feedMoney(BigDecimal.valueOf(10));
//
//		// Act
//		Change change = vendingMachine.finishTransaction();
//
//		// Assert
//		Assert.assertEquals(expectedChange, change);
//	}
//	
//	@Test
//	public void finishTransaction_gets_quarters_dimes_nickels() {
//		// Arrange
//		String expectedChange = "28 quarters 1 dime 1 nickel";
//		vendingMachine.feedMoney(BigDecimal.valueOf(10));
//
//		vendingMachine.purchaseItem("D2");
//		vendingMachine.purchaseItem("D2");
//		vendingMachine.purchaseItem("D2");
//
//		// Act
//		Change change = vendingMachine.finishTransaction();
//
//		// Assert
//		Assert.assertEquals(expectedChange, change);
//	}
}
