package de.max.chapter06.tickV3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimax extends Board {

	// call Board's constructor and give it the input board
	public Minimax(char[][] board)
	{
		super(board);
	}

	public int[] getMove()
	{
		// minimax returns an array of Score, cols, rows
		int[] result = minimax(5, aiSeed);
		// return only the last 2 scores of the array as we dont't
		// need the score here
		return new int[] { result[1], result[2] };
	}

	private int[] minimax(int maxDepth, Player currentPlayer)
	{
		// create a new LinkedList with all the possible moves
		List<int[]> nextMoves = generateMoves();
		// init vars
		// best score starts out as the lowest / highest value possible as the
		// score
		int bestScore = (currentPlayer.isAi()) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int currentScore = 0;
		int bestRow = -1;
		int bestCol = -1;

		if (nextMoves.isEmpty() || maxDepth == 0)
		{ // both conditions force a game over
			bestScore = evaluateBoard();
		} else
		{
			for (int[] move : nextMoves)
			{
				// set the sign of the determined field to the current players
				cells[move[0]][move[1]] = currentPlayer.getSign();
				if (currentPlayer.isAi() == true)
				{
					// if AI recurse with opp as the next player
					// [0} because minimax returns a len 3 array and we only
					// need the score here
					currentScore = minimax(maxDepth - 1, opSeed)[0];
					if (currentScore > bestScore)
					{
						// if current score > than the old one update
						bestScore = currentScore;
						bestRow = move[0];
						bestCol = move[1];
					}
				} else
				{
					// [0} because minimax returns a len 3 array and we only
					// need the score here
					currentScore = minimax(maxDepth - 1, aiSeed)[0];
					if (currentScore < bestScore)
					{
						// if current score < than the old one update
						bestScore = currentScore;
						bestRow = move[0];
						bestCol = move[1];
					}

				}
				// the cells have to be reset, otherwise moves would accumulate
				cells[move[0]][move[1]] = ' ';
			}
		}
		return new int[] { bestScore, bestRow, bestCol };

	}

	// Heuristic evaluation for the entire board
	// returns a score based on:
	// +100, +10 +1 for each 3, 2, 1, a line for AI
	// -100, -10 -1 for each 3, 2, 1, a line for Opp
	private int evaluateBoard()
	{
		// go all situations that get you closer to winning and add up the
		// scores
		int score = 0;
		score += evaluateLine(0, 0, 0, 1, 0, 2); // row 0
		score += evaluateLine(1, 0, 1, 1, 1, 2); // row 1
		score += evaluateLine(2, 0, 2, 1, 2, 2); // row 2
		score += evaluateLine(0, 0, 1, 0, 2, 0); // col 0
		score += evaluateLine(0, 1, 1, 1, 2, 1); // col 1
		score += evaluateLine(0, 2, 1, 2, 2, 2); // col 2
		score += evaluateLine(0, 0, 1, 1, 2, 2); // diagonal
		score += evaluateLine(0, 2, 1, 1, 2, 0); // alternate diagonal
		return score;
	}

	// evaluation for a line of 3 cells (1 row)
	private int evaluateLine(int row0, int col0, int row1, int col1, int row2, int col2)
	{
		int score = 0;
		// 1st cell
		// is the cell at row1 col1 maked by any of the Players
		if (cells[row0][col0] == aiSeed.getSign())
		{
			score = 1;
		} else if (cells[row0][col0] == opSeed.getSign())
		{
			score = -1;
		}

		// 2nd cell
		if (cells[row1][col1] == aiSeed.getSign())
		{
			if (score == 1)
			{ // cell1 is mySeed
				score = 10;
			} else if (score == -1)
			{ // cell1 is oppSeed
				return 0;
			} else
			{ // cell1 is empty
				score = 1;
			}
		} else if (cells[row1][col1] == opSeed.getSign())

		{
			if (score == -1)
			{ // two in a row
				score = -10;
			} else if (score == 1)
			{ // two in a row
				return 0;
			} else
			{ // 1st was empty
				score = -1;
			}
		}

		// 3rd cell
		if (cells[row2][col2] == aiSeed.getSign())
		{
			if (score > 0)
			{ // 1st and / or 2nd are AI
				score *= 10;
			} else if (score < 0)
			{ // 1st and / or 2nd is opp
				return 0;
			} else
			{ // 1st and 2nd were empty
				score = 1;
			}
		} else if (cells[row2][col2] == opSeed.getSign())
		{
			if (score < 0)
			{ // 1st and / or 2nd are opp
				score *= 10;
			} else if (score > 1)
			{ // 1st and / or 2nd is AI
				return 0;
			} else
			{ // 1st and 2nd were empty
				score = -1;
			}
		}
		return score;

	}

	public void checkWin()
	{
		int[] scores = new int[8];
		scores[0] = evaluateLine(0, 0, 0, 1, 0, 2); // row 0
		scores[1] = evaluateLine(1, 0, 1, 1, 1, 2); // row 1
		scores[2] = evaluateLine(2, 0, 2, 1, 2, 2); // row 2
		scores[3] = evaluateLine(0, 0, 1, 0, 2, 0); // col 0
		scores[4] = evaluateLine(0, 1, 1, 1, 2, 1); // col 1
		scores[5] = evaluateLine(0, 2, 1, 2, 2, 2); // col 2
		scores[6] = evaluateLine(0, 0, 1, 1, 2, 2); // diagonal
		scores[7] = evaluateLine(0, 2, 1, 1, 2, 0); // alternate diagonal
		
		Arrays.sort(scores);
		int max = scores[7];
		int min = scores[0];
		
		if (max == 100)
		{
			aiSeed.setWon(true);
		} else if (min == -100)
		{
			opSeed.setWon(true);
		}		
	}
	private List<int[]> generateMoves()
	{
		// allocate List
		List<int[]> moves = new ArrayList<int[]>();

		// return the empty list if ai or op has won the game
		if (aiSeed.hasWon() || opSeed.hasWon())
		{
			return moves;
		}

		for (int row = 0; row < boardRows; row++)
		{
			for (int col = 0; col < boardCols; col++)
			{
				// go though the cells and see if any are empty
				// if so add the spot to the list
				if (cells[row][col] == ' ')
				{
					moves.add(new int[] { row, col });
				}
			}
		}
		return moves;
	}
	

}
