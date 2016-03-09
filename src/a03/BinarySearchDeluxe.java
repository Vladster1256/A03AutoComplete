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
		else if(comparator.compare(key, a[max]) == 0 && comparator.compare(key, a[max - 1]) < 0)
			return max;
		
		 do
		{
			if(comparator.compare(key, a[mid]) == 0 && comparator.compare(key, a[mid - 1]) > 0)
			{
				return mid;
			}
			else if(comparator.compare(key, a[mid]) < 0)
			{
				max = mid - 1;
				mid = max / 2;
			}
			else
			{
				min = mid + 1;
				mid += (max - mid) / 2;
			}			
		}while(min <= mid);
		 
		 return - 1;
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
    {
		int min = 0;
		int max = a.length - 1;
		int mid = max / 2;
		
		//TODO sort(a);

		if(comparator.compare(key, a[min]) < 0 || comparator.compare(key, a[max]) > 0)
			return - 1;
		else if(comparator.compare(key, a[max]) == 0)
			return max;
		else if(comparator.compare(key, a[min]) == 0 && comparator.compare(key, a[min + 1]) > 0)
			return min;
				
		 do
		{
			if(comparator.compare(key, a[mid]) == 0 && comparator.compare(key, a[mid + 1]) < 0)
			{
				return mid;
			}
			else if(comparator.compare(key, a[mid]) < 0)
			{
				max = mid - 1;
				mid = max / 2;
			}
			else
			{
				min = mid + 1;
				mid += (max - mid) / 2;
			}			
		}while(min <= mid);
		 
		 return - 1;
    }
       
    public static void main(String[] args)
    {
    	String[] strings1 = {"a", "b", "b", "c", "d", "d", "e", "e", "e", "f", "h", "i", "k", "k", "l", "m", "o", "p"};
    	//                    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17
    	String[] strings2 = {"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"};
    	//                    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17
    	System.out.println(firstIndexOf(strings2, "g", String.CASE_INSENSITIVE_ORDER));
    }		
}