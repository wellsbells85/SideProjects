package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestions {
	
	public String nextReadLine;
	public List<String> questionAnswerList = new ArrayList<>();
	
	public QuizQuestions() {
		
	}
	
	public String getNextQuestion(String nextReadLine) {
		String[] arrayQuestion = nextReadLine.split("\\|");
		String nextQuestion = arrayQuestion[0];
		return nextQuestion;
	} 
	
	public String[] getAnswers(String nextReadLine) {
		String[] answersArray = nextReadLine.split("\\|");
		for(int i = 0; i < 5; i++) {
			if(answersArray[i].matches(".*[\\*]") ) {
				answersArray[i] = answersArray[i].replaceAll("\\*", "");
				answersArray[0] = answersArray[i];
				continue;
			}
		} return answersArray;
		
	}
	
	
	
	
	
	
	
} //end class	
	
	
	
	
	


