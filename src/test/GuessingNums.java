package test;

import java.util.Random;
import java.util.Scanner;

public class GuessingNums {
	public static void main(String[] args)
	{
		int maxVal = 10;
		Random randomObj = new Random();
		int rand = randomObj.nextInt(maxVal + 1);
		int tries = 5;

		System.out.format("Try to guess a number between %d and "
								+ "%d\n", 0, maxVal);
		System.out.format("You have %d tries\n", tries);
		System.out.print("Input your guess: ");

		Scanner scan = new Scanner(System.in);
		
		while (true)
		{
			int value = scan.nextInt();
			if (value == rand)
			{
				System.out.println("You won!");
				scan.close();
				break;
			} else if (value > rand)
			{
				System.out.println("Number is too high");
				tries--;
				System.out.format("You have %d tries\n", tries);
				System.out.print("Input your guess: ");

			} else if (value < rand)
			{
				System.out.println("Number is too low");
				tries--;
				System.out.format("You have %d tries\n", tries);
				System.out.print("Input your guess: ");
			}
		}
	}
}
