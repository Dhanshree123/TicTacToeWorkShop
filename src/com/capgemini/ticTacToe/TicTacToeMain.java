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

		System.out.println("User check index to Make Your move");
		System.out.println("Enter index you want from 1 to 9");
		int index = sc.nextInt();
		boolean check = TicTacToeGame.isIndexEmpty(index);
		if (check == true)
			System.out.println("Index is free");
		else
			System.out.println("Index already filled");

		sc.close();
	}
}