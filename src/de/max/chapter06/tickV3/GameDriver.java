package de.max.chapter06.tickV3;

import java.util.Scanner;

public class GameDriver {
	// instatiate the players on game Level with Name / sign
	protected static Player ai = new Player("AI", 'X');
	protected static Player op = new Player("Opponent", 'O');
	private static int movesLeft = 9;

	public static void main(String[] args)
	{
		char[][] initialBoard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		Minimax board = new Minimax(initialBoard);
		Scanner scan = new Scanner(System.in);

		System.out.println("This AI is going to take over the world " + "now watch it beat you at TickTacToe:");
		System.out.format("Who is going to start ? 0 = %s " + " other = Me (%s)\n", op.getName(), ai.getName());

		int input = scan.nextInt();
		boolean aiWin = setup(board, scan, (input == 0) ? false : true);
		scan.close();

		if (ai.hasWon())
		{
			System.out.println("AI won");
		} else if (op.hasWon())
		{
			System.out.println("You won");
		} else 
		{
			System.out.println("Draw");
		}

	}

	private static boolean setup(Minimax board, Scanner scan, boolean aiTurn)
	{

		// UI
		// give me some space
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		// header
		System.out.format("%s ('%s')   vs.   %s ['%s']\n", op.getName(), op.getSign(), ai.getName(), ai.getSign());
		System.out.println("Board:" + "               " + "Valid Moves:");
		System.out.println();
		printBoards(board.cells, updateMoves(board.cells));
		// check win
		board.checkWin();

		// recursion base case
		// base case is after ui update to give user context why the result is
		// the way it is
		if (ai.hasWon() || op.hasWon())
		{
			return (ai.hasWon()) ? true : false;
		} else if (movesLeft == 0)
		{
			return false;
		}
		int[] move;
		// if human
		if (aiTurn)
		{
			move = board.getMove();
			board.cells[move[0]][move[1]] = ai.getSign();
		} else
		{
			System.out.println("Input your move 1 - 9: ");
			move = getUserInput(scan, board);
			// set the input cell -1 to be the opp's sign
			board.cells[move[0]][move[1]] = op.getSign();

		}
		movesLeft--;

		return setup(board, scan, !aiTurn);
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

	private static char[][] updateMoves(char[][] board)
	{
		// loop through the chars and generate a new char array with the
		// possible left move
		int len = board.length;
		char[][] leftMoves = new char[len][len];
		int count = 0;

		for (int row = 0; row < len; row++)
		{
			for (int col = 0; col < len; col++)
			{
				count++;
				if (board[row][col] == ' ')
				{
					// add the values up convert to int and then back to char
					String value = "" + count;
					leftMoves[row][col] = value.charAt(0);
				} else
				{
					leftMoves[row][col] = ' ';
				}
			}
		}
		return leftMoves;

	}

	private static int[] getUserInput(Scanner scan, Board board)
	{
		int input = scan.nextInt();
		// if the value has already been picked throw an error and recurse until
		// the input it valid
		int[] move = new int[2];
		// convert from the +1 offset vals to array indicies
		move[0] = (input - 1) / 3;
		move[1] = (input - 1) % 3;

		if (board.cells[move[0]][move[1]] != ' ')
		{
			System.err.print("You cannot pick a field twice!\n Try Again: ");
			move = getUserInput(scan, board);
		}
		// clamp to 1 --> 9 bounds
		// if (input < 1)
		// {
		// input = 1;
		// } else if (input > 9)
		// {
		// input = 9;
		// }
		return move;
	}
}
