package de.max.hdm.projects.jgrep;

public class JgrepDriver {
	public static void main(String[] args)
	{
		Jgrep jgrep = new Jgrep();
		jgrep.parse("-i flower " + "/home/max/Desktop/text1.txt" + " /home/max/Desktop/text3.txt" + " ");
		// "-i flower /home/max/Desktop/text1.txt /home/max/Desktop/text3.txt "
	}
}