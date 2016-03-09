package a03tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a03.BinarySearchDeluxe;

public class BinarySearchDeluxeTest
{
	String[] strings1 = {"a", "a", "b", "c", "d", "d", "e", "e", "e", "f", "h", "i", "k", "k", "l", "m", "o", "p"};
	//                    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17
	String[] strings2 = {"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"};
	//                    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17
	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void testFirstIndexOf()
	{
		int index = BinarySearchDeluxe.firstIndexOf(strings2, "s", String.CASE_INSENSITIVE_ORDER);
		assertEquals(17, index);
	}
	
	@Test
	public void testLastIndexOf()
	{
		int index = BinarySearchDeluxe.lastIndexOf(strings2, "b", String.CASE_INSENSITIVE_ORDER);
		assertEquals(0, index);
	}

	@Test
	public void testAllIndexesFirst()
	{
		for(int i = 0; i < strings2.length; i++)
		{
			System.out.println("Index: " + i + " Value: " + strings2[i]);
			int indexF = BinarySearchDeluxe.firstIndexOf(strings2, strings2[i], String.CASE_INSENSITIVE_ORDER);
			System.out.println("Result: " + indexF);
			if(indexF != i)
				fail();
		}
	}

}
