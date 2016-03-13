package a03;

import java.util.Comparator;

public class BinarySearchDeluxe
{

	// Return the index of the first key in a[] that equals the search key, or
	// -1 if no such key.
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		int min = 0;
		int max = a.length - 1;
		int mid = min + ((max - min) / 2);

		if (comparator.compare(key, a[min]) < 0 || comparator.compare(key, a[max]) > 0)
		{
			return -1;
		}
		
		if(comparator.compare(key,a[min]) == 0)
			return min;
		if(comparator.compare(key, a[max]) == 0)
			return max;
		
		while (min <= max)
		{
			if(comparator.compare(key, a[mid]) == 0 && comparator.compare(key, a[mid-1]) < 0)
			{
				return mid;
			}
		    else if (comparator.compare(key, a[mid]) > 0)
			{
				min = mid;
				mid = min + ((max - min) / 2);
			} else if (comparator.compare(key, a[mid]) < 0)
			{
				max = mid;
				mid = min + ((max - min) / 2);
			}
			
		}
		return -1;

	}

	// Return the index of the last key in a[] that equals the search key, or -1
	// if no such key.
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		return 0;

	}
}