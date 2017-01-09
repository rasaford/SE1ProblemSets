package de.max.chapter06.intStorage;

public class BoundedIntegerStore {

	private int[] vals;
	private int size;

	public BoundedIntegerStore(int[] vals, int size)
	{
		this.vals = new int[size];
		this.size = size;
	}

	public int[] getVals()
	{
		return vals;
	}
	
	public void setVals(int[] vals)
	{
		this.vals = vals;
	}
}
