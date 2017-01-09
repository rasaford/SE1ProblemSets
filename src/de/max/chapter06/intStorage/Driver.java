package de.max.chapter06.intStorage;

public class Driver {
	public static void main(String[] args)
	{
		IntegerStore store = new IntegerStore();
		for (int i = 0; i < 64; i++)
		{
			store.appendValue((int) (Math.random() * 1000) - 500);
		}
		
		for (int i = 0; i < store.getLength(); i++)
		{
			System.out.format("index: %5d: %5d \n", i, store.getValue(i));
		}
		System.out.println("length: " + store.getLength());
		System.out.println("Average: " + store.getAverage());

	}
}
