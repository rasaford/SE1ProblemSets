package de.max.chapter06.tickV2;

import java.util.Scanner;

public class Game {
	private static char[][] moves = initBoard('1', false);
	private static char[][] board = initBoard(' ', true);
	private static int movesLeft = 9;

	public static boolean play(Player huPlayer, Player aiPlayer, boolean ai, Scanner scan)
	{
		// base case
		if (movesLeft <= 0)
		{
			return true;
		}
		{
			// UI
			// give me some space
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			// header
			System.out.format("%s ('%s')   vs.   %s ['%s']\n", huPlayer.getName(), huPlayer.getSign(),
					aiPlayer.getName(), aiPlayer.getSign());
			System.out.println();
			printBoards(board, moves);
			if (!ai)
			{
				System.out.println("Input your move 1 - 9: ");
			}
		}
		// get input
		int input = 1;
		if (ai)
		{
			int[] index = ai(board);
			board[index[0]][index[1]] = 'x';

		} else
		{ // get user input
			while (true)
			{
				input = scan.nextInt();
				// check if this move has already been done
				if (moves[(input - 1) / 3][(input - 1) % 3] == ' ')
				{
					System.err.print("This field has already been picked! \n" + "Try Again: ");
				} else
				{
					break;
				}
			}

		}

		board = updateBoard(board, input, ai ? 'x' : '0');
		moves = updateBoard(moves, input);
		movesLeft--;

		printBoards(board, moves);

		// recursion to keep playing until someone won
		return play(huPlayer, aiPlayer, !ai, scan);
	}

	// go though all possibilities for the given board and call minimax on them
	// then find the max val of minimax and execute on this move
	private static int[] ai(char[][] board)
	{
		int[][] costTable = new int[3][3];
		int[] out = new int[2];

		// loop through all the possibilites for the boards
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				if (board[i][j] == ' ')
				{ // is there an empty spot on the board recurse on it
					board[i][j] = 'x';
					costTable[i][j] = minimax(board, true, 0);
					board[i][j] = ' ';
				}
			}
		}
		// find the max val & it's indicies in the array
		int indexI = 0, indexJ = 0, prevValue = 0;

		for (int i = 0; i < costTable.length; i++)
		{
			for (int j = 0; j < costTable.length; j++)
			{
				if (costTable[i][j] > prevValue)
				{
					indexI = i;
					indexJ = j;
					prevValue = costTable[i][j];
				}
			}
		}
		// put the values of i & j into the out array to be able to return them
		// both
		out[0] = indexI;
		out[1] = indexJ;
		return out;
	}

	private static int minimax(char[][] board, boolean ai, int depth)
	{
		char[][] boardCopy = copyArray(board);
		
		// base case
		if (checkWin(boardCopy, 'x'))
		{
			return 10;
		} 
		else if (checkWin(boardCopy, '0'))
		{
			return -10;
		} 
		else if (movesLeft - depth <= 0)
		{
			return -99;
		}
		depth++;

		// loop through the board
		for (int i = 0; i < boardCopy.length; i++)
		{
			for (int j = 0; j < boardCopy.length; j++)
			{
				if (boardCopy[i][j] == ' ')
				{ // is there an empty spot on the board recurse on it
					boardCopy[i][j] = ai ? 'x' : '0';
					minimax(boardCopy, !ai, depth);
					boardCopy[i][j] = ' ';
				}
			}
		}
		return 0;
	}

	private static boolean checkWin(char[][] board, char sign)
	{
		char[][][] win = { { { 'x', 'x', 'x' }, { '0', '0', '0' }, { '0', '0', '0' } },
				{ { '0', '0', '0' }, { 'x', 'x', 'x' }, { '0', '0', '0' } },
				{ { '0', '0', '0' }, { '0', '0', '0' }, { 'x', 'x', 'x' } },
				{ { 'x', '0', '0' }, { 'x', '0', '0' }, { 'x', '0', '0' } },
				{ { '0', 'x', '0' }, { '0', 'x', '0' }, { '0', 'x', '0' } },
				{ { '0', '0', 'x' }, { '0', '0', 'x' }, { '0', '0', 'x' } },
				{ { 'x', '0', '0' }, { '0', 'x', '0' }, { '0', '0', 'x' } },
				{ { '0', '0', 'x' }, { '0', 'x', '0' }, { '0', '0', 'x' } } };
		boolean check = true;
		int len = board.length;
		char[][] boardCopy = copyArray(board);
		// filter trough the board and get it to conform to the win board
		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if (boardCopy[i][j] != sign)
				{
					boardCopy[i][j] = '0';
				} else
				{
					boardCopy[i][j] = 'x';
				}
			}
		}
		// check against the win board
		for (int i = 0; i < win.length; i++)
		{ // for each case
			for (int j = 0; j < len; j++)
			{
				for (int k = 0; k < len; k++)
				{
					if (win[i][j][k] == boardCopy[j][k])
					{
						check &= true;
					} else
					{
						check &= false;
					}
				}
			}
			if (check)
				return check;
			check = true;
		}
		return false;
	}

	
	// create the board showing the left moves
	private static char[][] initBoard(char start, boolean flood)
	{
		// flood if true just copies the value of start
		// into all fields else it incements
		char[][] board = new char[3][3];

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				if (!flood)
				{
					board[i][j] = start++;
				} else
				{
					board[i][j] = start;
				}

			}
		}
		return board;
	}
	private static void printBoards(char[][] board, char[][] moves)
	{
		String spaces = "          ";
		String seperator = "---+---+---";

		for (int i = 0; i < board.length; i++)
		{
			System.out.format(" %c | %c | %c ", board[i][0], board[i][1], board[i][2]);
			System.out.print(spaces);
			System.out.format(" %c | %c | %c \n", moves[i][0], moves[i][1], moves[i][2]);

			if (i != 2)
			{
				System.out.println(seperator + spaces + seperator);
			}
		}
	}


	// set board at input to char
	private static char[][] updateBoard(char[][] board, int input, char sign)
	{
		board[(input - 1) / 3][(input - 1) % 3] = sign;
		return board;
	}

	// if no char specified set char to be ' '
	private static char[][] updateBoard(char[][] moves, int input)
	{
		moves[(input - 1) / 3][(input - 1) % 3] = ' ';
		return moves;
	}

	private static char[][] copyArray(char[][] in)
	{
		char[][] out = new char[in.length][in.length];
		for (int i = 0; i < in.length; i++)
		{
			for (int j = 0; j < in.length; j++)
			{
				out[i][j] = in[i][j];
			}
		}
		return out;
	}
}
