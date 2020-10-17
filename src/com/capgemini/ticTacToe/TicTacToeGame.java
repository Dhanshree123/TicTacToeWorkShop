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

	// UC 7 - Wining Conditions
	public static boolean viewWiningConditions(char c) {
		return ((board[1] == c && board[2] == c && board[3] == c) || (board[4] == c && board[5] == c && board[6] == c)
				|| (board[7] == c && board[8] == c && board[9] == c)
				|| (board[1] == c && board[5] == c && board[9] == c)
				|| (board[3] == c && board[5] == c && board[7] == c)
				|| (board[1] == c && board[4] == c && board[7] == c)
				|| (board[2] == c && board[5] == c && board[8] == c)
				|| (board[3] == c && board[6] == c && board[9] == c));
	}

	// UC 8 - Make Computer Play Game

	public static boolean isBoardHavingFreeSpace() {
		boolean flag = false;
		for (int i = 1; i < 10; i++)
			if (board[i] == ' ')
				flag = true;
		return flag;
	}

	public static void computerMakeMove(char c) {
		char userInp;
		if (c == 'X')
			userInp = 'O';
		else
			userInp = 'X';
		int index = getPositionToBlock(userInp);
		if (isIndexEmpty(index)) {
			board[index] = c;
			showBoard();
		} else {
			System.out.println("The index is already filled");
			System.out.println("Enter different index");
			index = getPositionToBlock(userInp);
			computerMakeMove(c);
		}
	}

	// UC 9 - Block Opponent

	public static int getPositionToBlock(char c) {

		if ((board[2] == c && board[3] == c) || (board[4] == c && board[7] == c) || (board[5] == c && board[9] == c)) {
			if (isIndexEmpty(1))
				return 1;
		}

		if ((board[1] == c && board[3] == c) || (board[5] == c && board[8] == c)) {
			if (isIndexEmpty(2))
				return 2;
		}

		if ((board[1] == c && board[2] == c) || (board[6] == c && board[9] == c) || (board[5] == c && board[7] == c)) {
			if (isIndexEmpty(3))
				return 3;
		}

		if ((board[1] == c && board[7] == c) || (board[5] == c && board[6] == c)) {
			if (isIndexEmpty(4))
				return 4;
		}

		if ((board[2] == c && board[8] == c) || (board[4] == c && board[6] == c) || (board[1] == c && board[9] == c)
				|| (board[3] == c && board[7] == c)) {
			if (isIndexEmpty(5))
				return 5;
		}

		if ((board[3] == c && board[9] == c) || (board[4] == c && board[5] == c)) {
			if (isIndexEmpty(6))
				return 6;
		}

		if ((board[1] == c && board[4] == c) || (board[8] == c && board[9] == c) || (board[5] == c && board[3] == c)) {
			if (isIndexEmpty(7))
				return 7;
		}

		if ((board[2] == c && board[5] == c) || (board[7] == c && board[9] == c)) {
			if (isIndexEmpty(8))
				return 8;
		}

		if ((board[7] == c && board[8] == c) || (board[3] == c && board[6] == c) || (board[5] == c && board[1] == c)) {
			if (isIndexEmpty(9))
				return 9;
		}

		return (int) (Math.floor(Math.random() * 10) % 9) + 1;
	}

}
