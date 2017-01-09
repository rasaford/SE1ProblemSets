package de.max.chapter13.part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Doc2Address {
	public List<Address<String, String>> parse(String dir)
	{
		List<String> lines = readToLines(dir);
		// fisrt line is the keys split it and use it sep
		List<String> keys = splitFields(lines.remove(0));
		List<Address<String, String>> addresses = new ArrayList<>();
		{
			Iterator<String> iterate = lines.iterator();
			while (iterate.hasNext())
			{
				String values = iterate.next();
				List<String> addrVals = splitFields(values);
				addresses.add(new Address<String, String>(keys, addrVals));
			}
		}

		// List<String> fields = splitFields(lines);
//		{
//			Iterator<Address<String, String>> a = addresses.iterator();
//			while (a.hasNext())
//			{
//				a.next().print();
//			}
//		}
		return addresses;
	}

	private List<String> readToLines(String dest)
	{
		List<String> lines = new ArrayList<>();
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(dest));
			String curLine;
			while ((curLine = read.readLine()) != null)
			{
				if (!curLine.trim().isEmpty())
				{
					lines.add(curLine);
				}
			}
			read.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return lines;
	}

	private List<String> splitFields(String line)
	{
		String regex = "(\",\")|(\",)|(,\")|(^\")|(\"$)";
		List<String> split = Arrays.asList(line.split(regex));
		return split;
	}
}
