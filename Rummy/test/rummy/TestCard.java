package rummy;

import static org.junit.Assert.assertEquals;

import  org.junit.*;

public class TestCard {

	Card testCard;
	
	@Before
	public void init()
	{
		testCard = new Card(0,0);
	}
	
	@Test
	public void test() 
	{
		assertEquals(testCard.getRank(), 0);
		assertEquals(testCard.getSuit(), 0);
	}

}
