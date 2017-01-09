package de.max.chapter06.tickV2;

public class Player {

	private String name;
	private char sign;
//	private char[][] board = new char[3][3];
	private boolean winner;
	

	public Player(String name, char sign)
	{
		this.name = name;
		this.sign = sign;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
//
//	public char[][] getBoard()
//	{
//		return board;
//	}
//
//	public void setBoard(char[][] board)
//	{
//		this.board = board;
//	}

	public boolean getWinner()
	{
		return winner;
	}

	public void setWinner(boolean winner)
	{
		this.winner = winner;
	}
	
	public char getSign()
	{
		return sign;
	}
	
	public void setSign(char sign)
	{
		this.sign = sign;
	}
}
