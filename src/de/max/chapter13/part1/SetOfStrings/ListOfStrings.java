package de.max.chapter13.part1.SetOfStrings;

import java.util.LinkedList;
import java.util.List;

public class ListOfStrings {
	public static void main(String[] args)
	{
		List<String> names = new LinkedList<>();
		names.add("John");
		names.add("Alice");
		names.add("Bob");
		
		for (String name : names)
		{
			System.out.println(name);
		}
	}
}
