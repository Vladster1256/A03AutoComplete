package a03tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a03.BinarySearchDeluxe;

public class BinarySearchDeluxeTest
{
	String[] strings1 =
	{ "a", "a", "b", "c", "d", "d", "e", "e", "e", "f", "h", "i", "k", "k", "l", "m", "o", "p" };
	// 0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17
	String[] strings2 =
	{ "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s" };
	// 0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17
	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void testAllIndexesFirst()
	{
		for (int i = 0; i < strings2.length; i++)
		{
			int index = BinarySearchDeluxe.firstIndexOf(strings2, strings2[i], String.CASE_INSENSITIVE_ORDER);
			assertEquals(i, index);
		}
	}

	@Test
	public void testAllIndexesLast()
	{
		for (int i = 0; i < strings2.length; i++)
		{
			int index = BinarySearchDeluxe.lastIndexOf(strings2, strings2[i], String.CASE_INSENSITIVE_ORDER);
			assertEquals(i, index);
		}
	}

	@Test
	public void testFirstIndexOfA()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings1, "A", String.CASE_INSENSITIVE_ORDER);
		assertEquals(0, index);
	}

	@Test
	public void testLastIndexOfA()
	{
		int index = BinarySearchDeluxe.lastIndexOf(strings1, "A", String.CASE_INSENSITIVE_ORDER);
		assertEquals(1, index);
	}

	@Test
	public void testFirstIndexOfD()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings1, "d", String.CASE_INSENSITIVE_ORDER);
		assertEquals(4, index);
	}

	@Test
	public void testLastIndexOfD()
	{
		int index = BinarySearchDeluxe.lastIndexOf(strings1, "d", String.CASE_INSENSITIVE_ORDER);
		assertEquals(5, index);
	}

	@Test
	public void testFirstIndexOfE()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings1, "e", String.CASE_INSENSITIVE_ORDER);
		assertEquals(6, index);
	}

	@Test
	public void testLastIndexOfE()
	{
		int index = BinarySearchDeluxe.lastIndexOf(strings1, "e", String.CASE_INSENSITIVE_ORDER);
		assertEquals(8, index);
	}

}
