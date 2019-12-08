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
