import java.util.*;
import java.io.*;

public class Deck {
	//Stack<Card> deck = new Stack<Card>();
	Stack<Card> deck;
	public Deck() 
	{
		//this.createDeck();
		deck = new Stack<Card>();
		
	}
	
	public Deck(int numberOfPlayers)
	{
		
	}

	public Stack<Card> createDeck() {
		ArrayList<Card> deckArr = new ArrayList<Card>();
		//Stack<Card> shuffledDeck = new Stack<Card>();
		int idx = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				//int i = 0;
				deckArr.add(new Card(rank, suit));
				//System.out.println("added : " + deckArr.get(idx));
				idx++;
			}
		}
		int min = 0;
		int n = deckArr.size();
		for (int i = 0; i < n; i++)
		{
			int r = min + (int) (Math.random() * (n - i));
			deck.push(deckArr.remove(r));
			//System.out.println("printing from shuffled deck: " + shuffledDeck.get(i));
		}
		return deck;
	}

	public Card pop()
	{
		return deck.pop();
	}
	
	public boolean isEmpty()
	{
		return deck.isEmpty();
	}
	
	public void push(Card card)
	{
		deck.push(card);
	}
	
	public String toString() {
		String s = new String();
		int k = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				s += (deck.get(k++) + " ");
				s += "\n";
			}
			s += "\n";
		}
		return (s);
	}
	
	public void printDeck()
	{
		for(Card c: deck)
		{
			System.out.println(c.toString() + " ");
		}
	}
}
