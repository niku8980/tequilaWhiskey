package rummy;

/**
 * This is a class for each Card in a deck
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

public class Card {

	/**
	 * The ranks of the cards
	 */
	
	public static final String[] RANKS = { null, " A", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K"}; 

	/**
	 * The suits of the cards
	 */
	
	public static final String[] SUITS = { "C", "D", "H", "S" };
	
	/**
	 * The rank of a card
	 */
		
	int rank;
	
	/**
	 * The suit of a card
	 */
	
	int suit;
	
	/**
	 * The constructor creates the card of a specific rank and suit. 
	 * @param rank The rank of the card
	 * @param suit The suit of the card
	 */
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * It return the rank of the card
	 * @return The rank of a card
	 */
	
	public int getRank() {
		return rank ;
	}

	/**
	 * This function sets the rank of a card.
	 * @param rank A rank of a class 
	 */
	
	public void setCard(int rank) {
		this.rank = rank;
	}
	
	/**
	 * It returns the suit of a card
	 * @return The suit of a card
	 */

	public int getSuit() {
		return suit;
	}

	/**
	 * This function sets the suit of a card.
	 * @param suit The suit of the card
	 */
	
	public void setSuit(char suit) {
		this.suit = suit;
	}

	/**
	 * Returns the textual representation of a card
	 * @return A string of a card's rank and suit.
	 */
	
	public String toString() {
		return RANKS[this.rank] + " " + SUITS[this.suit];
	}
}
