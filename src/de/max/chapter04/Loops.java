package de.max.chapter04;

public class Loops {
	public static void main(String[] args)
	{
		w_Sq(14);
		dw_Sq(14);
	}

	private static void w_Sq(int limit)
	{
		int i = 4;
		System.out.println("Computing square numbers");
		while (i < limit)
		{
			System.out.println("i = " + i + " , i * i = " + i * i);
			i += 3;
		}
		System.out.println("Finished computing square numbers");
	}

	private static void dw_Sq(int limit)
	{
		int i = 4;
		System.out.println("Computing square numbers");
		do
		{
			if (i < limit)
			{
				System.out.println("i = " + i + " , i * i = " + i * i);
				i += 3;
			}
		} while (i < limit);
		System.out.println("Finished computing square numbers");
	}
}
