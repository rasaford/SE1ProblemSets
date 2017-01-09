package de.max;

public class RecursionExample {
	public static void main(String[] args)
	{
		int factorial = 5;
		System.out.format("The factorial of %d! is: %d \n", factorial, factorialRecursiveV1(factorial));
//		
//		System.out.println(factorialV3(factorial));
		
//		long fibonacci = 10;
//		System.out.format("The %dth fibonacci number is: %d", fibonacci, fibonacci(fibonacci));
	}

	public static long factorialRecursiveV1(int n)
	{
		System.out.format("Calling: factorialRecursiveV1(%d) \n", n);
		if (n == 1)
		{ // base case
			return 1;
		}
		// subproblem
		long out = factorialRecursiveV1(n - 1);
		System.out.format("Returning: %d * %d \n", n, out);
		return out * n;
	}

	public static long factorialRecursiveV2(int n)
	{
		// base case of the recursion this is the trivial answer and can be
		// returned directly
		// if this is true it will end the otherwise infinite cycle
		// it's the first statement because if it is true any further
		// calculations become irrelevant and therefore don't need to take up
		// CPU cycles
		if (n == 1)
		{
			return 1;
		}
		// subproblem
		// divide and conquer strategy
		// ==> split your hard problem into smaller ones which you can solve
		// instantly if they become small enough
		return n * factorialRecursiveV2(n - 1);
	}

	public static long factorialV3(int n)
	{
		long result = n;
		
		while (n > 1)
		{
			result *= --n;
		}
		return result;
	}
	
	public static long binomialRecursive(int n, int k)
	{
		if (k == n || k == 0)
		{ // base case
			return 1;
		}
		// subproblem
		return binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
	}

	public static long fibonacci(long n)
	{
		// base cases
		if (n == 0)
		{
			return 0;
		} else if (n < 2)
		{
			return 1;
		}
		// subproblem
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}