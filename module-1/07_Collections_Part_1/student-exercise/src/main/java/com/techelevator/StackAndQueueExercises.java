package com.techelevator;

import java.util.*;



public class StackAndQueueExercises {

	/*
	 Given a List of Strings, return a new list in reverse order of the original. One obvious solution is to
	 simply loop through the original list in reverse order, but see if you can come up with an alternative
	 solution. (Hint: Think LIFO (i.e. stack))
	 reverseList( ["purple", "green", "blue", "yellow", "green" ])  -> ["green", "yellow", "blue", "green", "purple" ]
	 reverseList( ["jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"} )
		-> ["way", "the", "all", "jingle", "bells", "jingle", "bells", "jingle"]
	 */
	public List<String> reverseList(List<String> stringList) {
		List<String> stringReversed = new ArrayList<String>();
		for( int i = 0; i < stringList.size(); i++ ) {
			stringReversed.add(stringList.get( stringList.size() - 1 - i ) );
		}
		return stringReversed;
	}
	
	/*
	 Given a list of Integers representing seat numbers, group them into ranges 1-10, 11-20, and 21-30.
	 (Any seat number less than 1, or greater than 30 is invalid, and can be ignored.) Preserve the order
	 in which the seat number entered their associated group. Return a list of the grouped Integers 1-10,
	 11-20, and 21-30. (Hint: Think multiple queues)
	 boardingGate( [1, 13, 43, 22, 8, 11, 30, 2, 4, 14, 21] ) -> [1, 8, 2, 4, 13, 11, 14, 22, 30, 21]
	 boardingGate( [29, 19, 9, 21, 11, 1, 0, 25, 15, 5, 31] ) -> [9, 1, 5, 19, 11, 15, 29, 21, 25]
	 boardingGate( [0, -1, 44, 31, 17, 7, 27, 16, 26, 6] ) -> [7, 6, 17, 16, 27, 26]
	 */
	public List<Integer> boardingGate(List<Integer> seatNumberList) {
		List<Integer> groupOne = new ArrayList<Integer>();
		List<Integer> groupTwo = new ArrayList<Integer>();
		List<Integer> groupThree = new ArrayList<Integer>();
		List<Integer> groupAll = new ArrayList<Integer>();
		for( int i = 0; i < seatNumberList.size(); i++ ) {
			if( seatNumberList.get(i) > 0 && seatNumberList.get(i) <= 10 ) {
				groupOne.add(seatNumberList.get(i) );
			}
			if( seatNumberList.get(i) > 10 && seatNumberList.get(i) <= 20 ) {
				groupTwo.add(seatNumberList.get(i) );
			}
			if( seatNumberList.get(i) > 20 && seatNumberList.get(i) <= 30 ) {
				groupThree.add(seatNumberList.get(i) );
			}	
		} 
		
		for( int i = 0; i < groupOne.size(); i++ ) {
			groupAll.add(groupOne.get(i) );
		}
		for( int i = 0; i < groupTwo.size(); i++ ) {
			groupAll.add(groupTwo.get(i) );
		}
		for( int i = 0; i < groupThree.size(); i++ ) {
			groupAll.add(groupThree.get(i) );
		}
		
		
		return groupAll;
	}


}
