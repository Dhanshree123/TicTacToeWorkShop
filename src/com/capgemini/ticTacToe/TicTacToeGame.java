package com.capgemini.ticTacToe;

public class TicTacToeGame {

	public static char board[] = new char[10];

	private static void fillBoard() {
		board[0] = ' ';
		for (int i = 1; i < 10; i++)
			board[i] = ' ';
	}

	// UC 1 - Create Board
	public static char[] createBoard() {
		fillBoard();
		return board;
	}

}
