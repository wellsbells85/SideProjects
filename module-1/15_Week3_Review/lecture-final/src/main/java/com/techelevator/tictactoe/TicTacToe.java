package com.techelevator.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.techelevator.game.Game;

public class TicTacToe extends Game {
	
	private final int BOARD_SIZE = 3;
	private final String[] MARKS = new String[] { "X", "O" };
	
	// Create a 2D array of Players for the board
	// spots can be null (to denote available spot) or a reference to one of the two Player objects
	private Player[][] board = new Player[BOARD_SIZE][BOARD_SIZE]; // Constraint: Must be square!
	private List<Player> players;
	private Player winner;
	private Random rando = new Random();
	
	public TicTacToe() {
		// Constraint: Only 2 players!
		super(2);
		
		// Add two Player objects to our list of players
		players = new ArrayList<>();
		players.add(new Player(1, MARKS[0]));
		players.add(new Player(2, MARKS[1]));
		
		Collections.shuffle(players); // Randomize which Player goes first (but not which Player # they're assigned)
	}

	@Override
	protected void setup(int numberOfPlayers) {
		System.out.println("Let's Play! Here's the board:");
		this.printBoard();
	}

	@Override
	protected void takeTurn(int player) {
		// Figure out which Player object is is taking this turn
		int playerIndex = player - 1;
		Player currentPlayer = players.get(playerIndex);
		
		
		// randomly pick values for row and for column, until we find an open space
		int row;
		int col;
		
		do {
			row = rando.nextInt(BOARD_SIZE);
			col = rando.nextInt(BOARD_SIZE);
		} while(board[row][col] != null);
		
		board[row][col] = currentPlayer;  // now take said open space
		
		System.out.println(currentPlayer + " took a turn. Current board:");
		this.printBoard();
	}

	@Override
	protected boolean isGameOver() {

		// Two cases: 1. There is a winner, or 2. The board is full
		//   1. Is there a winner?
		
		//     Start with Left Diagonal [\]
		if(board[0][0] != null && (board[0][0] == board[1][1] && board[0][0] == board[2][2])) {
			winner = board[0][0];
			System.out.println("Left Diagonal!");
			return true;
		}
		
		//     Yo, check the diagonal   [/]
		if(board[0][2] != null && (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
			winner = board[0][2];
			System.out.println("Right Diagonal!");
			return true;  // Doesn't that make it three in a row?
		}
		
		//     Now check rows && columns for a winner
		for(int row = 0; row < BOARD_SIZE; row++) {
			if(board[row][0] != null && (board[row][0] == board[row][1] && board[row][0] == board[row][2])) {
				winner = board[row][0];
				System.out.println("Row " + (row + 1) + "!");
				return true;
			}
		}
		for(int col = 0; col < BOARD_SIZE; col++) {
			if(board[0][col] != null && (board[0][col] == board[1][col] && board[0][col] == board[2][col])) {
				winner = board[0][col];
				System.out.println("Column " + (col + 1) + "!");
				return true;
			}			
		}
		

		// If we haven't returned by now, there's no winner yet. So:
		//   2. Is the board full?
		boolean isTheBoardFull = true;  // We'll say it's full (unless we can find an opening)
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if(board[i][j] == null) {    // finding any null means
					isTheBoardFull = false;  // we have an open space
				}
			}
		}
		
		return isTheBoardFull;
	}

	@Override
	protected void finishGame() {
		System.out.println("* ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ ");

		if(winner == null) {
			System.out.println("Tie Game!");
		} else {
			System.out.println(winner + " is the WINNER!");  // good use of Player's toString() method
		}

		System.out.println("* ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ ");
	}
	
	private void printBoard() {
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {

				String character = "_";     // default (for when a space is null)

				if(board[i][j] != null) {   // if it's not null, use the occupying Player's mark
					character = board[i][j].getMark();
				}

				System.out.print(character + " "); // print out row, one character at a time
			}
			System.out.println();  // row is finished, move on to next row (carriage return)
		}
		
		System.out.println();
	}
}
