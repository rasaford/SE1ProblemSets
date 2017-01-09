package de.max.chapter04.MathLibrary;

public class Math {

	private static int expSeriesLimit = 8;

	public static long getGcd(long a, long b)
	{ // improved euclidian alogrithm for Gcd calculation
		// special cases
		if (a < 0 || b < 0)
		{
			System.err.println("The values have to both be positive");
			return -1;
		}

		if (a == 0)
		{ // if a & b are the same their divisor is one of the two
			return b;
		}
		if (a < b)
		{ // swap if a < b
			long temp = a;
			a = b;
			b = temp;
		}
		// recursively call getGcd again until the base case is met
		return getGcd(a % b, b);
	}

	public static long getCommonMultiple(long a, long b)
	{
		long gcd = getGcd(a, b);
		if (gcd == 1)
		{
			return a * b;
		} else
		{
			return (a / gcd) * b;
		}
	}

	public static double abs(double value)
	{ // if value is negative multiply by -1
		if (value < 0)
		{
			return value * -1;
		} else
			return value;
	}

	public static double max(double a, double b)
	{ // return the larger of the two values
		if (a > b)
		{
			return a;
		} else
		{
			return b;
		}
	}

	public static double max(double a, double b, double c)
	{ // compare a & b then check the result against c
		// the result will be the largest of all of them
		return max(max(a, b), c);
	}

	public static long factorial(int n)
	{
		if (n == 0)
		{
			return 1;
		}
		long result = 1;
		for (int i = n; i > 0; i--)
		{
			if (i > Long.MAX_VALUE / result)
			{ // check fr an overflow
				return Long.MAX_VALUE;
			} else
			{ // if there is no overflow continue as usual
				result *= i;
			}
		}
		return result;
	}

	public static long factorialRecursive(int n)
	{
		if (n == 1)
		{ // base case
			return 1;
		}
		// subproblem
		return n * factorialRecursive(n - 1);
	}

	public static long binomialRecursive(int n, int k)
	{
		if (k == n || k == 0)
		{ // base case
			return 1;
		}
		return binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
	}

	public static void setSeriesLimit(int limit)
	{
		expSeriesLimit = limit;
	}

	public static double pow(double a, int b)
	{
		// returns a to the power of b
		double result = 1;
		if (b == 0)
		{
			return 1;
		}
		for (int i = 1; i <= b; i++)
		{
			result *= a;
		}
		return result;
	}

	public static double exp(double a)
	{
		double result = 1;
		for (int i = 1; i <= expSeriesLimit; i++)
		{
			result += pow(a, i) / factorial(i);
		}
		return result;
	}

	public static double sin(double x)
	{
		double result = x;
		for (int i = 1; i <= expSeriesLimit; i++)
		{
			double series = pow(x, 2 * i + 1) / factorial(2 * i + 1);
			result += pow(-1, i) * series;
		}
		return result;
	}

	public static double cos(double x)
	{
		double result = 1;
		for (int i = 1; i <= expSeriesLimit; i++)
		{
			double series = pow(x, 2 * i) / factorial(2 * i);
			result += pow(-1, i) * series;
		}
		return result;
	}

	private static double mapPi(double x)
	{
		double result = x;
		double pi = java.lang.Math.PI;

		// map all values to -pi ; pi
		if (x > pi)
		{
			while (result > -pi && !(result < pi))
			{
				result -= 2 * pi;
			}
		} else if (x < -pi)
		{
			while (result < pi && !(result > -pi))
			{
				result += 2 * pi;
			}
		}

		// map the values to -pi/2 to pi/2
		if (x > pi / 2)

		{
			result = pi - x;
		} else if (x < -pi / 2)
		{
			result = -pi - x;
		}
		return result;
	}

	public static double sinHighPrecision(double x)
	{
		return sin(mapPi(x));
	}

}