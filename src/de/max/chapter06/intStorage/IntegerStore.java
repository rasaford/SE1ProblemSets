package de.max.chapter06.intStorage;

public class IntegerStore {

	private int[] vals;
	private int lastIndex;

	public IntegerStore(int[] vals, int size)
	{
		if (vals.length > size)
		{
			size = vals.length;
		}

		this.vals = new int[size];
		for (int i = 0; i < vals.length; i++)
		{
			this.vals[i] = vals[i];
		}
		lastIndex = vals.length - 1;
	}

	public IntegerStore(int size)
	{
		this.vals = new int[size];
		lastIndex = -1;
	}

	public IntegerStore()
	{
		this.vals = new int[4];
		lastIndex = -1;
	}

	public int getValue(int index)
	{
		return vals[index];
	}

	public void setValue(int index, int value)
	{
		this.vals[index] = value;
	}

	public int getLength()
	{
		return vals.length;
	}

	public void setVals(int[] vals)
	{
		this.vals = vals;
	}

	public int[] getVals()
	{
		return vals;
	}

	public void appendValue(int value)
	{
		if (vals.length - 1 <= lastIndex)
		{
			vals = arrayDouble(vals);
		}
		vals[++lastIndex] = value;
	}

	private int[] arrayDouble(int[] vals)
	{
		int[] out = new int[vals.length * 2];
		for (int i = 0; i < vals.length; i++)
		{
			out[i] = vals[i];
		}
		return out;
	}

	public void clear()
	{
		for (int i = 0; i < vals.length; i++)
		{
			vals[i] = 0;
		}
	}
	
	public void sort()
	{
		vals = Sorting.mergeSort(vals);
	}

	public double getMedian()
	{
		if (vals.length > 0)
		{
			vals = Sorting.mergeSort(vals);
			return vals[lastIndex / 2 + 1];
		}
		return 0;
	}

	public double getAverage()
	{
		int sum = 0;
		int len = 0;
		for (int i = 0; i < vals.length; i++)
		{
			sum += vals[i];
			// only incement len if the field value has been init
			len += (vals[i] != 0) ? 1 : 0;
		}
		return sum / len;
	}

	public int[] toArray()
	{
		int len = 0;
		for (int i = vals.length - 1; i >= 0; i--)
		{
			if (vals[i] == 0)
				len++;
			else
				break;
		}
		len = vals.length - len;
		int[] out = new int[len];
		for (int i = 0; i < out.length; i++)
		{
			out[i] = vals[i];
		}
		return out;
	}
}
