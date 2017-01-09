package de.max.chapter05;

public class Wierder {
	public static void main(String[] args)
	{
		name1();
		System.out.println("euqak becaue the compiler can detect "
				+ "that the strings will be the same and "
				+ "only creates 1 Object \n");
		name2();
		System.out.println("not equal because the compiler cannot "
				+ "eval .concat() and therefore the JVM "
				+ "creates  strings / 2 Obejcts that "
				+ "have differen pointers\n");
	}
	

	private static void name1()
	{
		final String reference = "Anton";
		final String name = "An" + "ton";

		System.out.println("Content:" + name);
		if (name == reference)
		{
			System.out.println("Instances are equal");
		} else
		{
			System.out.println("Instances are not equal");
		}
	}

	private static void name2()
	{
		final String reference = "Anton";
		final String name = "An".concat("ton");
		System.out.println("Content:" + name);
		if (name == reference)
		{
			System.out.println("Instances are equal");
		} else
		{
			System.out.println("Instances are not equal");
		}
	}
}
