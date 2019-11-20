import java.util.*;
import java.io.*;

public class Card {

	public static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

	int rank;
	int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getCard() {
		return rank;
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
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}
}
