package rummy;

import java.util.*;

/**
 * This class generates a game and makes the game playable.
 * 
 * @author Brandon Staton, Dillon Kilroy, Nick Patel
 * @version 1.0
 */

public class Game {
	/**
	 * The number of players in the game.
	 */
	static int numberOfPlayers;

	/**
	 * Current heightst score for score cap.
	 */

	static int heighestScore;

	/**
	 * The parameter is set to true if option to play with high is selected, false
	 * otherwise.
	 */

	static boolean aceHigh;

	/**
	 * The score cap of the game.
	 */

	static int scoreCap;

	/**
	 * The queue of players.
	 */

	static Queue<Player> players;

	/**
	 * The player input scanner during the game play
	 */

	static Scanner playerInput;

	/**
	 * The pile where all teh discarded cards are stored.
	 */

	static ArrayList<Card> discardPile;

	/**
	 * 
	 */

	static Deck shuffledDeck = new Deck();
	static Player currentPlayer;

	AlignString leftJustifyPlayer;
	AlignString centerJustifyPlayer;
	AlignString rightJustifyPlayer;
	AlignString leftJustifyCard;
	AlignString centerJustifyCard;
	AlignString rightJustifyCard;

	/**
	 * The constructer creates a game.
	 */

	public Game() {
		numberOfPlayers = 0;
		scoreCap = 0;
		heighestScore = 0;
		players = new LinkedList<Player>();
		playerInput = new Scanner(System.in);
		leftJustifyPlayer = new AlignString(200, "LEFTPLAYER");
		centerJustifyPlayer = new AlignString(200, "CENTERPLAYER");
		rightJustifyPlayer = new AlignString(200, "RIGHTPLAYER");
		rightJustifyCard = new AlignString(200, "RIGHTCARD");
		leftJustifyCard = new AlignString(200, "LEFTCARD");
		centerJustifyCard = new AlignString(200, "CENTERCARD");
		discardPile = new ArrayList<Card>();
		currentPlayer = new Player();

	}

	void setUpGame() // playGame()
	{
		welcomeScreen();
		getGameInfo();
		setUpPlayers();
		distributeCards();

		while (heighestScore <= scoreCap) {
			System.out.println("begining of while loop");
			displayTable();
			displayOptions();
			displayTurn();
			nextTurn();
			clearConsole();
			
			System.out.println(
					"=====================================================================================================================");
			System.out.println("Heighest score: " + heighestScore);
			System.out.println("Score cap: " + scoreCap);
			System.out.println("end of while loop");
		}

		System.out.println("The game has ended!!");
	}

	/**
	 * This function prints the welcome message on the screen.
	 */

	public void welcomeScreen() {
		System.out.print("\tWelcome to the rummy: \n");
		System.out.println("\tThis game could be played by upto 4: ");
		System.out.println("\n\tOkay! Enough of it. lets dive in setting up the game...");
	}

	/**
	 * This function gets the information from the player about the game.
	 */

	public void getGameInfo() {
		System.out.print("\n\tCan you please enter number of players: ");
		numberOfPlayers = playerInput.nextInt();

		while (numberOfPlayers > 4 || numberOfPlayers < 2) {
			System.out.println("\tWooooowooow!!! Players must be between 2 - 4...");
			System.out.print("1\tCan you please enter number of players: ");
			numberOfPlayers = playerInput.nextInt();
		}

		System.out.print("\tHow about the score cap: ");
		scoreCap = playerInput.nextInt();

		System.out.println("\tAlright! Now lets set up players profile...\n");
	}

	/**
	 * This function sets up the player profiles.
	 */

	public void setUpPlayers() {
		for (int i = 0; i < numberOfPlayers; i++) {
			int playerID = i;
			Player player = new Player();
			System.out.print("\tPlease enter player " + (playerID + 1) + "'s name : ");
			player.playerName = playerInput.next();
			player.playerID = playerID;
			players.add(player);
			playerID++;
		}
		System.out.println();
	}

	/**
	 * This function distributes the cards to all the players from the deck.
	 */

	public void distributeCards() {
		shuffledDeck.createDeck();
		Player tempPlayer = new Player();
		Card tempCard = new Card(0, 0);
		int cardsToBeDealt = 0;

		if (numberOfPlayers == 2)
			cardsToBeDealt = 20;
		else if (numberOfPlayers == 3)
			cardsToBeDealt = 21;
		else
			cardsToBeDealt = 28;

		while (cardsToBeDealt != 0) {
			tempPlayer = players.peek();
			tempCard = shuffledDeck.pop();
			tempPlayer.hand.add(tempCard);
			players.add(players.poll());
			cardsToBeDealt--;
		}
	}

	public void resetGame() {
		Player currentPlayer = new Player();
		for (int i = 0; i < numberOfPlayers; i++) {
			currentPlayer = players.peek();
			currentPlayer.hand = new ArrayList<Card>();
			currentPlayer.laidDown = new ArrayList<Card>();
			players.add(players.poll());
		}
		discardPile = new ArrayList<Card>();
		distributeCards();
		displayTable();
	}

	/**
	 * This function displays the game table.
	 */

	public void displayTable() {
		if (numberOfPlayers == 2)
			displayTableForTwoPlayers();
		else if (numberOfPlayers == 3)
			displayTableForThreePlayers();
		else
			displayTableForFourPlayers();

	}

	/**
	 * This function displays the table if there are two players in the game.
	 */

	public void displayTableForTwoPlayers() {
		players.add(players.poll());
		currentPlayer = players.peek();
		printPlayerInfoCenter(currentPlayer);

		printDeckAndDiscard();

		players.add(players.poll());
		currentPlayer = players.peek();
		printCurrentPlayerInfo(currentPlayer);

	}

	/**
	 * This function prints the player information in the center.
	 * 
	 * @param p The player whose information is to be printed.
	 */
	public void printPlayerInfoCenter(Player p) {
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(centerJustifyPlayer.format((playerID) + ".  " + playerName));
		System.out.println(centerJustifyPlayer.format(p.getPlayerName() + "'s score: " + p.getPlayerScore()));
		System.out.println(centerJustifyPlayer.format("Laid down cards: "));
		int i = 1;
		for (Card c : p.laidDown) {
			if (i < 10)
				System.out.print(centerJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function prints the player information to the right
	 * 
	 * @param p The player whose information is to be printed.
	 */

	public void printPlayerInfoRight(Player p) {
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(rightJustifyPlayer.format((playerID) + ".  " + playerName));

		System.out.println(rightJustifyPlayer.format("Laid down"));
		int i = 1;
		for (Card c : p.laidDown) {
			System.out.print(rightJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function prints the player information to the left
	 * 
	 * @param p The player whose information is to be printed.
	 */

	public void printPlayerInfoLeft(Player p) {
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(leftJustifyPlayer.format((playerID) + ".  " + playerName));
		System.out.println(leftJustifyPlayer.format(p.getPlayerName() + "'s score: " + p.getPlayerScore()));
		System.out.println(leftJustifyPlayer.format("Laid down"));
		int i = 1;
		for (Card c : p.laidDown) {
			System.out.print(leftJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function prints the current player's information
	 * 
	 * @param p The current player
	 */

	public void printCurrentPlayerInfo(Player p) {
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(centerJustifyPlayer.format((playerID) + ".  " + playerName));
		System.out.println(centerJustifyPlayer.format(p.getPlayerName() + "'s score: " + p.getPlayerScore()));
//		System.out.println();
		System.out.println(centerJustifyPlayer.format("Laid down cards: "));
		int i = 1;
		for (Card c : p.laidDown) {
			System.out.print(centerJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
		System.out.println();
		System.out.println(centerJustifyPlayer.format("Cards in hand: "));
		i = 1;

		sortHand(p.hand);

		for (Card c : p.hand) {
			if (i < 10)
				System.out.print(centerJustifyCard.format(i + "....| " + c.toString() + "  | "));
			else
				System.out.print(centerJustifyCard.format(i + "...| " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function displays the table if there were three players in the game
	 */

	public void displayTableForThreePlayers()

	{
		// players.add(players.poll());
		players.add(players.poll());

		currentPlayer = players.peek();

		printPlayerInfoLeft(currentPlayer);

		// players.add(players.poll());
		players.add(players.poll());

		currentPlayer = players.peek();

		printPlayerInfoRight(currentPlayer);

		printDeckAndDiscard();

		// players.add(players.poll());
		players.add(players.poll());

		currentPlayer = players.peek();

		printCurrentPlayerInfo(currentPlayer);
	}

	/**
	 * This function displays the table if there were 4 playes in the game.
	 */

	public void displayTableForFourPlayers() {
		players.add(players.poll());
		players.add(players.poll());

		currentPlayer = players.peek();

		printPlayerInfoCenter(currentPlayer);

		players.add(players.poll());
		players.add(players.poll());
		players.add(players.poll());

		currentPlayer = players.peek();

		printPlayerInfoLeft(currentPlayer);

		printDeckAndDiscard();

		players.add(players.poll());
		players.add(players.poll());

		currentPlayer = players.peek();

		printPlayerInfoRight(currentPlayer);

		players.add(players.poll());

		currentPlayer = players.peek();

		printCurrentPlayerInfo(currentPlayer);
	}

	/**
	 * This function prints the options available to the current player.
	 */

	public void displayOptions() {
		int option = 0;
		System.out.println("\n1.  Pick up from Deck.");
		System.out.println("2.  Pick up from discard pile.");
		option = playerInput.nextInt();
		if (option == 1) {
			draw(currentPlayer.hand);
			System.out.println();
		} else {
			drawFromDiscard(currentPlayer.hand);
		}
	}

	/**
	 * This function prints the deck and the discard pile on the game table.
	 */

	public void printDeckAndDiscard() {
		System.out.println();
		System.out.print(centerJustifyPlayer.format("========================"));
		System.out.print(centerJustifyPlayer.format("|  Deck: | X |         |"));
		System.out.print(centerJustifyPlayer.format("|  Deck has " + (shuffledDeck.size() + 1) + " card(s) |"));
		System.out.print(centerJustifyPlayer.format("|                      |"));
		System.out.print(centerJustifyPlayer.format("|  Discarded Cards:    |"));

		int i = 1;

		for (Card c : discardPile) {
			if (i < 10)
				System.out.print(centerJustifyCard.format("|  " + i + "....| " + c.toString() + "  |      | "));
			else
				System.out.print(centerJustifyCard.format("|  " + i + "...| " + c.toString() + "  |      | "));
			i++;
		}
		System.out.print(centerJustifyPlayer.format("========================"));

		System.out.println("\n");
	}

	/**
	 * This function displays the turn.
	 */

	public void displayTurn() {
		int option = 0;
		int oldSize = 0, newSize = 0;
		do
		{
			System.out.println("\n1. Make a run.");
			// System.out.println("2. Follow a run");
			System.out.println("2.  Discard a card.");
			option = playerInput.nextInt();
			if (option == 1) 
			{
				if (isRun(currentPlayer.hand)) {
					oldSize = currentPlayer.laidDown.size();
					currentPlayer.laidDown.addAll(suitRun(currentPlayer.hand));
					newSize = currentPlayer.laidDown.size();
					currentPlayer.playerScore += (newSize - oldSize) * 5;
					if (heighestScore < currentPlayer.getPlayerScore())
						heighestScore = currentPlayer.getPlayerScore();
					displayTable();
				}
				else 
				{
					System.out.println("A run is not possible with cards in your hand!");
				}
			}			
		}while(option != 2);
		
			discard(currentPlayer.hand);
	}

	/**
	 * This function lets the player make a run
	 * 
	 * @param hand The hand of the current player
	 * @return Returns an arrayList of the cards that could be laid down by a player
	 */

	public ArrayList<Card> suitRun(ArrayList<Card> hand) {
		int numberOfCards = 0;
		int cardNumber = 0;
		ArrayList<Card> runCards = new ArrayList<Card>();

		do {
			numberOfCards = 0;
			cardNumber = 0;
			runCards = new ArrayList<Card>();
			int option = 0;
			System.out.println("1.  Do a match run.");
			System.out.println("2.  Do a suit run.");
			System.out.print("Input: ");
			option = playerInput.nextInt();
			do {
				System.out.print("Please enter the number of cards you want to lay down: ");
				numberOfCards = playerInput.nextInt();
				if (numberOfCards < 3)
					System.out.println("Number of cards to be laid down must be more than 2");
			} while (numberOfCards < 3);

			for (int i = 0; i < numberOfCards; i++) {
				System.out.println("Enter card number: ");
				cardNumber = playerInput.nextInt() - 1;
				runCards.add(hand.get(cardNumber));
			}
			if (option == 1) {
				checkMatchRun(runCards);
				if (checkMatchRun(runCards)) {
					for (Card c : runCards) {
						hand.remove(c);
					}
					break;
				} else
					System.out.println("No possible match run with selected cards!");
			} else if (option == 2) {
				checkSuitRun(runCards);
				if (checkSuitRun(runCards)) {
					for (Card c : runCards) {
						hand.remove(c);
					}
					break;
				} else
					System.out.println("No possible suit run with selected cards!");
			}

			sortHand(hand);

		} while (!checkSuitRun(runCards) || !checkMatchRun(runCards));

		return runCards;
	}

	/**
	 * This function checks if the given cards are a possible run
	 * 
	 * @param hand The hand to be checked for a potential run
	 * @return True if there is a run, false otherwise.
	 */

	public boolean checkMatchRun(ArrayList<Card> hand) {
		// match run check

		for (int i = 0; i < hand.size() - 2; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()
					&& hand.get(i).getRank() == hand.get(i + 2).getRank())
				continue;
			else if (hand.get(i).getRank() != hand.get(i + 1).getRank()
					|| hand.get(i).getRank() != hand.get(i + 2).getRank())
				return false;
		}

		return true;
	}

	public boolean checkSuitRun(ArrayList<Card> hand) {

		for (int i = 0; i < hand.size() - 2; i++) {
			if (hand.get(i).getSuit() == hand.get(i + 1).getSuit()
					&& hand.get(i).getSuit() == hand.get(i + 2).getSuit())
				continue;
			else if (hand.get(i).getSuit() != hand.get(i + 1).getSuit()
					|| hand.get(i).getSuit() != hand.get(i + 2).getSuit())
				return false;
		}

		boolean check1 = false;
		boolean check2 = true;
		ArrayList<Card> clubCards = new ArrayList<Card>();
		ArrayList<Card> spadeCards = new ArrayList<Card>();
		ArrayList<Card> diamondCards = new ArrayList<Card>();
		ArrayList<Card> heartCards = new ArrayList<Card>();

		for (Card c : hand) {
			if (c.getSuit() == 0) // add club cards to arraylist
			{
				clubCards.add(c);
				sortHand(clubCards);
			} else if (c.getSuit() == 1) // add all diamond cards to the arraylist
			{
				diamondCards.add(c);
				sortHand(diamondCards);
			} else if (c.getSuit() == 2) // add all heart cards to the arraylist
			{
				heartCards.add(c);
				sortHand(heartCards);
			} else // add all spade cards to the arraylist
			{
				spadeCards.add(c);
				sortHand(spadeCards);
			}
		}

		if (clubCards.size() > 2) {
			for (int i = 0; i < clubCards.size() - 2; i++) {
				if ((clubCards.get(i + 1).getRank() - clubCards.get(i).getRank()) != 1
						|| (clubCards.get(i + 2).getRank() - clubCards.get(i).getRank()) != 2)
					return false;
			}

//			if(check1)
//			{
//				for(int i = 0; i < hand.size()-1; i++)
//				{
//					if(hand.get(i).getSuit() != hand.get(i + 1).getSuit())
//						check2 = false;
//				}
//			}	
		}

		if (diamondCards.size() > 2) {
			for (int i = 0; i < diamondCards.size() - 2; i++) {
				if ((diamondCards.get(i + 1).getRank() - diamondCards.get(i).getRank()) != 1
						|| (diamondCards.get(i + 2).getRank() - diamondCards.get(i).getRank()) != 2)
					return false;
			}

//			if(check1)
//			{
//				for(int i = 0; i < hand.size()-1; i++)
//				{
//					if(hand.get(i).getSuit() != hand.get(i + 1).getSuit())
//						check2 = false;
//				}
//			}	
//			
//			if(check2)
//				return true;
		}

		if (heartCards.size() > 2) {
			for (int i = 0; i < heartCards.size() - 2; i++) {
				if ((heartCards.get(i + 1).getRank() - heartCards.get(i).getRank()) != 1
						|| (heartCards.get(i + 2).getRank() - heartCards.get(i).getRank()) != 2)
					return false;
			}

//			if(check1)
//			{
//				for(int i = 0; i < hand.size()-1; i++)
//				{
//					if(hand.get(i).getSuit() != hand.get(i + 1).getSuit())
//						check2 = false;
//				}
//			}	
//			
//			if(check2)
//				return true;
		}

		if (spadeCards.size() > 2) {
			for (int i = 0; i < spadeCards.size() - 2; i++) {
				if ((spadeCards.get(i + 1).getRank() - spadeCards.get(i).getRank()) != 1
						|| (spadeCards.get(i + 2).getRank() - spadeCards.get(i).getRank()) != 2)
					return false;
			}
			/*
			 * if(check1) { for(int i = 0; i < hand.size()-1; i++) {
			 * if(hand.get(i).getSuit() != hand.get(i + 1).getSuit()) check2 = false; } }
			 * 
			 * if(check2) return true;
			 */
		}

		return true;
	}

	public boolean isRun(ArrayList<Card> hand) {
		// match run check
		for (int i = 0; i < hand.size() - 2; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
				if (hand.get(i).getRank() == hand.get(i + 2).getRank())
					return true;
//				else
//					return false;
			}
//			else
//				return false;
		}

		// suit run check

		ArrayList<Card> clubCards = new ArrayList<Card>();
		ArrayList<Card> spadeCards = new ArrayList<Card>();
		ArrayList<Card> diamondCards = new ArrayList<Card>();
		ArrayList<Card> heartCards = new ArrayList<Card>();

		for (Card c : hand) {
			if (c.getSuit() == 0) // add club cards to arraylist
			{
				clubCards.add(c);
				sortHand(clubCards);
			} else if (c.getSuit() == 1) // add all diamond cards to the arraylist
			{
				diamondCards.add(c);
				sortHand(diamondCards);
			} else if (c.getSuit() == 2) // add all heart cards to the arraylist
			{
				heartCards.add(c);
				sortHand(heartCards);
			} else // add all spade cards to the arraylist
			{
				spadeCards.add(c);
				sortHand(spadeCards);
			}
		}

		if (clubCards.size() > 2) {
			for (int i = 0; i < clubCards.size() - 2; i++) {
				if ((clubCards.get(i + 1).getRank() - clubCards.get(i).getRank()) == 1)
					if ((clubCards.get(i + 2).getRank() - clubCards.get(i).getRank()) == 2)
						return true;
//						check1 = true;
			}
			/*
			 * if(check1) { for(int i = 0; i < hand.size()-1; i++) {
			 * if(hand.get(i).getSuit() != hand.get(i + 1).getSuit()) check2 = false; } }
			 * 
			 * if(check2) return true;
			 */

		}

		if (diamondCards.size() > 2) {
			for (int i = 0; i < diamondCards.size() - 2; i++) {
				if ((diamondCards.get(i + 1).getRank() - diamondCards.get(i).getRank()) == 1)
					if ((diamondCards.get(i + 2).getRank() - diamondCards.get(i).getRank()) == 2)
						// check1 = true;
						return true;
			}

			/*
			 * if(check1) { for(int i = 0; i < hand.size()-1; i++) {
			 * if(hand.get(i).getSuit() != hand.get(i + 1).getSuit()) check2 = false; } }
			 * 
			 * if(check2) return true;
			 */
		}

		if (heartCards.size() > 2) {
			for (int i = 0; i < heartCards.size() - 2; i++) {
				if ((heartCards.get(i + 1).getRank() - heartCards.get(i).getRank()) == 1)
					if ((heartCards.get(i + 2).getRank() - heartCards.get(i).getRank()) == 2)
						return true;
				// check1 = true;
			}
			/*
			 * if(check1) { for(int i = 0; i < hand.size()-1; i++) {
			 * if(hand.get(i).getSuit() != hand.get(i + 1).getSuit()) check2 = false; } }
			 * 
			 * if(check2) return true;
			 */
		}

		if (spadeCards.size() > 2) {
			for (int i = 0; i < spadeCards.size() - 2; i++) {
				if ((spadeCards.get(i + 1).getRank() - spadeCards.get(i).getRank()) == 1)
					if ((spadeCards.get(i + 2).getRank() - spadeCards.get(i).getRank()) == 2)
						// check1 = true;
						return true;
			}
			/*
			 * if(check1) { for(int i = 0; i < hand.size()-1; i++) {
			 * if(hand.get(i).getSuit() != hand.get(i + 1).getSuit()) check2 = false; } }
			 * 
			 * if(check2) return true;
			 */
		}

		return false;
	}

	/**
	 * This function sorts the hand
	 * 
	 * @param hand The hand which is to be sorted.
	 */

	public void sortHand(ArrayList<Card> hand) {
		for (int i = 0; i < hand.size() - 1; i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if (hand.get(i).getRank() > hand.get(j).getRank()) {
					Card temp = hand.get(i);
					hand.set(i, hand.get(j));
					hand.set(j, temp);
				}
			}
		}
	}

	/**
	 * This function lets the player discard a card.
	 * 
	 * @param hand The hand from which a card is to be discarded.
	 */

	public void discard(ArrayList<Card> hand) {
		int num = 0;
		System.out.print("Choose a card to discard: ");
		num = playerInput.nextInt();

		discardPile.add(hand.remove(num - 1));
//		if(heighestScore >= scoreCap)
//			return;
//		nextTurn();
	}

	/**
	 * This function lets the player draw a card from the deck.
	 * 
	 * @param hand The hand in which the drawn card will be added.
	 */

	public void draw(ArrayList<Card> hand) {
		System.out.println(" draw");
		hand.add(shuffledDeck.pop());
		sortHand(hand);
		clearConsole();
		displayTable();
	}

	/**
	 * This function lets the player draw a card from the discard pile.
	 * 
	 * @param hand The hand in which the drawn card(s) will be added.
	 */

	public void drawFromDiscard(ArrayList<Card> hand) {
		int cardNumber = 0;
		System.out.print("Enter the card number you want: ");
		cardNumber = (playerInput.nextInt() - 1);
		ArrayList<Card> tempHand = new ArrayList<Card>();

		for (int i = 0; i < hand.size(); i++) {
			tempHand.add(hand.get(i));
		}

		for (int i = cardNumber; i < discardPile.size(); i++) {
			tempHand.add(discardPile.get(cardNumber));
		}

		int temp = cardNumber;
		sortHand(tempHand);
		if (!isRun(tempHand)) {
			clearConsole();
			displayTable();
			System.out.println("No run possible with the card chosen...");
			displayOptions();
			return;
		}

		while (cardNumber != discardPile.size()) {
			Card removeCard = discardPile.get(cardNumber);
			hand.add(removeCard);
			cardNumber++;
		}
		int pileSize = discardPile.size() - 1;
		while (temp - 1 != pileSize) {
			discardPile.remove(pileSize);
			pileSize--;
		}

		clearConsole();
		displayTable();

	}

	/**
	 * This function changes the turn.
	 */

	/*
	 * public void followRun(ArrayList<Card> hand) { int playerID = 0, upperBound =
	 * 0, lowerBound = 0, numberOfCards = 0; int cardNumber = 0; Player tempPlayer =
	 * players.peek(); Player currentPlayer = players.peek(); ArrayList<Card>
	 * tempHand = new ArrayList<Card>();
	 * 
	 * System.out.
	 * println("The follow run lets you lay down cards on to other players' laid down piles"
	 * ); System.out.
	 * println("You get points for the cards that you lay onto their pile");
	 * System.out.println("Enter the player's ID you want to follow run: ");
	 * playerID = playerInput.nextInt()-1; for(int i = 0; i < numberOfPlayers; i++)
	 * { if(tempPlayer.getPlayerID() == playerID) { System.out.
	 * print("Enter the highest card number for the range your card matches with: "
	 * ); upperBound = playerInput.nextInt()-1; System.out.
	 * print("Enter the lowest card number for the range your card matches with: ");
	 * lowerBound = playerInput.nextInt()-1; for(int j = lowerBound; j < upperBound;
	 * j++) { System.out.println(tempPlayer.getPlayerID());
	 * //tempHand.add(tempPlayer.laidDown.get(j)); }
	 * 
	 * System.out.print("Enter the number of cards you want to lay down: ");
	 * numberOfCards = playerInput.nextInt();
	 * 
	 * for(int j = 0; j < numberOfCards; j++) {
	 * System.out.println("Enter the card you want to lay down: "); cardNumber =
	 * playerInput.nextInt()-1; if(cardNumber < 0 || cardNumber >
	 * tempPlayer.hand.size() - 1) System.out.println("card isnt in hand");
	 * tempHand.add(tempPlayer.hand.get(cardNumber)); } int temp = numberOfCards;
	 * if(!checkMatchRun(tempHand) || !checkSuitRun(tempHand)) {
	 * System.out.println("It is not a follow run"); } else { while(numberOfCards !=
	 * 0) { tempPlayer.laidDown.add(tempHand.get(0));
	 * currentPlayer.hand.remove(tempHand.get(0)); numberOfCards--;
	 * 
	 * } }
	 * 
	 * } players.add(players.poll());
	 * 
	 * 
	 * } }
	 */

	public void nextTurn() {
		clearConsole();
		players.add(players.poll());
		if (players.peek().hand.isEmpty()) {
			System.out.println("Players hand is empty!");
			System.out.println("New round to commence!");
			resetGame();
		}
		if (shuffledDeck.isEmpty()) {
			System.out.println("The deck is empty!");
			System.out.println("New round to commence!");
			resetGame();
		}

//		displayTable();
//		displayOptions();
//		System.out.println("---------------------------------------------------------------------------------------------------------------------");
//		displayTurn();

	}

	/**
	 * This function prints the stats of players after every round.
	 */

	public void printStats() {
		for (Player p : players) {
			int playerID = 0;
			p.printPlayerInfo(playerID);
			playerID++;
		}
	}

	/**
	 * This function mocks clearing the console by printing 50 newlines on the
	 * console.
	 */

	public void clearConsole() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}
}
