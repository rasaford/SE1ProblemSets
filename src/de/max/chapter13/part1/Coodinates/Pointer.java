package de.max.chapter13.part1.Coodinates;

public class Pointer {

	public static void main(String[] args)
	{
		final Point<Double> c12 = new Point<>(1.0, 2.0);
		final Point<Integer> c52 = new Point<>(5, 0);
		final Point<Integer> c12Duplicate = new Point<>(1, 2);

		System.out.println("c12:" + c12);
		System.out.println("c12.equals(c52):" + c12.equals(c52));
		System.out.println("c12.equals(c12Duplicate):" + c12.equals(c12Duplicate));
		System.out.println("c12.equals(\"dummy\"):" + c12.equals("dummy"));
		c12.hashCode();
		System.out.println(c12.hashCode());
		System.out.println(c12Duplicate.hashCode());
		System.out.println(c12.hashCode() == c12Duplicate.hashCode());
		
	}

}
