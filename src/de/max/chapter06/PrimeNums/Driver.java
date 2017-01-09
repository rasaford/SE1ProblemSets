package de.max.chapter06.PrimeNums;

public class Driver {
	public static void main(String[] args)
	{
//		long prime = 9999937;
//		long primeTableSize = prime + 1;
//		System.out.format("Is %d prime? \n", prime);
//
//		// System.out.println(Prime.isPrimeV1(prime));
//		long[] primes = Prime.getPrimes(primeTableSize);
//		System.out.println(Prime.isPrimeV2(prime));

		int[] primes = Prime.getPrimes(100_000_000);
		
		for(int i = 0;  i < primes.length; i++)
		{
			System.out.println("#" + i + ":" + primes[i]);
		}
		}
}
