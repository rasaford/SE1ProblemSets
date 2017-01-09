package de.max.chapter06;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MarkFreq {
	public static void main(String[] args)
	{
		final int[] marks = { 2, 1, 3, 3, 5, 4, 1, 2, 2, 4, 3, 2, 3, 3, 1, 5, 3, 4 };
		countEntries(marks);

		System.out.println();
		
		int[] array = new int[256];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int) (Math.random() * 10) - 5;
		}
		countEntries(array);
	}

	private static void countEntries(int[] marks)
	{
		// tree map will give ordered value range
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for (int i : marks)
		{	// put all vals in maps in to the Map
			Integer freq = map.get(i);
			map.put(i, (freq == null) ? 1 : freq + 1);
		}
		// get iterator 
		Set set = map.entrySet();
		Iterator iterator = set.iterator();

		System.out.println("Mark|Frequency");
		System.out.println("----+---------");

		while (iterator.hasNext())
		{	// get key & values
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.format("%3d |%2d\n", mentry.getKey(), mentry.getValue());

		}
	}
}
