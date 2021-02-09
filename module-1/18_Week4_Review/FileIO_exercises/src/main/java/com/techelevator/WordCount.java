package com.techelevator;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordCount {

	public static void main(String[] args) {
		
		String path = "alice.txt";
		File inputFile = new File(path);
		
		int wordCount = 0;
		// try-with-resources
		try (Scanner scanner = new Scanner(inputFile)){
			
			while(scanner.hasNextLine() ) {
				String currentLine = scanner.nextLine();
				String[] wordArray = currentLine.split(" ");
				for(String word: wordArray) {
					if(!word.isEmpty() ) {
						wordCount++;
					}
				}	
			}
			
			System.out.println("Word Count: " + wordCount);
		
		} catch(FileNotFoundException e) {
			System.out.println("Your hardcoded file path is bad, and you should feel bad!");
		}
		

	} //end main

} //end class
