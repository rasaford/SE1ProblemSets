package de.max.chapter13.part2.ResultString;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ResultStringOrdering {

	public static void main(String[] args)
	{
		String document = "One day, Einstein, Newton, and Pascal meet "
				+ "up and decide to play a game of hide and seek. "
				+ "Einstein volunteered to be \"It\". As Einstein counted, "
				+ "eyes closed, to 100, Pascal ran away and hid, but Newton "
				+ "stood right in front of Einstein and drew a one meter by "
				+ "one meter square on the floor around himself. When Einstein "
				+ "opened his eyes, he immediately saw Newton and said \"I found "
				+ "you Newton\", but Newton replied, \"No, you found one Newton "
				+ "per square meter. You found Pascal!";

		// when you give the TreeMap a comparator in the Constructor it will us
		// that one to sort all Values inseted into it

		Map<String, Integer> wordFreq = new HashMap<>();
		// split the doc by the regex
		String[] words = document.split("[ \t\"!?.,'´`:;]+");

		// create a unique entry for each word in the Map if it exists increment
		// the count
		for (String key : words)
		{
			if (!wordFreq.containsKey(key))
			{
				wordFreq.put(key, 1);
			} else
			{
				wordFreq.put(key, wordFreq.get(key) + 1);
			}
		}
		// when a Tree Map gets created with a comparator as an argument it will
		// use that one to sort the K, V pairs
		Map<String, Integer> sorted = new TreeMap<>(new IntegerComparator(wordFreq));
		sorted.putAll(wordFreq);

		// format and print every entry of the map
		for (Map.Entry<String, Integer> entry : sorted.entrySet())
		{
			System.out.format("%3d : %s \n", entry.getValue(), entry.getKey());
		}

	}
}