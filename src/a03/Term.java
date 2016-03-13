package a03;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Monte
 *
 */

public class Term implements Comparable<Term>
{

	private final String query;
	private final double weight;

	// Initialize a term with the given query string and weight.
	public Term(String query, double weight) throws NullPointerException, IllegalArgumentException
	{
		if(query == null)
			throw new NullPointerException("query cannot equal null");
		else if(weight < 0.0)
			throw new IllegalArgumentException("weight cannot be negative");
		
		this.query = query;
		this.weight = weight;
	}

	// Compare the terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder()
	{
		return new ReverseWeightOrder();

	}

	// Compare the terms in lexicographic order but using only the first r
	// characters of each query.
	public static Comparator<Term> byPrefixOrder(int r) throws IllegalArgumentException
	{
		if(r < 0)
			throw new IllegalArgumentException("r cannot be negative");
		return new PrefixOrder(r);
	}

	// Compare the terms in lexicographic order by query.
	public int compareTo(Term that)
	{
		return query.compareToIgnoreCase(that.query);

	}

	// Return a string representation of the term in the following format:
	// the weight, followed by a tab, followed by the query.
	public String toString()
	{
		return weight + "\t" + query;
	}

	private static class ReverseWeightOrder implements Comparator<Term>
	{
		@Override
		public int compare(Term o1, Term o2)
		{
			double result = o1.weight - o2.weight;
			return (int)result * -1;
		}
	}
	
	private static class PrefixOrder implements Comparator<Term>
	{
		private int n1, n2;
		
		public PrefixOrder(int r)
		{
			n1 = r;
			n2 = r;
		}
		
		@Override
		public int compare(Term o1, Term o2)
		{
			if(n1 > o1.query.length())
				n1 = o1.query.length();
			if(n2 > o2.query.length())
				n2 = o2.query.length();
			return o1.query.substring(0, n1).compareToIgnoreCase(o2.query.substring(0, n2));
		}
	}

	public static void main(String[] args)
	{
		Term[] t = {new Term("China",123.01), new Term("Japan",123.02), new Term("Korea",124.011), new Term("Canada",213.078), new Term("Mexico",210.95)};

		StdOut.println("Default: " + Arrays.toString(t));
		
		Arrays.sort(t, byReverseWeightOrder());
		
		StdOut.println("Reverse Weight Sort: " + Arrays.toString(t));
		
		Arrays.sort(t, byPrefixOrder(2));
		
		StdOut.println("Prefix Sort: " + Arrays.toString(t));
	}
}