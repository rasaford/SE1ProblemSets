package de.max.chapter13.part3;

import java.util.List;

public class HTMLDriver {
	public static void main(String[] args)
	{
		Doc2Address reader = new Doc2Address();
		HtmlTable htmlTable = new HtmlTable();
		String inputFile = "/home/max/Desktop/addresses.txt";
		String outputFile = "/home/max/Desktop/index.html";

		// parse the given address file
		List<Address<String, String>> addresses = reader.parse(inputFile);
		// create the html code from the addresses
		String[] htmlCode = htmlTable.toTable(addresses);
		// print that to the output directory
		PrintToFile.toFile(outputFile, htmlCode);
	}
}