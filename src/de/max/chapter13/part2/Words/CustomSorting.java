package de.max.chapter13.part2.Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomSorting {

	public static void main(String[] args)
	{
		String[] strings = { "ant",	"apple", "by", "eye", "it", "printer", "van", "x-ray" };
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(strings));
		{
			Iterator<String> it = list.iterator();
			while (it.hasNext())
			{
				String element = it.next();
				System.out.print(element + ", ");
			}
		}
		Collections.sort(list, new StringCComp());
		System.out.println("\n\n");

		{
			Iterator<String> it = list.iterator();
			while (it.hasNext())
			{
				String element = it.next();
				System.out.print(element + ", ");
			}
		}
	}
}