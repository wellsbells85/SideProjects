package com.techelevator;

public class Elevator {

	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator(int numberOfLevels) {
		numberOfFloors = numberOfLevels;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void openDoor() {
		 if(isDoorOpen() == false) {
			 doorOpen = !doorOpen;
		 }
	}
	    
	public void closeDoor() {
		if(isDoorOpen() == true) {
			 doorOpen = !doorOpen;
		 }
	}
	 
	public void goUp(int desiredFloor) {
		if(isDoorOpen() == false && desiredFloor <= getNumberOfFloors() && desiredFloor > getCurrentFloor() ) {
			currentFloor = desiredFloor;
		}
	}
	    
	public void goDown(int desiredFloor) {
		if(isDoorOpen() == false && desiredFloor >= 1 && desiredFloor < getCurrentFloor() ) {
			currentFloor = desiredFloor;
		}
	}
	
	
	
	
	
}
