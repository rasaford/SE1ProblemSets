package de.max.chapter13.part4;

public class SetDriver {

	public static void main(String[] args)
	{
		MySet<String> set = new MySet<>(String.class);

		for (int i = 0; i < 66; i++)
		{
			Integer a = i * i;
			set.add(a.toString());
		}
		System.out.println(set.size());
	}
}