package rummy;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.junit.Test;

/**
 * The test case for the Deck class
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

public class TestDeck {

	/**
	 * A sample deck to be tested
	 */
	
	Deck testDeck;
	
	/**
	 * The following stack holds the shuffled deck.
	 */
	
	Stack<Card> testStack;
	
	/**
	 * The initialization of the variables of the test case.
	 */
	
	@Before
	public void init()
	{
		testDeck = new Deck();
		testStack = new Stack<Card>();
		testStack = testDeck.createDeck();
	}
	
	/**
	 * The test for all the functions in the deck class.
	 */
	
	@Test
	public void test() 
	{
		assertEquals(testDeck.size(), 52);
		assertTrue(testDeck.isEmpty() == false);
		assertTrue(testDeck.peek() == testDeck.peek());
	}

}
