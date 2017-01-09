package de.max.chapter05;

public class StringInstances {
	public static void main(String[] args)
	{
		final String a1 = "TestA", a2 = "TestA";
		System.out.println("a1 == a2: " + (a1 == a2));
		System.out.println("a1.equals(a2): " + a1.equals(a2));
		System.out.println("True because java detects if 2 Strings are the "
				+ "same and ony stores one of them in heap "
				+ "then is asigns the same pointer to the two "
				+ "references\n");

		final String b1 = new String("TestB"), b2 = new String("TestB");
		System.out.println("b1 == b2: " + (b1 == b2));
		System.out.println("b1.equals(b2): " + b1.equals(b2));
		System.out.println("flase beacause the new keyword forces "
				+ "java to create 2 seperate strings, which have dirrent "
				+ "pointers. Therefore the coparison evals to "
				+ "false");
	}
}
