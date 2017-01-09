package de.max.chapter04;

public class LeapYear {
	public static void main(String[] args)
	{
		System.out.println("Is 1800 a leap year? " + isLeapYear(1800));
		System.out.println("Is 2000 a leap year? " + isLeapYear(2000));
		System.out.println("Is 2016 a leap year? " + isLeapYear(2016));
	}

	private static boolean isLeapYear(int year)
	{
		if (year % 4 != 0)
		{
			return false;
		} else if (year % 100 != 0)
		{
			return true;
		} else if (year % 400 != 0)
		{
			return false;
		}
		return true;
	}
}
