package rummy;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestAlignString {

	AlignString leftPlayer;
	AlignString centerPlayer;
	AlignString rightPlayer;
	AlignString rightCard;
	AlignString centerCard;
	AlignString leftCard;
	String string;
		
	@Before
	public void init()
	{
		string = "testCase";
		leftPlayer = new AlignString(50, "LEFTPLAYER");
		centerPlayer =  new AlignString(50, "CENTERPLAYER");
		rightPlayer = new AlignString(50, "RIGHTPLAYER");
		rightCard = new AlignString(50, "RIGHTCARD");
		centerCard = new AlignString(50, "CENTERCARD");
		leftCard = new AlignString(50, "LEFTCARD");
	}
	
	@Test
	public void test() 
	{
		assertEquals(leftPlayer.format(string).length(), 60);
		assertEquals(centerPlayer.format(string).length(), 59);
		assertEquals(rightPlayer.format(string).length(), 9);
		assertEquals(rightCard.format(string).length(), 9);
		assertEquals(leftCard.format(string).length(), 10);
		assertEquals(centerCard.format(string).length(), 35);
	}
}
