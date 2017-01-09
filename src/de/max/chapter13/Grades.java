package de.max.chapter13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Grades {
	public static void main(String[] args)
	{
		List<String> lines = parse("/home/max/Desktop/grades.txt");
		Map<String, Integer> gradeFreq = gradeFequency(lines);

		System.out.println("Grades with Frequency:");
		
		for (Map.Entry<String, Integer> entry : gradeFreq.entrySet())
		{
			System.out.format("%s: %2d \n", entry.getKey(), entry.getValue());
		}
		System.out.println();
		System.out.println("Grades with Names:");
		
		Map<String, String> gradeNames = gradeNames(lines);

		for (Map.Entry<String, String> entry : gradeNames.entrySet())
		{
			System.out.format("%s: %s \n", entry.getKey(), entry.getValue());
		}
	
	}

	public static List<String> parse(String path)
	{
		List<String> lines = new ArrayList<>();
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(path));
			String line;
			while ((line = read.readLine()) != null)
			{
				lines.add(line);
			}
			read.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return lines;
	}

	public static Map<String, Integer> gradeFequency(List<String> lines)
	{
		HashMap<String, Integer> map = new HashMap<>();
		{
			Iterator<String> it = lines.iterator();
			while (it.hasNext())
			{
				String[] grades = it.next().split(", ");
				String key = grades[1];
				
				if (map.containsKey(key))
				{
					map.put(key, map.get(key) + 1);
				} else
				{
					map.put(key, 1);
				}
			}
		}
		return map;
	}
	public static Map<String, String> gradeNames(List<String> lines)
	{
		HashMap<String, String> map = new HashMap<>();
		{
			Iterator<String> it = lines.iterator();
			while (it.hasNext())
			{
				String[] grades = it.next().split(", ");
				String key = grades[1];
				String name = grades[0];
				
				if (map.containsKey(key))
				{
					map.put(key, map.get(key) + ", " +  name);
				} else
				{
					map.put(key, name);
				}
			}
		}
		return map;
	}
}
