package de.max.chapter04;

public class Summing {
	public static void main(String[] args)
	{
		System.out.println("sum: " + getSum(150));
	}
	private static long getSum(long limit)
	{
		long sum = 0;
		for (long i = 1; i <= limit; i++)
		{
			sum += i;
		}
		return sum;
	}

}
