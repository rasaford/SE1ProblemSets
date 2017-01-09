package de.max.chapter13.part1.SetOfStrings;

import java.util.HashSet;
import java.util.Set;

public class SetOfStrings {
	public static void main(String[] args)
	{
		Set<String> names = new HashSet<>();
		names.add("John");
		names.add("Alice");
		names.add("Bob");
		
		for (String name : names)
		{
			System.out.println(name);
		}
	}
}
