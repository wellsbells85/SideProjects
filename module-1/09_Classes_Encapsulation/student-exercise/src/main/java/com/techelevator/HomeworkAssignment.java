package com.techelevator;

public class HomeworkAssignment {
	
	private String submitterName;
	private String letterGrade;
	private int possibleMarks;
	private int earnedMarks;
	
	
	public HomeworkAssignment(int myPossibleMarks, String mySubmitterName) {
		possibleMarks = myPossibleMarks;
		submitterName = mySubmitterName;
	}
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	
	public int getPossibleMarks() {
		return possibleMarks;
	}
	
	public String getSubmitterName() {
		return submitterName;
	}
	
	public String getLetterGrade() {
		if( (double)earnedMarks / (double)possibleMarks * 100 >= 90 ) {
			letterGrade = "A";
		} else if( (double)earnedMarks / (double)possibleMarks * 100 >= 80 ) {
			letterGrade = "B";
		} else if( (double)earnedMarks / (double)possibleMarks * 100 >= 70 ) {
			letterGrade = "C";
		} else if( (double)earnedMarks / (double)possibleMarks * 100 >= 60 ) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
		
		return letterGrade;
	}
	
	public void setEarnedMarks(int newEarnedMarks) {
		earnedMarks = newEarnedMarks;
	}
	

	
}
