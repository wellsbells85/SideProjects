package com.techelevator;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.Stack;

import java.util.*; // all java.util CLASSES ... NOT java.util.concurrent.* (for example)
import java.util.concurrent.*; // would also be necessary

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<String>();
		
		names.size(); // 0
		names.add("Tom A");
		names.add("Beth C");
		names.add("Tom M");
		names.add("Walt I");
		
		names.size(); // 4
		
		
		

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(int i = 0; i < names.size(); i++) {
			String thisName = names.get(i);
			
			System.out.print("i: " + i + "\t");
			System.out.println(thisName);
			
		}
		
		

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		System.out.println("List size: " + names.size());

		names.add("Walt I");

		System.out.println("List size: " + names.size());
		for(int i = 0; i < names.size(); i++) {
			String thisName = names.get(i);
			
			System.out.print("i: " + i + "\t");
			System.out.println(thisName);
			
		}
	
		
		

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2, "Marissa");
		names.add(2, "Ellen");

		for(int i = 0; i < names.size(); i++) {
			String thisName = names.get(i);
			
			System.out.print("i: " + i + "\t");
			System.out.println(thisName);
			
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(2);
		
		for(int i = 0; i < names.size(); i++) {
			String thisName = names.get(i);
			
			System.out.print("i: " + i + "\t");
			System.out.println(thisName);
			
		}
		
		
		

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		
		names.contains("Josh"); // false
		names.contains("Tom");  // false
		names.contains("Tom M"); // true
				
		if(names.contains("Tom M")) {
			System.out.println("Hello, Tom M!");
		}
		
		
		

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		names.indexOf("Tom M");     // 2
		names.lastIndexOf("Tom M"); // 2
		names.indexOf("Tom");       // -1
		

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		int numberOfNames = names.size();
		String[] namesAsArray = new String[numberOfNames];
		namesAsArray = names.toArray(namesAsArray);
		

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);
		System.out.println(names);
		

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);
		System.out.println(names);

		// PRIMITIVE WRAPPER CLASSES
		
		List<Integer> scores = new ArrayList<Integer>();
		
		scores.add(3); // Auto-box and Auto-unbox
		scores.add(0);
		scores.add(10);
		
		Collections.reverse(scores);
		System.out.println(scores);
		
		Integer.parseInt("3"); // 3
		
		System.out.println(Integer.toBinaryString(53) );
		
//		IMMUTABLE
//		Integer 
//		Double
//		Long
//		Float
//		Character
//		Boolean
		
		
		
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for(String name : names) {
			System.out.println(name + " is in this list");
		}

		System.out.println("####################");
		System.out.println("       QUEUE");
		System.out.println("####################");
		System.out.println();

		
		// Queue:    add -> "offer" & remove -> "poll"
		//   FIFO -- a regular line
		Queue<String> priorities = new LinkedList<String>();
		priorities.offer("Clean the floors");
		priorities.offer("Do the dishes");
		priorities.offer("Change your sheets");
		
		while(priorities.size() > 0) {
			String nextPriority = priorities.poll();
			System.out.println("Do this next: " + nextPriority);
		}
		
		
		System.out.println("####################");
		System.out.println("       STACK");
		System.out.println("####################");
		System.out.println();
		
		// Stack:     add -> "push" & remove -> "pop"
		//   LIFO -- pancakes, plates -- Undo, Back
		Stack<String> websites = new Stack<String>();
		websites.push("www.techelevator.com");
		websites.push("www.google.com");
		websites.push("pittsburgh.craigslist.org");
		
		while(!websites.isEmpty()) {
			String lastWebsite = websites.pop();
			System.out.println("BACK: " + lastWebsite);
		}
		

	}
}
