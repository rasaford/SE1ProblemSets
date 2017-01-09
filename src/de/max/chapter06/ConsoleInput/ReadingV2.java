package de.max.chapter06.ConsoleInput;

import java.util.Scanner;

public class ReadingV2 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		System.out.println("vals to sum?");

		int input = s.nextInt();
		int[] vals = new int[input];
		int sum = 0;

		for (int i = 1; i <= input; i++)
		{
			System.out.format("Enter a value # %d of %d: ", i, input);
			int val = s.nextInt();
			if (val == 0)
				continue;
			sum += val;
			vals[i - 1] = val;
		}

		start: for (int i = 0; i < vals.length; i++)
		{
			if (vals[i] < 0)
			{
				for (int j = vals.length - 1; j >= 0; j--)
				{
					if (vals[j] > 0)
					{
						int temp = vals[i];
						vals[i] = vals[j];
						vals[j] = temp;
						break start;
					}
				}
			}
		}

		for (int i = 0; i < vals.length; i++)
		{
			if (vals[i] > 0 && i != 0)
			{
				System.out.print("+");
			}
			if (vals[i] != 0)
				System.out.print("" + vals[i]);
		}
		if (vals.length > 1)
		{
			System.out.format(" = %d", sum);
		}
		s.close();

	}
}
