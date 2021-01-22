package com.techelevator;

public class Airplane {

	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;
	
	
	public Airplane(String myPlaneNumber, int myTotalFirstClassSeats, int myTotalCoachSeats) {
		planeNumber = myPlaneNumber;
		totalFirstClassSeats = myTotalFirstClassSeats;
		totalCoachSeats = myTotalCoachSeats;
	}
	
	public String getPlaneNumber() {
		return planeNumber;
	}
	
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	
	public int getAvailableFirstClassSeats() {
		availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		return availableFirstClassSeats;
	}
	
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	
	public int getAvailableCoachSeats() {
		availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		return availableCoachSeats;
	}
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		
		if(forFirstClass) {
			bookedFirstClassSeats += totalNumberOfSeats;
		} else {
			bookedCoachSeats += totalNumberOfSeats;
		}
		
		if( availableFirstClassSeats >= totalNumberOfSeats || availableCoachSeats >= totalNumberOfSeats ) {
			return true;
		} else {
			return false;
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
}
