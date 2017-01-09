package de.max.hdm.projects.EulersSieve;

import java.util.List;

public class Driver {

	public static void main(String[] args)
	{
		Primes pr = new Primes();
		int n = 516864861;

		System.out.println("You entered the number: " + n);
		System.out.println("The factors are:");
		List<Integer> factors = pr.primeFactorization(n);
		System.out.println(factors);
	}
}
