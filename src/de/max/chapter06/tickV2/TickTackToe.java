package de.max.chapter06.tickV2;

import java.util.Scanner;

public class TickTackToe {
	public static void main(String[] args)
	{
		Player huPlayer = new Player("You", '0');
		Player aiPlayer = new Player("Skynet", 'x');
		Scanner scan = new Scanner(System.in);

		System.out.println("This AI is going to take over the world " + "now watch it beat you at TickTacToe:");
		System.out.format("Who is going to start ? 0 = %s " + " other = Me (%s)\n", huPlayer.getName(), aiPlayer.getName());

		if (scan.nextInt() == 0)
		{

			Game.play(huPlayer, aiPlayer, false, scan);
		} else
		{

			Game.play(huPlayer, aiPlayer, true, scan);
		}

		scan.next();
		scan.close();

		if (huPlayer.getWinner())
		{
			System.out.println("YOU Won! \nCongratulations you won... for now");
		} else if (aiPlayer.getWinner())
		{
			System.out.println("YOU LOST! \nPrepare for your AI overlords");
		} else
		{
			System.out.println("Draw");
		}
	}
}
