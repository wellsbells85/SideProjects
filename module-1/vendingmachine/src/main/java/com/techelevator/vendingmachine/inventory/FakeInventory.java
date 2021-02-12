package com.techelevator.vendingmachine.inventory;

import java.util.LinkedHashMap;
import java.util.Map;

public class FakeInventory implements Inventory {
	private Map<String, Slot> inventory; 
	
	public FakeInventory() {
		inventory = new  LinkedHashMap<String, Slot>();
	}
	
	public FakeInventory(Map<String, Slot> inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public void restock() {
		// do nothing
	}

	@Override
	public Map<String, Slot> getInventory() {
		 return inventory;
	}

}
