package com.techelevator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		
		int userScore = 0;
		Scanner scanner = new Scanner(System.in);
		QuizQuestions quiz = new QuizQuestions();
		File quizFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(quizFile) ){
			while(fileScanner.hasNextLine() ) {
				String line = fileScanner.nextLine();
				System.out.println("\n" + quiz.getNextQuestion(line) );
				System.out.println();
				String[] quizAnswers = quiz.getAnswers(line);
				for(int i = 1; i < 5; i++) {
					System.out.println(i + ")" + quizAnswers[i] );
				}
				System.out.println();
				System.out.print("Please enter your answer: ");
				String userAnswerString = scanner.nextLine();
				int userAnswerInteger = Integer.parseInt(userAnswerString);
				if(quizAnswers[userAnswerInteger].equals(quizAnswers[0]) ) {
					userScore++;
					System.out.println("That's the correct answer!");
				} else {
					System.out.println("Sorry that was incorrect.");
				}	
			} // end a single round
		System.out.println("\nYou got " + userScore + " total questions correct.");			
		}	
	}
	
	private static File getInputFileFromUser() {
		Scanner fileScanner = new Scanner(System.in);
		System.out.print("What is the name of the quiz file?");
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
}
