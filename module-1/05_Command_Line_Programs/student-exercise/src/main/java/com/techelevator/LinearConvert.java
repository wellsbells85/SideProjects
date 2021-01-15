package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a length:");
		String distanceInput = input.nextLine();
		double distanceDouble = Double.parseDouble(distanceInput);
		
		System.out.print("\n\nIs that in (M)eters or (F)eet?:");
		String scaleInput = input.nextLine();
		
		if( scaleInput.contentEquals("m") || scaleInput.contentEquals("M") ) {
			double distanceConverted = distanceDouble * 3.2808399;
			System.out.print("\n\n" + distanceDouble + "M is " + distanceConverted + "F");
		} 
		
		if( scaleInput.contentEquals("f") || scaleInput.contentEquals("F") ) {
			double distanceConverted = distanceDouble * 0.3048;
			System.out.print("\n\n" + distanceDouble + "F is " + distanceConverted + "M");
			
		} 

	}

}
