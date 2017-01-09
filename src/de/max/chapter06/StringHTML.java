package de.max.chapter06;

public class StringHTML {
	public static void main(String[] args)
	{
		String[] countries = {"England", "France", "Germany"};
		String out = stringsToHtml(countries);
		
		System.out.println("This is some fancy HTML code:");
		System.out.println(out);
	}
	
	public static String stringsToHtml(String[] strings)
	{
		String start = "<ul>";
		String end = "</ul>";
		String indent = "    ";
		String out = "";
		
		// check fpr empty array
		if (strings.length < 1)
		{
			System.err.println("the array in empty");
			return "";
		}
		for(int i = 0; i < strings.length; i++)
		{
			out = out + indent + "<li>" + strings[i] + "</li>\n";
		}
		return start + "\n" + out + end; 
	}
}
