package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSplitter {

	public static void main(String[] args) {
		
		File userFile = getInputFileFromUser();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many lines of code do you need in each file?");
		int fileLines = Integer.parseInt(scanner.nextLine() );
		
		try(Scanner fileScanner = new Scanner(userFile)) {
			while(fileScanner.hasNextLine()) {
				try (PrintWriter writer = new PrintWriter(new FileWriter(userFile))) {
					File dataFile = new File(".");
					for(int i = 1; dataFile.exists(); i++) {
						String newFileString = "Generating input-" + i + ".txt";
						dataFile = new File(newFileString);
						for(int j = 0; j < fileLines; j++) {
							String lineOut = fileScanner.nextLine();
							writer.println(lineOut);
						}
					}	writer.close();		
				} catch(IOException e) {
					System.out.println("\nThe program was unable to write your file. Sorry.");
					System.exit(1); //end the program with an irregular error
				}
				String line = fileScanner.nextLine();
				
			}		
		} catch(IOException e) {
			System.out.println("\nThe program was unable to write your file. Sorry.");
			System.exit(1); //end the program with an irregular error
		}
	}
	
	private static File getInputFileFromUser() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is the file name that you need to split?");
		String path = scanner.nextLine();
	
		File userFile = new File(path);
		if(!userFile.exists() ) { // checks for the existence of a file
			System.out.println(path +" does not exist!");
			System.exit(1); // Ends the program
		} else if(!userFile.isFile() ) {
			System.out.println(path +" is not a file!");
			System.exit(1); // Ends the program
		} return userFile;
	} 	

}
