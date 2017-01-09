package de.max.chapter06.intStorage;

public class Sorting {

	private static int[] vals;
	private static int[] working;

	public static int[] mergeSort(int[] input)
	{
		vals = input;
		int len = vals.length;
		working = new int[len];
		mergeSortRecursive(0, len - 1);
		return vals;
	}

	private static void mergeSortRecursive(int iStart, int iEnd)
	{
		// recursive base case
		if (iStart >= iEnd)
		{
			return;
		}
		// mid point of the array
		int iMid = iStart + (iEnd - iStart) / 2;

		// sub problmes
		// split each input array into two copies
		mergeSortRecursive(iStart, iMid);
		mergeSortRecursive(iMid + 1, iEnd);
		// once the base case is true the smaller array will get sorted and then
		// merged back together
		merge(iStart, iMid, iEnd);
	}

	private static void merge(int iStart, int iMid, int iEnd)
	{
		// copy from vals to working
		for (int i = iStart; i <= iEnd; i++)
		{
			working[i] = vals[i];
		}

		int i = iStart, j = iMid + 1, k = iStart;

		while (i <= iMid && j <= iEnd)
		{
			// compare the vals at start & end
			// take the lower of the two and write it into the output array
			if (working[i] <= working[j])
			{
				vals[k] = working[i];
				i++;
			} else
			{
				vals[k] = working[j];
				j++;
			}
			k++;
		}
		// if sorting exited early because of a lot of small values at the end
		// copy the remaining vals into the output array
		while (i <= iMid)
		{
			vals[k] = working[i];
			k++;
			i++;
		}
	}

	// public int[] quicksort(int[] vals)
	// {
	//
	// }
	//
	// public int[] bubblesort(int[] vals)
	// {
	//
	// }
	// public int[] heapsort(int[] vals)
	// {
	//
	// }

}
