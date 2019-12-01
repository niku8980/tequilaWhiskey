package rummy;
public class Card {

	public static final String[] RANKS = { null, " A", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K"}; 

	public static final String[] SUITS = { "C", "D", "H", "S" };
	
	public static final String[] JOKER= {"JOKER"}; 

	public static final String[] JKR = { "JOKERRR" };

	
	int rank;
	int suit;
	int jokerCard;
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Card(int rank)
	{
		jokerCard = rank;
	}
	
	public int getRank() {
		return rank ;
	}

	public void setCard(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}

	public String toString() {
		return RANKS[this.rank] + " " + SUITS[this.suit];
	}
}