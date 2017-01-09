package de.max.chapter13.part1.SetOfStrings;

import java.util.HashSet;
import java.util.Set;

import de.max.chapter13.part1.Coodinates.Point;

public class SetOfObjects {
	public static void main(String[] args)
	{
		Set<Point> points = new HashSet<>();
		
		points.add(new Point<Integer>(1,3));
		points.add(new Point<Integer>(1,3));
		points.add(new Point<Integer>(4,3));
		
		for (Point point : points)
		{
			System.out.println(point);
		}
	}
}
