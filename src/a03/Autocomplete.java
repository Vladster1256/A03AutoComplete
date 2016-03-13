package a03;

import java.util.Arrays;
import java.util.Collections;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.Quick;

public class Autocomplete
{

	private Term[] terms;

	// Initialize the data structure from the given array of terms.
	public Autocomplete(Term[] terms)
	{
		Arrays.sort(terms);
		this.terms = terms;
	}

	// Return all terms that start with the given prefix, in descending order of
	// weight.
	public Term[] allMatches(String prefix)
	{
		if (prefix == null)
		{
			throw new NullPointerException("Don't insert null's dude");
		} else
		{
			Term t = new Term(prefix, 0);
			Term[] returnable = null;
			int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			if (firstIndex == -1 || lastIndex == -1)
			{
				returnable = new Term[0];
				return returnable;
			} else
			{
				if(lastIndex > 1 && lastIndex > firstIndex)
				{
					returnable = new Term[lastIndex - firstIndex + 1];
				}
				else if(lastIndex == firstIndex)
				{
					returnable = new Term[1];
				}
				int incrementer = 0;
				for (int i = firstIndex; i <= lastIndex; i++)
				{
					returnable[incrementer] = terms[i];
					incrementer++;
				}
				MergeX.sort(returnable, Term.byReverseWeightOrder());
				return returnable;
			}
		}

	}

	// Return the number of terms that start with the given prefix.
	public int numberOfMatches(String prefix)
	{
		if (prefix == null)
		{
			throw new NullPointerException("Don't insert null's dude");
		} else
		{
			Term t = new Term(prefix, 0);
			int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			
			if(firstIndex == -1 || lastIndex == -1)
			{
				return 0;
			}
			if(lastIndex > 1 && lastIndex > firstIndex)
			{
				return lastIndex - firstIndex + 1;
			}
			else if(lastIndex == firstIndex)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	
//	public static void main(String[] args)
//	{
//		Term[] something = {new Term("Apple", 5), new Term("Something", 7798.987), new Term("Alright", 6787.7), new Term("Appetite", 67876.98), new Term("Air", 78.876)};
//		Autocomplete lel = new Autocomplete(something);
//		System.out.println(lel.numberOfMatches("zz"));
//		Term[] temp = (lel.allMatches("zz"));
//		for(Term item : temp)
//		{
//			System.out.println(item.toString());
//		}
//		System.out.println("Didn't freeze");
//	}
}