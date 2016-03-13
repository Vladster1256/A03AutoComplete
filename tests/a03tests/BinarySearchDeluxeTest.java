package a03tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a03.BinarySearchDeluxe;

public class BinarySearchDeluxeTest
{
	String[] strings = { "A", "b", "b", "b", "b", "c", "c", "d", "E" };

	@Before
	public void setUp() throws Exception
	{
		
	}

	@Test
	public void testFirstIndexOf()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings, "A", String.CASE_INSENSITIVE_ORDER);
		assertEquals(0, index);
	}
	
	@Test
	public void test4IndexOf()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings, "c", String.CASE_INSENSITIVE_ORDER);
		assertEquals(5, index);
	}

	@Test
	public void test()
	{
		fail("not yet implemented");
	}

}
