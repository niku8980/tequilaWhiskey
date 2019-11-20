import java.util.*;
import java.io.*;

public class Deck {
	Stack deck = new Stack();

	Card[] deckArr;

	public Deck() {

		deckArr = new Card[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deckArr[index] = new Card(rank, suit);
				index++;
			}
		}

//********************STACK DECK************************
//		int index = 0;
//		for (int suit = 0; suit <= 3; suit++) {
//		    for (int rank = 1; rank <= 13; rank++) {
//		        deck.push(new Card(rank, suit));
//		        index++;
//		    }
//		}
	}

//    public String toString()
//    {
// 	 String s = "";
// 	 int k;
// 	 k = 0;
// 	 for ( int i = 0; i < 4; i++ )
// 	 {
// 	    for ( int j = 1; j <= 13; j++ ) {
// 	    	s += (deck.peek() + " ");
// 	    	s += "\n";
// 	    }
// 	    s += "\n";
// 	 }
// 	 return ( s );
//    }

	public String toString() {
		String s = "";
		int k;

		k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				s += (deckArr[k++] + " ");
				s += "\n";
			}
			s += "\n";
		}
		return (s);
	}
}
