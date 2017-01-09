package de.max.chapter06.tickV1;

import java.util.Scanner;

public class TickTackToe {
	public static void main(String[] args)
	{
		char[][] board = new char[3][3];
		
		Player p1 = new Player("Player1", board);
		Player p2 = new Player("Player2", board);
		
		System.out.println("Lets Play a game of TickTackToe: ");
		playGame(p1, p2);
		
		if (p1.getWinner())	
		System.out.format("%s won!", p1.getName());
		else 
		System.out.format("%s won!", p2.getName());	
	}

	public static boolean playGame(Player p1, Player p2)
	{
		char[][] emptyBoard = new char[3][3];
		
		
		while (!p1.getWinner() ||!p2.getWinner())
		{
			// let player 1 play
			System.out.format("Input %s's board:\n", p1.getName());
			p1.setBoard(boardInput(emptyBoard));
			
			if (win(p1.getBoard()))
			{
				p1.setWinner(true);
				return true;
			}
			
			// let player 2 play
			System.out.format("Input %s's board:\n", p2.getName());
			p2.setBoard(boardInput(emptyBoard));
			
			if (win(p2.getBoard()))
			{
				p2.setWinner(true);
				return true;
			}
		}
		return false;
	}
	
	public static char[][] boardInput(char[][] board)
	{
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		// this will always return a string of length 9 
		// if the input is shorter it will fill it with "."
		input = input + scan.next();
		if (input.length() >= 9)
		{
			scan.close();
			input = input.substring(0, 9);
		} else
		{
			scan.close();
			while(input.length() != 9)
			{
				input = input + ".";
			}
		}
		//System.out.println("You have input the following: " + input);
		
		// copy string to char array
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				board[i][j] = input.charAt(0);
				// poor man's recursion
				input = input.substring(1);
			}
		}
		return board;
	}

	public static boolean win(char[][] board)
	{
		char[][][] win =		{
								{ {'x', 'x', 'x'}, {'.', '.', '.'}, {'.', '.', '.'} },
								{ {'.', '.', '.'}, {'x', 'x', 'x'}, {'.', '.', '.'} },
								{ {'.', '.', '.'}, {'.', '.', '.'}, {'x', 'x', 'x'} },
								{ {'x', '.', '.'}, {'x', '.', '.'}, {'x', '.', '.'} },
								{ {'.', 'x', '.'}, {'.', 'x', '.'}, {'.', 'x', '.'} },
								{ {'.', '.', 'x'}, {'.', '.', 'x'}, {'.', '.', 'x'} },
								{ {'x', '.', '.'}, {'.', 'x', '.'}, {'.', '.', 'x'} },
								{ {'.', '.', 'x'}, {'.', 'x', '.'}, {'.', '.', 'x'} }
								};
		boolean check = true;

		for (int i = 0; i < win.length; i++)
		{	// for each case
			for(int j = 0; j < board.length; j++)
			{
				for(int k = 0; k < board.length; k++)
				{
					if (win[i][j][k] == board[j][k])
					{
						check &= true;
					} else 
					{
						check &= false;
					}
				}
			}
			if (check)
			{
				return check;
			}
		}
		return false;
	}
}
