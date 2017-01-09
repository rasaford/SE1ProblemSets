package de.max.chapter03;

public class PythagoranTriple {
	public static void main(String[] args)
	{
		goodTripple();
		System.out.println();
		badTripple();
	}

	private static void goodTripple()
	{
		long start = System.currentTimeMillis();
		int maxVal = 1000;
		long count = 0;

		for (int i = 1; i <= maxVal; i++)
		{
			for (int j = maxVal - i; j > i; j--)
			{
				int k = maxVal - j - i;
				count++;
				if ((i * i + j * j) == k * k)
				{
					System.out.format("Found a: %d, b: %d, c: %d\n", i, j, k);
					System.out.println("After " + count + " iterations");
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.format("Running Time: %d ms \n", (end - start));

	}

	private static void badTripple()
	{
		long start = System.currentTimeMillis();
		int count = 0;
		for (int a = 1; a < 998; a++)
		{
			for (int b = 1; b < 998; b++)
			{
				for (int c = 1; c < 998; c++)
				{
					count++;
					if (
						a * a + b * b == c * c && // Pythagorean condition
								a + b + c == 1000
					)
					{ // Additional constraint
						System.out.println("Found (" + a + ", " + b + ", " + c + ")");
						System.out.println("After " + count + " iterations");
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.format("Running Time: %d ms \n", (end - start));
	}
}
