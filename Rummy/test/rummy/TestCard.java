package rummy;

import static org.junit.Assert.assertEquals;

import  org.junit.*;

/**
 * This class is a test case for the Card class.
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

public class TestCard {

	/**
	 * A sample test object of test class
	 */
	
	Card testCard;
	
	/**
	 * Initialize the object to be tested 
	 */
	
	@Before
	public void init()
	{
		testCard = new Card(0,0);
	}
	
	/**
	 * The test for all the functions in the Card class
	 */
	
	@Test
	public void test() 
	{
		assertEquals(testCard.getRank(), 0);
		assertEquals(testCard.getSuit(), 0);
	}

}
