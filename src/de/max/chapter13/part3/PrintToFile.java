package de.max.chapter13.part3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintToFile {

	public static void toFile(String dir, String ...input)
	{
		try{
			PrintStream write = new PrintStream(new FileOutputStream(dir, false));
			
			for (String data : input)
			{
				write.print(data);
			}
			write.close();
			System.out.println("succesfully written to: " + dir);
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
