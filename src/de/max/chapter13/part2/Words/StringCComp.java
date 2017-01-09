package de.max.chapter13.part2.Words;

import java.util.Comparator;

public class StringCComp implements Comparator<String> {

	@Override
	public int compare(String s1, String s2)
	{
		int len1 = s1.length();
		int len2 = s2.length();

		return len1 - len2;
	}
}
