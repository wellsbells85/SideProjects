package com.techelevator;

public class FruitTree {
	
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public FruitTree(String myTypeOfFruit, int myStartingPiecesOfFruit) {
		typeOfFruit = myTypeOfFruit;
		piecesOfFruitLeft = myStartingPiecesOfFruit;
	}
	
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}
	
	public boolean pickFruit( int numberOfPiecesToRemove ) {
		
		if( numberOfPiecesToRemove <= piecesOfFruitLeft ) {
			piecesOfFruitLeft -= numberOfPiecesToRemove;
			return true;
		} else {
			return false;
		}
		
	}

}
