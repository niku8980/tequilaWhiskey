package rummy;

import static org.junit.Assert.*;
import org.junit.*;

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
