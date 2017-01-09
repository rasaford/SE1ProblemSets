package de.max.chapter06.tickV3;

public class Board {

	public char[][] cells;					// values of the 3x3 grid
	public Player aiSeed = GameDriver.ai;	// AI seed
	public Player opSeed = GameDriver.op;	// Opponent Seed
	public int boardRows = (cells != null) ? cells.length : 3;	// number of rows 
	public int boardCols = (cells != null) ? cells.length : 3;	// number of collums
	
	public Board(char[][] board)
	{
		cells = board;
	}
	
	public void setSeed(Player seed, Player other)
	{
		this.aiSeed = seed;
		opSeed = other;
	}
	
	public char[][] getCells()
	{
		return cells;
	}
	
	public void setCells(char[][] cells)
	{
		this.cells = cells;
	}
	
}
