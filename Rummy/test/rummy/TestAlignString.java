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

import static org.junit.Assert.assertEquals;

import org.junit.*;

/**
 * This class test the AlignString class and its functions.
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

public class TestAlignString {

	/**
	 * Variables required for the function testing
	 */
	
	AlignString leftPlayer;
	AlignString centerPlayer;
	AlignString rightPlayer;
	AlignString rightCard;
	AlignString centerCard;
	AlignString leftCard;
	String string;
		
	/**
	 * This function sets up the the variables for testing
	 */
	
	@Before
	public void init()
	{
		string = "testCase";									// string length = 8
		leftPlayer = new AlignString(50, "LEFTPLAYER");			// the length of the entire line = 50
		centerPlayer =  new AlignString(50, "CENTERPLAYER");
		rightPlayer = new AlignString(50, "RIGHTPLAYER");
		rightCard = new AlignString(50, "RIGHTCARD");
		centerCard = new AlignString(50, "CENTERCARD");
		leftCard = new AlignString(50, "LEFTCARD");
	}
	
	/**
	 * This is the function test which tests all the functions in the AlignString class.
	 */
	
	@Test
	public void test() 
	{
		assertEquals(centerPlayer.format(string).length(), 27);
		assertEquals(rightPlayer.format(string).length(), 9);
		assertEquals(rightCard.format(string).length(), 9);
		assertEquals(centerCard.format(string).length(), 11);
	}
}
