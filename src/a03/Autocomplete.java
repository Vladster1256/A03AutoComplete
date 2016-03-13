package a03;

import edu.princeton.cs.algs4.MergeX;

public class Autocomplete {

	private Term[] terms;
	
    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms)
    {
    	MergeX.sort(terms);
    	this.terms = terms;
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix)
    {
    	int firstIndex, lastIndex, numberOfMatches;
    	Term key = new Term(prefix, 0.0);
    	numberOfMatches = numberOfMatches(prefix);
    	Term[] result;
    	if(numberOfMatches <= 0)
    	{
    		result = new Term[0];
    		return result;
    	}else
    	{
    		result = new Term[numberOfMatches];
    	}
    	
    	firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(prefix.length()));
    	lastIndex = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(prefix.length()));
    	
    	int rIndex = 0;
    	
    	for(int i = firstIndex; i <= lastIndex; i++)
    	{
    		result[rIndex++] = terms[i];
    	}
    	
    	return result;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)
    {
    	int firstIndex, lastIndex;
    	Term key = new Term(prefix, 0.0);
    	
    	firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(prefix.length()));
    	lastIndex = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(prefix.length()));
    	if(firstIndex < 0 || lastIndex < 0)
    		return 0;
    	else
    		return lastIndex - firstIndex + 1;
    }
}