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
package tequilaWhiskey;

import static org.junit.Assert.*;
import org.junit.*;

import tequilaWhiskey.Player;

 /**
 * This class is a test case for the player class
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0 
 * */


public class TestPlayer {

	/**
	 * The test player to be tested
	 */
	
	static Player testPlayer;
	
	/**
	 * Initialize the object to be tested
	 */
	
	@Before
	public  void init()
	{
		testPlayer = new Player();
		testPlayer.playerID  = 1;
		testPlayer.playerName  = "testPlayer";
		testPlayer.playerScore  = 0;
	} 
	
	/**
	 * The test for all the functions in the Player class.
	 */
	
	@Test
	public void test() {
		assertEquals(testPlayer.getPlayerID(),1);
		assertEquals(testPlayer.getPlayerName(), "testPlayer");
		assertEquals(testPlayer.getPlayerScore(), 0);
	}

}
