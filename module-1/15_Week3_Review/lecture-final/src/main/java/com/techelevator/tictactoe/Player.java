package com.techelevator.tictactoe;

public class Player {

	private String mark;
	private int playerNumber;
	
	public Player(int playerNumber, String mark) {
		this.playerNumber = playerNumber;
		this.mark = mark;
	}	
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	
	public String getMark() {
		return this.mark;
	}
	
	public String toString() {
		return "Player #" + this.playerNumber + " (" + this.mark + ")";
	}
}
