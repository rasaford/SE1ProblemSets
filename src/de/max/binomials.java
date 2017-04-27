package de.max;

public class binomials {
	private static long steps = 0;
	public static void main(String[] args) {
		System.out.println(String.format("Binomial of %d choose %d = %d", 49, 6, binomial(49, 6)));
		System.out.println(steps);
	}

	private static long binomial(long n, long k) {
		steps++;
		if (k < 0 || k > n) return 0;
		if (n == 1 && k == 0 || n == k) return 1;
		return binomial(n - 1, k) + binomial(n - 1, k - 1);
	}
}


