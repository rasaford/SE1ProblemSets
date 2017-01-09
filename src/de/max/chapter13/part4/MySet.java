package de.max.chapter13.part4;

import java.lang.reflect.Array;

public class MySet<K> {

	private Class<K> refClass;
	private K[] keys;
	private int[] hashes;
	private int index;

	public MySet(Class<K> c)
	{
		this.refClass = c;
		// @SuppressWarnings("Unchecked")
		int defLen = 32;
		this.keys = (K[]) Array.newInstance(refClass, defLen);
		this.hashes = new int[defLen];
		index = -1;
	}

	public MySet(Class<K> c, K[] source)
	{
		this.refClass = c;
		int newLen = getNewLen(source.length);
		this.keys = (K[]) Array.newInstance(refClass, newLen);
		this.hashes = new int[newLen];

		for (int i = 0; i < source.length; i++)
		{
			if (!contains(keys[i]))
			{
				keys[i] = source[i];
				hashes[i] = source[i].hashCode();
				index = i;
			}
		}
	}

	/*
	 * returns the number of elements in the set
	 */
	public int size()
	{
		int zero = 0;
		int len = keys.length;
		for (int i = keys.length - 1; i >= 0; i--)
		{
			if (keys[i] != null)
				break;
			zero++;
		}
		return len -= zero;
	}

	/*
	 * checks if the set is empty
	 */
	public boolean isEmpty()
	{
		return (size() == 0) ? true : false;
	}

	/*
	 * searches through the set to see if any of the hashCodes match to the
	 * given Object
	 */
	public boolean contains(K obj)
	{
		int indexFound = search(obj);
		if (indexFound != -1)
			return true;
		else
			return false;
	}

	/*
	 * only allows addition if the element is not already in the set
	 */
	public boolean add(K obj)
	{
		if (obj == null || contains(obj))
			return false;

		if (index + 1 >= keys.length)
			tableDouble();

		keys[++index] = obj;
		hashes[index] = obj.hashCode();
		return true;
	}

	public boolean remove(K obj)
	{
		int indexF = search(obj);

		if (indexF != -1)
		{
			keys[indexF] = null;
			hashes[indexF] = 0;
			return true;
		} else
		{
			return false;
		}
	}

	public void clear()
	{
		for (int i = 0; i < size(); i++)
		{
			keys[i] = null;
			hashes[i] = 0;
		}
	}

	public K get(K obj)
	{
		int indexF = search(obj);
		if (indexF != -1)
		{
			return keys[indexF];
		}
		return null;
	}

	public K get(int index)
	{
		return keys[index];
	}

	public int getHash(int index)
	{
		return hashes[index];
	}

	public int getHash(K obj)
	{
		int indexF = search(obj);
		if (indexF != -1)
		{
			return hashes[indexF];
		}
		return -1;
	}
	/*
	 * 
	 */
	public K[] toArray()
	{
		K[] outKeys = (K[]) Array.newInstance(refClass, size());
		for (int i = 0; i < outKeys.length; i++)
		{
			outKeys[i] = keys[i];
		}
		return outKeys;
	}

	private void tableDouble()
	{
		int newLen = getNewLen(keys.length);
		K[] nKeys = (K[]) Array.newInstance(refClass, newLen);
		int[] nHashes = new int[newLen];

		for (int i = 0; i < keys.length; i++)
		{
			nKeys[i] = keys[i];
			nHashes[i] = hashes[i];
		}

		this.keys = nKeys;
		this.hashes = nHashes;
	}

	private int getNewLen(int oldLen)
	{
		int a = (int) (Math.log10(oldLen) / Math.log10(2));
		return (int) Math.pow(2, a + 1);
	}

	private int search(K obj)
	{
		int hash = obj.hashCode();
		for (int i = 0; i < keys.length; i++)
		{
			if (hashes[i] == hash)
			{
				return i;
			}
		}
		return -1;
	}
}