package com.techelevator;

import java.util.*;


public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		List<Integer> scores = new ArrayList<>();//collections can be instantiated without repeating the input variables         
		Map<String, String>	vendingMachine = new HashMap<String, String>();
		Set<Double> percentages = new HashSet<Double>();
		
		vendingMachine.put("A1", "Oreos");
		vendingMachine.put("A2", "Fritos");
		vendingMachine.put("A3", "Doritos");
		vendingMachine.put("A4", "Titos");
		
		vendingMachine.put("A3", "Taquitos");

		
		String snack = vendingMachine.get("B3");//will return a null
		
		System.out.println("You now have " + snack);
		
		boolean exists = vendingMachine.containsKey("B3");
		
		//vendingMachine.remove("A1"); //will not change other keys, they're not indexed
		System.out.println(vendingMachine);
		
		for( String key : vendingMachine.keySet() ) {
			System.out.print("Key is: " + key + " ");
			System.out.println("\tValue is: " + vendingMachine.get(key));
		}
		
		
		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();
		
		Set<String> names = new HashSet<String>();
		
		names.add("Walt");
		names.add("Tom");//this will overwrite the other Tom, NO DUPLICATES!
		names.add("Beth");
		names.add("Walt");
		
		names.remove("Beth");
		System.out.println(       names.contains("Beth") );
		
		
		System.out.println("This set has " + names.size() + " instructor");
		
		for(String name : names) {
			System.out.println(name + " is an instructor");
		}
		
		
		
	}

}
