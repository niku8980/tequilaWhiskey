package rummy;

import static org.junit.Assert.*;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.*;
public class TestPlayer {

	static Player testPlayer;
	
	@Before
	public  void init()
	{
		testPlayer = new Player();
		testPlayer.playerID  = 1;
		testPlayer.playerName  = "testPlayer";
		testPlayer.playerScore  = 0;
	} 
	
	@Test
	public void test() {
		assertEquals(testPlayer.getPlayerID(),1);
		assertEquals(testPlayer.getPlayerName(), "testPlayer");
		assertEquals(testPlayer.getPlayerScore(), 0);
	}

}
