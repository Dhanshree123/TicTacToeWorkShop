package com.capgemini.ticTacToe;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to game");

		while (true) {

			TicTacToeGame.createBoard();

			System.out.println("User enter the input(X/O)");
			char inputs[] = TicTacToeGame.userInput();
			System.out.println("User input " + inputs[0]);
			System.out.println("Computer input " + inputs[1]);

			System.out.println("User enter your choice(head/tail)");
			String toss = sc.next();
			int toss_result;
			String result = TicTacToeGame.doToss(toss);
			if (result.equals("USER"))
				toss_result = 1;
			else
				toss_result = 2;
			System.out.println(result + " won the toss");

			System.out.println("Show board");
			TicTacToeGame.showBoard();

			boolean flag = false;
			switch (toss_result) {
			case 1:
				while (true) {
					System.out.println("User Make Your move");
					System.out.println("Enter index you want from 1 to 9");
					int index_move = sc.nextInt();

					TicTacToeGame.makeMove(index_move, inputs[0]);
					boolean resultUser = TicTacToeGame.viewWiningConditions(inputs[0]);
					if (resultUser == true) {
						System.out.println("User won");
						flag = true;
						break;
					}

					if (!(TicTacToeGame.isBoardHavingFreeSpace()))
						break;
					System.out.println("Computer Make Your move");
					TicTacToeGame.computerMakeMove(inputs[1]);
					boolean resultComputer = TicTacToeGame.viewWiningConditions(inputs[1]);
					if (resultComputer == true) {
						System.out.println("Computer won");
						flag = true;
						break;
					}
					if (!(TicTacToeGame.isBoardHavingFreeSpace()))
						break;
				}
				break;
			case 2:
				while (true) {
					System.out.println("Computer Make Your move");
					TicTacToeGame.computerMakeMove(inputs[1]);
					boolean resultComputer = TicTacToeGame.viewWiningConditions(inputs[1]);
					if (resultComputer == true) {
						System.out.println("Game over!!! Computer won");
						flag = true;
						break;
					}

					if (!(TicTacToeGame.isBoardHavingFreeSpace()))
						break;
					System.out.println("User Make Your move");
					System.out.println("Enter index you want from 1 to 9");
					int index_move = sc.nextInt();
					TicTacToeGame.makeMove(index_move, inputs[0]);
					boolean resultUser = TicTacToeGame.viewWiningConditions(inputs[0]);
					if (resultUser == true) {
						System.out.println("Game over!!! User won");
						flag = true;
						break;
					}
					if (!(TicTacToeGame.isBoardHavingFreeSpace()))
						break;
				}
				break;

			}
			if (flag == false)
				System.out.println("Game over!!! Game is Draw");

			System.out.println("Do you want to play another tic tac toe game?(yes/no)");
			String ans = sc.next();
			if (ans.equalsIgnoreCase("no"))
				break;
		}

		System.out.println("Closing tictactoe");
		sc.close();
	}
}