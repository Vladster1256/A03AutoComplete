package a03;

import java.util.Arrays;

public class Autocomplete
{

	private Term[] terms;

	// Initialize the data structure from the given array of terms.
	public Autocomplete(Term[] terms)
	{
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
			Term[] returnable;
			int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));

			returnable = new Term[lastIndex - firstIndex];
			for (int i = firstIndex; i <= lastIndex; i++)
			{
				returnable[i] = terms[i];
			}
			Arrays.sort(returnable, Term.byReverseWeightOrder());
			return returnable;
		}

	}

	// Return the number of terms that start with the given prefix.
	public int numberOfMatches(String prefix)
	{
		if(prefix == null)
		{
			throw new NullPointerException("Don't insert null's dude");
		}
		else
		{
			Term t = new Term(prefix, 0);
			int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
			return lastIndex-firstIndex;
		}
	}
}