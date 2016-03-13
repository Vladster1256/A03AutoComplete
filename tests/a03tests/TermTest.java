package a03tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import a03.Term;

public class TermTest {

	private List<Term> terms;
	
	private final Term their = new Term("their", 2820265.0);
	private final Term they = new Term("they", 3340398.0);
	private final Term there = new Term("there", 1961200.0);
	private final Term them = new Term("them", 2509917.0);
	private final Term thereby = new Term("thereby", 2446500.0);
	
	@Before
	public void setUp() throws Exception {
		terms = Arrays.asList(their, they, there, them, thereby);				
	}

	@Test(expected = NullPointerException.class)
	public void testTerm_nullQuery() {
		new Term(null, 1);
	}

	@Test(expected = IllegalArgumentException .class)
	public void testTerm_weightNegative() {
		new Term("negative", -1);
	}
	
	@Test
	public void testTerm() {
		Term automobile = new Term("automobile", 6197.0);
		assertEquals("6197.0\tautomobile", automobile.toString());
	}
		
	@Test
<<<<<<< HEAD
	public void testByReverseOrder() {
		String termsReverseWeightOrder = "[3340398.0\tthey, 2820265.0\ttheir, " +
				"2509917.0\tthem, 2446500.0\tthereby, 1961200.0\tthere]";
		Collections.sort(terms, Term.byReverseWeightOrder());
 
	    assertEquals(termsReverseWeightOrder, terms.toString());
	}

	@Test(expected = IllegalArgumentException .class)
	public void testByPrefixOrder_negativeR() {
		Term.byPrefixOrder(-1);
	}
	
	@Test
	public void testByPrefixOrder() {
		String termsPrefixOrder5 = "[2820265.0\ttheir, 2509917.0\tthem, " +
				"1961200.0\tthere, 2446500.0\tthereby, 3340398.0\tthey]";
		Collections.sort(terms, Term.byPrefixOrder(5));
 
	    assertEquals(termsPrefixOrder5, terms.toString());
	}

	@Test
	public void testCompareTo() {
		String termsNaturalOrder = "[2820265.0\ttheir, " +
			"2509917.0\tthem, 1961200.0\tthere, 2446500.0\tthereby, 3340398.0\tthey]";
		Collections.sort(terms);
 
	    assertEquals(termsNaturalOrder, terms.toString());
=======
	public void testNulls()
	{
		assertFalse(term == null);
>>>>>>> refs/remotes/origin/master
	}

	@Test
	public void testToString() {
		assertEquals("3340398.0\tthey", they.toString());
	}

}
