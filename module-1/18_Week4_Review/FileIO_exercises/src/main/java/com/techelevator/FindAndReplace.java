package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FindAndReplace {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		String path = "alice.txt";
		File inputFile = new File(path);
		
		System.out.println("Enter Destination File: >>> ");
		String outputPath = keyboard.nextLine();
		File outputFile = new File(outputPath);
		
		System.out.println("Enter Search Word: >>> ");
		String searchWord = keyboard.nextLine();
		
		System.out.println("Enter Replace Word: >>> ");
		String replaceWord = keyboard.nextLine();
		
		try (Scanner aliceReader = new Scanner(inputFile) ; PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true)) ) {
			
			while(aliceReader.hasNextLine() ) {
				String lineByLine = aliceReader.nextLine();
				
				
				pw.println(lineByLine);
			}
			pw.close();
		} catch(FileNotFoundException e) {
			System.out.println("Your hardcoded file path is bad, and you shold feel bad.");
			System.out.println("PrintWriter threw an exception");
		} catch (IOException e) {
			System.out.println("Oh....IO Exception.");
			System.out.println("FileWriter threw an exception");
		} 		
	} // end main
} // end class
