package com.techelevator;

public class Television {

	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	public boolean isOn() {
		return isOn;
	}
	
	public int getCurrentChannel() {
		return currentChannel;
	}
	
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	public void turnOff() {
		if(isOn) {
			isOn = !isOn;
		}
	}
	
	public void turnOn() {
		if(!isOn) {
			isOn = !isOn;
		}
	}
	
	public void changeChannel(int newChannel) {
		if(newChannel <=18 && newChannel >= 3 && isOn) { //only functions if TV is on and channel exists
			currentChannel = newChannel;
		}
	}
	
	public void channelUp() {
		if(isOn) { //only functions if TV is on
			if(getCurrentChannel() < 18) {
				currentChannel++; //if channel less than 18, go up one
			} else {
				currentChannel = 3; //else if current channel already 18, cycle around to 3
			}
		}	
	}
	
	public void channelDown() {
		if(isOn) { //only functions if TV is on
			if(getCurrentChannel() > 3) {
				currentChannel--; //if channel greater than 3, go down one
			} else{
				currentChannel = 18; //else if current channel already 3, cycle around to 18 
			}
		}	
	}
	
	public void raiseVolume() {
		if(isOn && getCurrentVolume() < 10) { //only functions if TV is on and volume not at maximum
			currentVolume++;
		}	
	}

	public void lowerVolume() {
		if(isOn && getCurrentVolume() > 0) { //only functions if TV is on and volume not at minimum
			currentVolume--;
		}	
	}
	
	
	
	
	
}
