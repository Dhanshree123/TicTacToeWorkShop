package com.capgemini.ticTacToe;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to game");

		TicTacToeGame.createBoard();

		System.out.println("User enter the input(X/O)");
		char inputs[] = TicTacToeGame.userInput();
		System.out.println("User input " + inputs[0]);
		System.out.println("Computer input " + inputs[1]);

		System.out.println("Show board");
		TicTacToeGame.showBoard();

		System.out.println("User enter your choice(head/tail)");
		String toss = sc.next();
		int toss_result;
		String result = TicTacToeGame.doToss(toss);
		if (result.equals("USER"))
			toss_result = 1;
		else
			toss_result = 2;
		System.out.println(result + " won the toss");

		while (true) {
			System.out.println("User Make Your move");
			System.out.println("Enter index you want from 1 to 9");
			int index_move = sc.nextInt();
			TicTacToeGame.makeMove(index_move, inputs[0]);

			System.out.println("Do you want to enter again(Y/N)");
			String ans = sc.next();
			if (ans.equalsIgnoreCase("N"))
				break;
		}

		boolean winner = TicTacToeGame.viewWiningConditions(inputs[0]);
		if (winner == true)
			System.out.println("User won");
		else
			System.out.println("Computer won");

		sc.close();
	}
}