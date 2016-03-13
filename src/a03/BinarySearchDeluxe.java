package a03;

import java.util.Comparator;

/**
 * 
 * @author Monte Swapp
 *
 */
public class BinarySearchDeluxe {

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) throws NullPointerException
    {
    	if(key == null)
    		throw new NullPointerException("cannot search for null element");
		int min = 0;
		int max = a.length - 1;
		int mid = min + (max - min) / 2;
		
		if(comparator.compare(key, a[min]) < 0 || comparator.compare(key, a[max]) > 0)
			return - 1;
		else if(comparator.compare(key, a[min]) == 0)
			return min;
		else if(comparator.compare(key, a[max]) == 0 && comparator.compare(key, a[max - 1]) > 0)
			return max;
		
		 do
		{
			if(comparator.compare(key, a[mid]) == 0 && comparator.compare(key, a[mid - 1]) > 0)
			{
				return mid;
			}
			else if(comparator.compare(key, a[mid]) <= 0)
			{
				max = mid;
			}
			else if(comparator.compare(key, a[mid]) > 0)
			{
				min = mid;
			}else
			{
				max--;
			}
			
			mid = min + (max - min) / 2;
			
		}while(min != mid && max != mid);
		 
		 return - 1;
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) throws NullPointerException
    {
    	if(key == null)
    		throw new NullPointerException("cannot search for null element");
		int min = 0;
		int max = a.length - 1;
		int mid = min + (max - min) / 2;

		if(comparator.compare(key, a[min]) < 0 || comparator.compare(key, a[max]) > 0)
			return - 1;
		else if(comparator.compare(key, a[max]) == 0)
			return max;
		else if(comparator.compare(key, a[min]) == 0 && comparator.compare(key, a[min + 1]) < 0)
			return min;
				
		 do
		{
			if(comparator.compare(key, a[mid]) == 0 && comparator.compare(key, a[mid + 1]) < 0)
			{
				return mid;
			}
			else if(comparator.compare(key, a[mid]) < 0)
			{
				max = mid;
			}
			else if(comparator.compare(key, a[mid]) >= 0)
			{
				min = mid;
			}
			
			mid = min + (max - min) / 2;
			
		}while(min != mid && max != mid);
		 
		 return - 1;
    }	
}