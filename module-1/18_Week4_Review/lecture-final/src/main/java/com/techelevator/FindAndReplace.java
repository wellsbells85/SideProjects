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
		
		String inputPath = "alices.txt";
		File inputFile = new File(inputPath);
		System.out.println("Source File is: " + inputFile.getName());
		
		System.out.println("Enter Destination File: >>> ");
		String outputPath = keyboard.nextLine();
		File outputFile = new File(outputPath);
		
		System.out.println("Enter Search Word: >>> ");
		String searchWord = keyboard.nextLine();
		
		System.out.println("Enter Replace Word: >>> ");
		String replaceWord = keyboard.nextLine();
		
		// try-with-resources (multiple resources)
		try (Scanner aliceReader = new Scanner(inputFile); PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true))) {

				while(aliceReader.hasNextLine()) {
					String lineByLine = aliceReader.nextLine();
	
//					String[] words = lineByLine.split(" ");
//					for(String word : words) {
//						String palabra = en2es.getOrDefault(word, ""); // Java 1.8+
//						pw.println(palabra);
//					}
					
					lineByLine = lineByLine.replace(searchWord, replaceWord);
	
					pw.println(lineByLine);
				}
				
		} catch(FileNotFoundException e) {
			System.out.println("Your hardcoded file path is bad. And you should feel bad.");
			System.out.println("PrintWriter threw and exception");
		} catch(IOException e) {
			System.out.println("OH... IO exception!");
			System.out.println("FileWriter threw and exception");
		}
		
		System.out.println("Done!");
	}

}
