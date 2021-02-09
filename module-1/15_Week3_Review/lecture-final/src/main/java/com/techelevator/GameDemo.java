package com.techelevator;

import com.techelevator.game.Game;
import com.techelevator.monopoly.Monopoly;
import com.techelevator.tictactoe.TicTacToe;

public class GameDemo {

	public static void main(String[] args) {
		//Game theGame = new Monopoly(4);
		
		Game theGame = new TicTacToe();
		theGame.playGame();
	}

}
