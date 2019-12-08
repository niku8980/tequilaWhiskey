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
import java.util.*;

/**
 * This is a class which generates a deck for the game
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

public class Deck 
{
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
}
