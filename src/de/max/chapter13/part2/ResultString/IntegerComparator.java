package de.max.chapter13.part2.ResultString;

import java.util.Comparator;
import java.util.Map;

public class IntegerComparator implements Comparator<Object> {

	private Map<String, Integer> toSort;

	public IntegerComparator(Map<String, Integer> toSort)
	{
		this.toSort = toSort;
	}

	@Override
	public int compare(Object o1, Object o2)
	{
		Integer val1 = (Integer) toSort.get(o1);
		Integer val2 = (Integer) toSort.get(o2);

		// return vals have to be between -1 and 1 otherwise the sorting gets
		// fucked up
		return (val2 - val1 < 0) ? -1 : 1;
	}
}
