package de.max.chapter13.part2.Words;

import java.util.HashMap;
import java.util.Map;

public class WordSplitting {
	public static void main(String[] args)
	{
		String doc = "A simple collection of words." + "   Some words may appear multiple times.";
		HashMap<String, Integer> map = new HashMap<>();

		String[] curr = doc.split("[ \t\"!?.,'´`:;]+");

		for (String str : curr)
		{
			String key = str.toLowerCase();
			if (map.containsKey(key))
			{
				map.put(key, map.get(key) + 1);
			} else
			{
				map.put(key, 1);
			}
		}
		for (Map.Entry<String, Integer> entry: map.entrySet())
		{
			System.out.print(entry.getKey() + ", ");
		}
	}
}
