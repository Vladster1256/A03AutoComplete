package a03tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a03.Term;

public class TermTest
{
	Term term = new Term("Hello", 9001.123);
	Term term1 = new Term("Hi", 90.68);
	Term term2 = new Term("Previet", 80.67);
	Term term3 = new Term("Wow", 1.78);

	@Before
	public void setUp() throws Exception
	{
		
	}

	@Test
	public void testNulls()
	{
		assertFalse(term == null);
	}	
}
