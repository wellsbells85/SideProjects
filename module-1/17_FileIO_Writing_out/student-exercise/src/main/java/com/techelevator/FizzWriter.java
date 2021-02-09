package com.techelevator;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); //create scanner
		boolean overwrite = false;
		boolean repeat = true;
		
		System.out.println("===============================================");
		System.out.println("          Welcome to the FizzWriter ");
		System.out.println("I'll make sure your output is stored correctly!");
		System.out.println("===============================================\n");
		
//		while(repeat) {
//			System.out.print("\nEnter the path directory you need (enter period . for default): ");
//			String path = scanner.nextLine();
//			File directory = new File(path);
//			System.out.println("The current directory is: \n" + directory.getAbsolutePath());
//			System.out.print("\nIs this correct? (Y or N)");
//			String answer = scanner.nextLine();
//			if(answer.equalsIgnoreCase("y") ) {
//				repeat = false;
//			} 
//		}
		
//		System.out.print("\nPlease enter the name of the file you wish to create: ");
		String pathName = "FizzBuzz.txt"; //name the file
		File fileName = new File(pathName); //create the file object
		
		if(fileName.exists() ) {
			System.out.print("\nSorry, the file already exists. Would you like to overwrite it? (Y or N)");
			String answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n") ) {
				System.out.print("\nOk, would you like to create a new file? (Y or N)" );
				answer = scanner.nextLine();
					if(answer.equalsIgnoreCase("n") ) {
						System.out.println("\nThere's nothing else I can for you then. Good Bye!");
						System.exit(0); //exit normally because user does not meet basic requirements for using program
					} else {
						System.out.println("\nI'm going to append the file name and try again for you!");
						String[] fileNameParts = pathName.split("\\.");
						pathName = fileNameParts[0];
						for(int i = 0; i < Integer.MAX_VALUE - 1; i += 0) {
							String appendPathName = String.valueOf(++i); //convert i into a string
							pathName = pathName + appendPathName + ".txt"; //add the string to the end of the path name
							fileName = new File(pathName); //create the updated file
							if(!fileName.exists() ) { //check if the new file exists
								break; //break out if it does
							} else { //else split the fileName with regex
								fileNameParts = pathName.split("[\\d+]*\\.");
								pathName = fileNameParts[0];
							}
						}
					}
			} else if(answer.equalsIgnoreCase("y") ) {
				System.out.println("\nOk, we're just going to overwrite your existing file then.");
				overwrite = !overwrite;
				repeat = !repeat;	
			}
		}	
		
			
		try {
			fileName.createNewFile(); //write the file
		} catch (IOException e) {		
			System.out.println("\nSorry, there was an error, and we were unable to create the file.");
			System.out.println("Please contact the IT Department.");
			System.exit(1); //end with an irregular error
		} // end try-catch

		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, overwrite ))) {
			for(int i = 1; i <= 300; i++) {
				String textToPrint = FizzBuzz(i);
				writer.println(textToPrint);
			}	writer.close();		
		} catch(IOException e) {
			System.out.println("\nThe program was unable to write your file. Sorry.");
			System.exit(1); //end the program with an irregular error
		}
	} //end main


	public static String FizzBuzz(int number) {
		String input = String.valueOf(number);
		if(number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		} else if (number % 3 == 0 || input.contains("3") ) {
			return "Fizz";
		} else if (number % 5 == 0 || input.contains("5") ) {
			return "Buzz";
		} else {
			return input;
		}
	} 
} // end class
