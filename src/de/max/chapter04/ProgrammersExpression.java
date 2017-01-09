package de.max.chapter04;

public class ProgrammersExpression {
	public static void main(String[] args)
	{
		int a = 6, 
			b = 7, 
			c = -3, 
			result = 0;

		result += ++a - b++ + --c;
		System.out.println(result);
		
		int result2 = 1 + a;
		result2 = result2 - b;
		result2 = result2 + 1;
		result2 = result2 + (c - 1);
		System.out.println(result2);
		
		
	}
}
