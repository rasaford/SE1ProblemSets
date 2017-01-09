package de.max.chapter13.part2.Words;

import java.util.Collection;
import java.util.TreeSet;

public class WordSplittingSorted {
	public static void main(String[] args)
	{
		String doc = "A simple collection of words." + "   Some words may appear multiple times.";
		Collection<String> list = new TreeSet<>();

		String[] curr = doc.split("[ \t\"!?.,'´`:;]+");

		for (String str : curr)
		{	
			if (!list.contains(str))
			{
				list.add(str);
			}
		}
		
		for (String str : list)
		{
			System.out.print(str + ", ");
		}
	}
}
