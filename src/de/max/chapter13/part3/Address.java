package de.max.chapter13.part3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Address<K, V> {

	private HashMap<K, V> address;

	public Address(List<K> key, List<V> value)
	{
		HashMap<K, V> address = new HashMap<>();
		// copy the two lists into the HashMap
		Iterator<K> keyIt = key.iterator();
		Iterator<V> valueIt = value.iterator();
		while (keyIt.hasNext() && valueIt.hasNext())
		{
			address.put(keyIt.next(), valueIt.next());
		}
		this.address = address;
	}

	public HashMap<K, V> getMap()
	{
		return this.address;
	}

	public void print()
	{
		for (Map.Entry<K, V> entry : address.entrySet())
		{
			System.out.format("%s: %s \n", entry.getKey(), entry.getValue());
		}

	}
	public V get(String search)
	{
		return address.get(search);
	}
	
	public V getFirstName()
	{
		return address.get("firstName");
	}

	public V getLastName()
	{
		return address.get("lastName");
	}

	public V getAddress()
	{
		return address.get("address");
	}

	public V getCity()
	{
		return address.get("city");
	}

	public V getWeb()
	{
		return address.get("web");
	}

	public V getCompanyName()
	{
		return address.get("companyName");
	}

	public V getCounty()
	{
		return address.get("county");
	}

	public V getPhone1()
	{
		return address.get("phone1");
	}

	public V getPhone2()
	{
		return address.get("phone2");
	}

	public V getPostal()
	{
		return address.get("postal");
	}

	public V getEmail()
	{
		return address.get("email");
	}

}
