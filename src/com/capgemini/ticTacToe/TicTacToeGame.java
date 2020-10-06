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

	// UC 3 - Show Board
	public static void showBoard() {
		for (int i = 1; i < 10; i++) {
			System.out.print(board[i++] + " | " + board[i++] + " | " + board[i]);
			System.out.println();
		}
	}

	// UC 4 - Check index to Make move
	public static boolean isIndexEmpty(int index) {
		if (index <= 9 && index > 0 && board[index] == ' ') {
			return true;
		} else
			return false;
	}

	// UC 5 - Make move
	public static void makeMove(int index, char move) {
		if (isIndexEmpty(index)) {
			board[index] = move;
			showBoard();
		} else {
			System.out.println("The index is already filled");
			System.out.println("Enter different index");
			makeMove(SC.nextInt(), move);
		}

	}

	// UC6 - Do Toss
	public static String doToss(String toss) {
		int t;
		if (toss.equalsIgnoreCase("head"))
			t = 0;
		else
			t = 1;
		int tossResult = (int) Math.floor(Math.random() * 10) % 2;
		return (tossResult == t) ? "USER" : "COMPUTER";
	}

}
