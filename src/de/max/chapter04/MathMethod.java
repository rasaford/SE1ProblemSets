package de.max.chapter04;

public class MathMethod {
	public static void main(String[] args)
	{
		SinTable(360);
	}
	
	private static void SinTable(int limit)
	{
		int breakRows = 5,
				count = 0;
		System.out.println("  x | sin(x)");
		System.out.println("----+-------");
		for (int i = 0; i < limit; i += 5)
		{
			double rad = (double)i * (Math.PI/180.0);
			double sin = Math.sin(rad);
			System.out.format(" %3d|%7.3f \n", i, round(sin, 2));
			   
			count++;
			if (count % breakRows == 0)
			{
				System.out.println("----+-------");
			}
		}
	}
	
	private static double round(double value, int digits)
	{
		for(int i = 0; i < digits; i++)
		{
			value *= 10;
		}
		long l = Math.round(value);
		double out = (double) l;
		for(int i = 0; i < digits; i++)
		{
			out /= 10;
		}
		return out;
	}
}
