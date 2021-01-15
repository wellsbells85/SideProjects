package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a temperature:");
		String temperatureInput = input.nextLine();
		double temperatureDouble = Double.parseDouble(temperatureInput);
		
		System.out.print("\n\nIs that in (C)elsius or (F)ahrenheit?:");
		String scaleInput = input.nextLine();
		
		if( scaleInput.contentEquals("f") || scaleInput.contentEquals("F") ) {
			double temperatureConverted = (temperatureDouble - 32) / 1.8;
			System.out.print("\n\n" + temperatureDouble + "F is " + temperatureConverted + "C");
		} 
		
		if( scaleInput.contentEquals("c") || scaleInput.contentEquals("C") ) {
			double temperatureConverted = (temperatureDouble * 1.8) + 32;
			System.out.print("\n\n" + temperatureDouble + "C is " + temperatureConverted + "F");
			
		} 
	}

}
