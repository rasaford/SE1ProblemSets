package de.max.chapter06.tickV3;

public class Player {

	private String name;
	private char sign;
	// private char[][] board = new char[3][3];
	private boolean winner;
	private boolean ai = false;

	public Player(String name, char sign)
	{
		this.name = name;
		this.sign = sign;

		// auto set AI
		if (name.equals("AI"))
		{
			ai = true;
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public char getSign()
	{
		return sign;
	}

	public boolean hasWon()
	{
		return winner;
	}

	public void setWon(boolean winner)
	{
		this.winner = winner;
	}
	
	public boolean isAi()
	{
		return ai;
	}
}
