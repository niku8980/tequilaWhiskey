package rummy;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.junit.Test;

public class TestDeck {

	Deck testDeck;
	Stack<Card> testStack;
	
	@Before
	public void init()
	{
		testDeck = new Deck();
		testStack = new Stack<Card>();
		testStack = testDeck.createDeck();
	}
	
	@Test
	public void test() 
	{
		assertEquals(testDeck.size(), 52);
		assertTrue(testDeck.isEmpty() == false);
		assertTrue(testDeck.peek() == testDeck.peek());
	}

}
