/*******************************************************************************
 * Copyright (C) 2019 Brandon Staton, Dillon Kilroy, Nikunj Patel
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
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
