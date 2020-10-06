package com.capgemini.ticTacToe;

public class TicTacToeMain {

	public static void main(String[] args) {
		System.out.println("Welcome to game");

		TicTacToeGame.createBoard();

		System.out.println("User enter the input(X/O)");
		char inputs[] = TicTacToeGame.userInput();
		System.out.println("User input " + inputs[0]);
		System.out.println("Computer input " + inputs[1]);
	}
}