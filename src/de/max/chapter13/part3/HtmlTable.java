package de.max.chapter13.part3;

import java.util.Iterator;
import java.util.List;

public class HtmlTable {

	private HtmlTagManager h = new HtmlTagManager();

	public String[] toTable(List<Address<String, String>> addresses)
	{

		String[] out = new String[3];
		out[0] = htmlHeader();
		out[1] = adressData(addresses);
		out[2] = h.closeAll();
		return out;
	}

	private String htmlHeader()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(h.doctype());
		sb.append(h.html());
		sb.append(h.head());
		sb.append(h.title("This is a genius title"));
		sb.append(h.decIndent());
		sb.append(h.body());
		sb.append(h.h1("Address List:"));
		sb.append(h.table("border='1'"));
		sb.append(h.tr());
		sb.append(h.th("Name"));
		sb.append(h.th("Address"));
		sb.append(h.th("Phone"));
		sb.append(h.th("E-Mail"));

		return sb.toString();
	}

	private String adressData(List<Address<String, String>> addresses)
	{
		StringBuilder sb = new StringBuilder();
		Iterator<Address<String, String>> iterate = addresses.iterator();

		while (iterate.hasNext())
		{
			Address<String, String> a = iterate.next();
			sb.append(h.tr());
			String name = a.getFirstName() + " " + a.getLastName();
			String address = a.getAddress() + ", " + a.getCity() + ", " + a.getPostal();
			String phone = a.getPhone1();
			String email = a.getEmail();
			sb.append(h.th(name));
			sb.append(h.th(address));
			sb.append(h.th(phone));
			sb.append(h.th(email));
			sb.append(h.decIndent());
		}

		return sb.toString();
	}
}
