package de.max.chapter10.nonsense;

public class NonsenseDriver {

	public static void main(String[] args)
	{
		Nonsense nonsense = new Nonsense(new RandomGenerator());
		for (int i = 0; i < 500; i++)
		{
			System.out.println(nonsense.get());
		}
	}
}
