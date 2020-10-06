package com.capgemini.ticTacToe;

import java.util.Scanner;

public class TicTacToeGame {

	public static char board[] = new char[10];
	public static final Scanner SC = new Scanner(System.in);

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

	// UC 2 - Check user and computer inputs
	public static char[] userInput() {
		char[] ch = new char[2];
		ch[0] = SC.next().charAt(0);
		ch[1] = ' ';
		ch[1] = ch[0] == 'X' ? 'O' : 'X';
		return ch;

	}

}
