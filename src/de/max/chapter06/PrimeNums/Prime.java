package de.max.chapter06.PrimeNums;

import de.max.chapter06.intStorage.IntegerStore;

public class Prime {
	
	public static IntegerStore primes = new IntegerStore(32);
	
	public static boolean isPrimeV1(int number)
	{
		long start = System.nanoTime();
		for (int i = 2; i * i < number; i++)
		{
			if (number % i == 0)
				return false;
		}
		long dur = System.nanoTime() - start;
		System.out.println("exectime:" + dur);
		return true;
	}

	public static int[] getPrimes(int limit)
	{
		long start = System.nanoTime();
		// 1st Prime needs to be set manually
		primes.appendValue(2);
		for (int i = 3; i <= limit; i++)
		{
			isPrimeV2(i);
		}
		double mill = (double) (System.nanoTime() - start) * 1e-6;
		System.out.println("Milliseconds: " + mill);
		return primes.toArray();
	}

	public static boolean isPrimeV2(int number)
	{
		for (int i = 0; primes.getValue(i) * primes.getValue(i) <= number; i++)
		{
			if (number % primes.getValue(i) == 0)
			{
				return false;
			}
		}
		primes.appendValue(number);
		return true;
	}
}
