package de.max.chapter04.binomial;

public class Binomial {
	public static void main(String[] args)
	{
		System.out.println(binomial(10, 9));
	}
	private static long binomial(int n, int k)
	{
		long numerator = 1;
		long factorial = 1;
		
		if(n / 2 < k)
		{
			k = n - k;
		}
		// numerator Loop
		for (int i = n - k + 1; i <= n; i++)
		{
			numerator *= i;
			//System.out.println(numerator);
		}
		
		// Denominator Loop
		for (int i = 2; i <= k; i++)
		{
			factorial *= i;
			System.out.println(factorial);
		}
		return numerator / factorial;
	}
}
