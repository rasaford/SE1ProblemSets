package de.max.chapter06.ConsoleInput;

import java.util.Scanner;

public class Reading {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		System.out.println("vals to sum?");

		int input = s.nextInt();
		int[] vals = new int[input + 1];
		int sum = 0;
		
		for(int i = 1; i <= input; i++)
		{
			System.out.format("Enter a value # %d of %d: ", i, input);
			int val = s.nextInt(); 
			sum += val;
			vals[i] = val;
		}
		
		for (int i = 0; i < vals.length; i++)
		{
			if(vals[i] > 0 && i != 0)
			{
				System.out.print("+");
			}
			System.out.print("" + vals[i]);
		}
		System.out.format(" = %d", sum);
		s.close();
		
		
	}
}
