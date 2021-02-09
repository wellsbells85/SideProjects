package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountAsString = scanner.nextLine();
        double discountAsDouble = Double.parseDouble(discountAsString);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String seriesOfPrices = scanner.nextLine();
        String[] pricesSeparated = seriesOfPrices.split(" ");
        
        for( int i=0; i < pricesSeparated.length; i++ ) {
        	String pricesAsString = pricesSeparated[i];
        	double price = Double.parseDouble(pricesAsString);
        	
        	System.out.println("Price: " + price + "\t" + "Discount Prices: " + (price * discountAsDouble));
        }





    }

}