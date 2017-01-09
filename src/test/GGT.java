package test;

public class GGT {
	public static void main(String[] args)
	{
		// GGT ggt = new GGT.ggt(55,1)
		System.out.println("Slow GGT:");
		System.out.println(ggtSlow(69, 32));
		System.out.println("Fast GGT:");
		System.out.println(ggtFast(69, 32));
	}

	private static int ggtFast(int a, int b)
	{
		if (b == 0)
			return a;

		if (a > b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		System.out.println("a = " + a + " b = " + b);
		return ggtFast(a, b % a);

	}

	private static int ggtSlow(int a, int b)
	{
		if (b == a)
			return a;

		if (a > b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		System.out.println("a = " + a + " b = " + b);
		return ggtSlow(a, b - a);

	}

}