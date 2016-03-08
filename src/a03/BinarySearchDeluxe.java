package a03;

import java.util.Comparator;

public class BinarySearchDeluxe {

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)
    {
		int min = 0;
		int max = a.length - 1;
		int mid = max / 2;
		
		//TODO sort(a);

		if(comparator.compare(key, a[min]) < 0 || comparator.compare(key, a[max]) > 0)
			return - 1;
		else if(comparator.compare(key, a[min]) == 0)
			return min;
		
		 do
		{
			if(comparator.compare(key, a[mid]) == 0 && comparator.compare(key, a[mid - 1]) > 0)
			{
				return mid;
			}
			else if(comparator.compare(key, a[mid]) < 0)
			{
				max = mid;
				mid = max / 2;
				if(min == max)
				{
					return - 1;
				}
				else
				{
					continue;
				}
			}
			else
			{
				min = mid;
				mid += (max - mid) / 2;
				
				if(min == max)
				{
					return -1;	
				}else
				{
					continue;
				}
			}			
		}while(min != mid);
		 
		 return - 1;
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
    {
		return 0;
    	
    }
    
    public static void main(String[] args)
    {
    	String[] strings = {"a", "a", "b", "c", "d", "d", "e", "e", "e", "f", "h", "i", "k", "k", "l", "m", "o"};
    	System.out.println(firstIndexOf(strings, "d", String.CASE_INSENSITIVE_ORDER));
    }		
}