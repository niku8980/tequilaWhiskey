package rummy;
import java.util.*;

/**
 * This is a class which generates a deck for the game
 * @author Brandon Staton, Dillon Kilroy, Nick Patel
 * @version 1.0
 */

public class Deck {
	
	/**
	 * The deck which holds all 52 cards.
	 */
	
	Stack<Card> deck; 

	/**
	 * The constructor creates a new deck.
	 */
	
	public Deck() 
	{
		deck = new Stack<Card>();
	}

	/**
	 * This function creates a shuffled deck.
	 * @return A stack of shuffled deck.
	 */
	
	public Stack<Card> createDeck() {
		ArrayList<Card> deckArr = new ArrayList<Card>();
		
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deckArr.add(new Card(rank, suit));
			}
		}
		int min = 0;
		int n = deckArr.size();
		for (int i = 0; i < n; i++)
		{
			int r = min + (int) (Math.random() * (n - i));
			deck.push(deckArr.remove(r));
		}
		return deck;
	}

	/**
	 * This function pops a card from the deck stack.
	 * @return The card popped from the stack.
	 */
	
	public Card pop()
	{
		return deck.pop();
	}
	
	/**
	 * This function checks if the deck is empty
	 * @return True if the deck is empty, false otherwise.
	 */
	
	public boolean isEmpty()
	{
		return deck.isEmpty();
	}
	
	/**
	 * This functions pushes a card onto the stack of Cards.
	 * @param card The card to be pushed onto the stack.
	 */
	
	public void push(Card card)
	{
		deck.push(card);
	}
	
	/**
	 * This function returns the card on the top of the stack without deleting it.
	 * @return The card that is at the top of the stack.
	 */
	
	public Card peek()
	{
		return deck.peek();
	}
	
	/**
	 * Returns the number of components in the stack.
	 * @return The number of components in the stack.
	 */
	
	public int size()
	{
		return deck.size();
	}
	
//	/**
//	 * returns
//	 */
//	
//	/*public String toString() {
//		String s = new String();
//		int k = 0;
//
//		for (int i = 0; i < 4; i++) {
//			for (int j = 1; j <= 13; j++) {
//				s += (deck.get(k++) + " ");
//				s += "\n";
//			}
//			s += "\n";
//		}
//		return (s);
//	}
//	
//	/**
//	 * This function prints out all the cards in the deck.
//	 */
//	/*
//	public void printDeck()
//	{
//		for(Card c: deck)
//		{
//			System.out.print(c.toString() + " ");
//		}
//	}*/*/
}
