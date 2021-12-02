// Tic-Tac-Toe Game.
import java.util.*;

public class TicTacToe {
	
	static String[] board;
	static String turn;
	static String player;
	
	// This method will check for the winning condition
	static String checkWinner(String p1 , String p2)
	{
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			//For X winner
			if (line.equals("XXX")) {
				return p1;
			}
			
			// For O winner
			else if (line.equals("OOO")) {
				return p2;
			}
		}
		

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}

		// To enter the X or O on the board.
		System.out.print(player + "'s turn; enter a slot number to place " + turn + " in: ");
		return null;
	}
	
	// To print the board.
	/*

	 1 | 2 | 3 
	---|---|---
	 4 | 5 | 6 
	---|---|---
	 7 | 8 | 9 

	 */
	static void printBoard()
	{
		System.out.println();
		System.out.println(" " + board[0] + " | "
						+ board[1] + " | " + board[2]
						+ " ");
		System.out.println("---|---|---");
		System.out.println(" " + board[3] + " | "
						+ board[4] + " | " + board[5]
						+ " ");
		System.out.println("---|---|---");
		System.out.println(" " + board[6] + " | "
						+ board[7] + " | " + board[8]
						+ " ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("\n\nWelcome to 3x3 Tic Tac Toe.\n");

		// Taking usernames from players
		System.out.print("Enter player 1 username: ");
		String player1= in.nextLine();
		System.out.print("\nEnter player 2 username: ");
		String player2= in.nextLine();
		player = player1;
		boolean flag = true;
		
		// Play again loop
		while(flag == true) {
			board = new String[9];
			turn = "X";
			String winner = null;

			// Storing index for the game in a 1D array
			for (int a = 0; a < 9; a++) {
				board[a] = String.valueOf(a + 1);
			}
			printBoard();

			// Game start
			System.out.print(player1 + " will play first. Enter a slot number to place X in: ");

			while (winner == null) {
				// String numInput1;
				int numInput;
			
				// Handling exceptions in taking input
				try {
					numInput = in.nextInt();
					// numInput = Integer.parseInt(numInput1);
					if (!(numInput > 0 && numInput <= 9) || !((int)numInput == numInput)) {
						System.out.print(
							"\nInvalid input\nRe-enter slot number: ");
						continue;
					}
				}
				catch (InputMismatchException e) {
					System.out.print(
						"\nInvalid input\nRe-enter slot number: ");
					continue;
				}
				
				if (board[numInput - 1].equals(String.valueOf(numInput))) {
					board[numInput - 1] = turn;

					// Switching turns 
					if (turn.equals("X")) {
						turn = "O";
						player = player2;
					} else {
						turn = "X";
						player = player1;
					}

					printBoard();
					winner = checkWinner(player1, player2);
				}
				else {
					System.out.print(
						"\nSlot already taken;\nRe-enter slot number: ");
				}
			}
			
			// If no one won
			if (winner.equalsIgnoreCase("draw")) {
				System.out.println(
					"It's a draw!\n");
			}
			
			// To display Congratulations! message.
			else {
				System.out.println("Congratulations! " + winner + " has won!\n");
			}

			System.out.print("\nDo you want to play again?\nEnter Y/N: ");
			char pa = in.next().charAt(0);
			if (pa == 'Y' || pa == 'y'){
				continue;
			} else {
				System.out.println("\nThanks for playing!\n\n\nMINI PROJECT MADE BY:\n\nMilind Gupta\nSaatvik Inampudi\nSahil Raj\nShlok Jakhotia\n");
				flag = false;
			}
		}
	}
}