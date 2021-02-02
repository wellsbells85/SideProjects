package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.println("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine();
		
		
		File f = new File(path);
		
		if(f.exists() ) {
			System.out.println("File exists!");
			System.out.println("Name: " + f.getName() );
			System.out.println("Absolute Path: " + f.getAbsolutePath() );
			System.out.println("Size: " + f.length() );
			
			if(f.isDirectory() ) {
				System.out.println("That's a folder!");
			}
			
			if(f.isFile() ) {
				System.out.println("That's a file!");
			}
			
		} else {
			System.out.println("That's not a file.");
		}
		
		System.out.println("Let's make a directory!");
		System.out.print("Enter the path of the new directory >>> ");
		String newDirectory = userInput.nextLine();
		
		File newDirectoryFile = new File(newDirectory);
		
		if(newDirectoryFile.exists() ) {
			System.out.println("That directory already exists!");
			System.exit(1);
		} else {
			boolean itWorked  = newDirectoryFile.mkdir();
			
			if(itWorked) {
				System.out.println("New folder created at: " + newDirectoryFile.getAbsolutePath() );
			} else {
				System.out.println("Could not create directory! Sorry!");
			}
		}
		
		System.out.println("Let's put a file in that directory, shall we?");
		System.out.println("What's the name of your new file?");
		
		String newFileString = userInput.nextLine();
		
		File newFile = new File(newDirectoryFile.getAbsolutePath(), newFileString);
		
		boolean itWorked = newFile.createNewFile();
		
		if(itWorked) {
			String newFilePath = newFile.getAbsolutePath();
			String newFileName = newFile.getName();
			long newFileSize = newFile.length();
			
			System.out.println("Created " + newFileName + " at: " + newFilePath);
			System.out.println("File size : " + newFileSize);
		}
		
		
		
		System.out.println("Let's put some crap into your new file!");
		System.out.println("Enter a message >>> ");
		String message = userInput.nextLine();
		
		PrintWriter pw = new PrintWriter(newFile);
		
		pw.println("Here is the message!");
		pw.println("====================");
		pw.println(message);
		pw.flush();
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
