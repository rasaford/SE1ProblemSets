package de.max.hdm.projects.EulersSieve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Primes {

	private List<Integer> primes;

	// to get the actual prime values you have to mult each false value's index
	// by 2 and add 1
	// so:
	// 2 * i + 1
	// this is O(n log loo n)
	private boolean[] eratosthenesV2(int n)
	{
		boolean[] notPrime = new boolean[n / 2];
		// 1 is not prime
		notPrime[0] = true;
		for (int i = 1; i < n / 2; i++)
		{
			if (!notPrime[i])
			{
				int start = 2 * i + 1 + i;
				for (int j = start; j < n / 2; j += 2 * i + 1)
				{
					notPrime[j] = true;
				}
			}
		}
		return notPrime;
	}

	public List<Integer> getPrimes(int n)
	{
		boolean[] primes = eratosthenesV2(n);
		List<Integer> out = new ArrayList<>();
		for (int i = 0; i < primes.length; i++)
		{
			if (!primes[i])
				out.add(2 * i + 1);
		}
		out.add(2);
		out.sort(new IntegerComparator());
		this.primes = out;
		return out;
	}

	public List<Integer> primeFactorization(int n)
	{
		getPrimes(n);
		List<Integer> factors = new ArrayList<>();
		Iterator<Integer> it = this.primes.iterator();
		int decomp = n;
		while (it.hasNext())
		{
			if (decomp == 0)
				break;
			int value = it.next();
			while (decomp % value == 0)
			{
				decomp /= value;
				factors.add(value);
			}
		}
		return factors;
	}
}
