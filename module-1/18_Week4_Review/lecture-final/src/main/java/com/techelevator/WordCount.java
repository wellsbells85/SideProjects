package com.techelevator;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordCount {

	public static void main(String[] args) {
		
		String path = "alices.txt";
		File inputFile = new File(path);
		
		int wordCount = 0;
		
		// try-with-resources
		try (Scanner darkly = new Scanner(inputFile)) {
			
			while(darkly.hasNextLine()) {
				String currentLine = darkly.nextLine();
				currentLine = currentLine.trim();

				String[] words = currentLine.split(" ");
				for(String word : words) {
					if(!word.isEmpty()) {
						wordCount++;
					}
				}
			}

			System.out.println("Word Count: " + wordCount);

		} catch(FileNotFoundException e) {
			System.out.println("Your hardcoded file path is bad. And you should feel bad.");
		}


	}

}
