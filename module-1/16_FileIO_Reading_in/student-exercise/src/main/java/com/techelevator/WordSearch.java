package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		File userFile = getInputFileFromUser();
		boolean userCaseSensitive = false;
		String userString = getInputStringFromUser();
		System.out.print("Do you want case sensitive results only? (Y or N)");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.nextLine();
		if(answer.toUpperCase().equals("Y") ) {
			userCaseSensitive = true;
		}
		
		int lineCounter = 0;
		
		try(Scanner fileScanner = new Scanner(userFile)) {
			while(fileScanner.hasNextLine()) {
				lineCounter++;
				String line = fileScanner.nextLine();
				if(userCaseSensitive) {
					if(line.matches("(.*)(\\W)" + userString + "(\\W)(.*)") ){
						System.out.println(lineCounter + " " + line);
					} 
				} else {
					if(line.matches("(?i)(.*)(\\W)" + userString + "(\\W)(.*)") ) {
						System.out.println(lineCounter + " " + line);
					}
				}	
			}	
		}
	}
	
	private static File getInputFileFromUser() {
		Scanner fileScanner = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = fileScanner.nextLine();
			
		File inputFile = new File(path);
		if(!inputFile.exists() ) { // checks for the existence of a file
			System.out.println(path +" does not exist");
			System.exit(1); // Ends the program
		} else if(!inputFile.isFile() ) {
			System.out.println(path +" is not a file");
			System.exit(1); // Ends the program
		} return inputFile;
	} 	
	
	private static String getInputStringFromUser() {
		Scanner stringScanner = new Scanner(System.in);
		System.out.print("Please enter the string you wish to match >>> ");
		String userString = stringScanner.nextLine();
		return userString;
	}
			

} //end program		
	
	
	
	
	
	


