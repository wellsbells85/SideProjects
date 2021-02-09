package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a maximum value: ");
		String stringInput = input.nextLine();
		int integerMaximum = Integer.parseInt(stringInput);
		
		int firstValue = 0;
		int secondValue = 1;
		int fibonacciValue = 1;
		
		while( firstValue <= integerMaximum) {
			System.out.print(firstValue + " ");
			fibonacciValue = firstValue + secondValue;
			firstValue = secondValue;
			secondValue = fibonacciValue;
			
		}

	}

}
