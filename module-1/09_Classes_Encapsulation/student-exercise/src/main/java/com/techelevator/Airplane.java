package com.techelevator;

public class Airplane {

	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;
	
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		
		if(forFirstClass) {
			if( totalNumberOfSeats > getAvailableFirstClassSeats() ) {
				return false;
			} else {
				bookedFirstClassSeats +=totalNumberOfSeats;
				return true;
			}	
		} else {
			if( totalNumberOfSeats > getAvailableCoachSeats() ) {
				return false;
			} else {
				bookedCoachSeats += totalNumberOfSeats;
				return true;
			}
		}         
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
		int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		return availableFirstClassSeats;
	}
	
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	
	public int getAvailableCoachSeats() {
		int availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		return availableCoachSeats;
	}
}
