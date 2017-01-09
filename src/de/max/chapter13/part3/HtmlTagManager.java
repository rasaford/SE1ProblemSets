package de.max.chapter13.part3;

import java.util.Stack;

public class HtmlTagManager {

	private String identSize = "  ";
	private int indent = 0;
	private Stack<String> lTag = new Stack<>();

	// Multi Line Tags
	//
	//
	//
	public String html()
	{
		return multiLine("html", "");
	}

	public String head()
	{
		return multiLine("head", "");
	}

	public String body()
	{
		return multiLine("body", "");
	}

	public String table()
	{
		return multiLine("table", "");
	}

	public String table(String tagArgs)
	{
		return multiLine("table", tagArgs);
	}

	
	public String tr()
	{
		return multiLine("tr", "");
	}

	// Single Line Tags
	//
	//
	//
	private String singleLine(String tagName, String tagContent)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(printIndent());
		sb.append("<" + tagName + ">");
		sb.append(tagContent);
		sb.append("</" + tagName + ">\n");

		return sb.toString();
	}

	private String multiLine(String tagName, String tagArgs)
	{
		StringBuilder sb = new StringBuilder();
		String space = (tagArgs.isEmpty()) ? "" : " ";
		
		sb.append(printIndent());
		sb.append("<" + tagName + space + tagArgs + ">\n");
		indent++;
		lTag.push("</" + tagName + ">\n");
		return sb.toString();
	}

	public String title()
	{
		return singleLine("title", "");
	}

	public String title(String s)
	{
		return singleLine("title", s);
	}

	public String th()
	{
		return singleLine("th", "");
	}

	public String th(String s)
	{
		return singleLine("th", s);
	}

	public String h1()
	{
		return singleLine("h1", "");
	}

	public String h1(String s)
	{
		return singleLine("h1", s);
	}

	public String h2()
	{
		return singleLine("h2", "");
	}

	public String h2(String s)
	{
		return singleLine("h2", s);
	}
	
	public String b()
	{
		return singleLine("b", "");
	}

	public String b(String s)
	{
		return singleLine("b", s);
	}
	
	public String doctype()
	{
		return printIndent() + "<!DOCTYPE>\n";
	}

	public String incIndent()
	{
		this.indent++;
		return "";
	}

	public String decIndent()
	{
		this.indent--;
		StringBuilder sb = new StringBuilder();
		sb.append(printIndent());
		sb.append(lTag.pop());
		return sb.toString();
	}

	public String closeAll()
	{
		StringBuilder sb = new StringBuilder();
		while (this.indent != 0)
		{
			sb.append(decIndent());
		}
		return sb.toString();
	}

	private String printIndent()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indent; i++)
		{
			sb.append(identSize);
		}
		return sb.toString();
	}
}
