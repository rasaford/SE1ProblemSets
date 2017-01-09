package de.max.chapter06.tickV1;

public class Player {
	
	private String name;
	private char[][] board = new char[3][3];
	private boolean winner;
	
	public Player(String name, char[][] board)
	{
		this.name = name;
		this.board = board;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public char[][] getBoard()
	{
		return board;
	}
	
	public void setBoard(char[][] board)
	{
		this.board = board;
	}
	
	public boolean getWinner()
	{
		return winner;
	}
	
	public void setWinner(boolean winner)
	{
		this.winner = winner;
	}
	
}
