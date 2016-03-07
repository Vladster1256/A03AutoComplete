package a03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchDeluxeTest
{
	String[] strings = {"A", "b", "b", "b", "c", "c", "D", "e"};
	@Before
	public void setUp() throws Exception
	{
		
	}

	@Test
	public void testFirstIndexOfC()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings, "c", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(4, index);
	}
	
	@Test
	public void testFirstIndexOfB()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings, "b", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(1, index);
	}
	
	@Test
	public void testFirstIndexOfA()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings, "A", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(0, index);
	}
	
	@Test
	public void testLastIndexOf()
	{
		fail("Not yet implemented");
	}

}
