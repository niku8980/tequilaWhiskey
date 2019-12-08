package rummy;

import java.util.*;

/**
 * This class generates a game and makes the game playable.
 * 
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

public class Game {
	/**
	 * The number of players in the game.
	 */
	static int numberOfPlayers;

	/**
	 * Current highest score for score cap.
	 */

	static int highestScore;

	/**
	 * The score cap of the game.
	 */

	static int scoreCap;

	/**
	 * The queue of players.
	 */

	static Queue<Player> players;
	
	/**
	 * The variable that stores the current highest player name
	 */

	static String highestName;

	/**
	 * The player input scanner during the game play
	 */

	static Scanner playerInput;

	/**
	 * The pile where all the discarded cards are stored.
	 */

	static ArrayList<Card> discardPile;

	/**
	 * The variable for the input checks 
	 */

	static boolean done = true;
	
	/**
	 * The shuffled deck.
	 */

	static Deck shuffledDeck = new Deck();
	
	/**
	 * The current player 
	 */
	
	static Player currentPlayer;

	/**
	 * The oject that aligns the players' information in the center of the line
	 */
	
	AlignString centerJustifyPlayer;
	
	/**
	 * The object that aligns the players' information to the right of the line
	 */
	
	AlignString rightJustifyPlayer;
	
	/**
	 * The object that justifies the card in the center of the line
	 */
	
	AlignString centerJustifyCard;
	
	/**
	 * The object that aligns the cards to the right of the line
	 */
	
	AlignString rightJustifyCard;

	/**
	 * The constructor initiates the game
	 */

	public Game() {
		numberOfPlayers = 0;
		scoreCap = 0;
		highestScore = 0;
		players = new LinkedList<Player>();
		playerInput = new Scanner(System.in);
		centerJustifyPlayer = new AlignString(200, "CENTERPLAYER");
		rightJustifyPlayer = new AlignString(200, "RIGHTPLAYER");
		rightJustifyCard = new AlignString(200, "RIGHTCARD");
		centerJustifyCard = new AlignString(200, "CENTERCARD");
		discardPile = new ArrayList<Card>();
		currentPlayer = new Player();
		highestName = new String();

	}

	void playTheGame() // playGame()
	{
		welcomeScreen();
		getGameInfo();
		setUpPlayers();
		distributeCards();

		while (highestScore <= scoreCap) {
			displayTable();
			displayOptions();
			displayTurn();
			nextTurn();
			clearConsole();

			
		}

		System.out.println("=====================================================================================================================");
		System.out.println("Heighest score: " + highestScore);
//		System.out.println("Score cap: " + scoreCap);		
		System.out.println("The game has ended and " + highestName + " has won!!");
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
		do {
			try {
				System.out.print("\n\tCan you please enter number of players 2 - 4: ");
				numberOfPlayers = playerInput.nextInt();
				if (numberOfPlayers > 4 || numberOfPlayers < 2) {
					throw new InputMismatchException("\tWrong number of Players");
				}
				done = false;
			} catch (InputMismatchException e) {
				System.out.println("\tInvalid input!");
				numberOfPlayers = 0;
			}
			playerInput.nextLine();
		} while (done);

		done = true;
		do {
			try {
				System.out.print("\tHow about the score cap: ");
				scoreCap = playerInput.nextInt();
				if (scoreCap < 0)
					throw new InputMismatchException("\tScore too low!");
				done = false;

			} catch (InputMismatchException e) {
				System.out.println("\tInvalid input!");
			}
			playerInput.nextLine();
		} while (done);

		System.out.println("\tAlright! Now lets set up players profile...\n");
	}

	/**
	 * This function sets up the players' profiles.
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

	/**
	 * This function resets the game if two things happen:
	 * 1.  If a player has no more cards in his hand, or
	 * 2.  If the deck is empty
	 * 
	 * When the reset happens: 
	 * Players turn in all their cards in hand, laid down cards 
	 * and all the discarded cards are collected.
	 * 
	 * The only thing that stays the same is players' scores. 
	 */
	
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

	public void displayTableForTwoPlayers() 
	{
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
	public void printPlayerInfoCenter(Player p) 
	{
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(centerJustifyPlayer.format((playerID) + ".  " + playerName));
		System.out.println(centerJustifyPlayer.format(p.getPlayerName() + "'s score: " + p.getPlayerScore()));
		System.out.println(centerJustifyPlayer.format("Laid down cards: "));
		int i = 1;
		for (Card c : p.laidDown) 
		{
			if (i < 10)
				System.out.print(centerJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function prints the players' informations to the right
	 * 
	 * @param p The player whose information is to be printed.
	 */

	public void printPlayerInfoRight(Player p)
	{
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(rightJustifyPlayer.format((playerID) + ".  " + playerName));
		System.out.println(rightJustifyCard.format(p.getPlayerName() + "'s score: " + p.getPlayerScore()));
		System.out.println(rightJustifyPlayer.format("Laid down cards: "));
		int i = 1;
		for (Card c : p.laidDown) 
		{
			System.out.print(rightJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function prints the players' informations to the left
	 * 
	 * @param p The player whose information is to be printed.
	 */

	public void printPlayerInfoLeft(Player p)
	{
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.println(((playerID) + ".  " + playerName));
		System.out.println((p.getPlayerName() + "'s score: " + p.getPlayerScore()));
		System.out.println();
		System.out.println(("Laid down cards: "));
		int i = 1;
		for (Card c : p.laidDown)
		{
			System.out.println((i + ".  | " + c.toString() + "  | "));
			i++;
		}
	}

	/**
	 * This function prints the current player's information
	 * 
	 * @param p The current player
	 */

	public void printCurrentPlayerInfo(Player p)
	{
		int playerID = p.getPlayerID() + 1;
		String playerName = p.getPlayerName();
		System.out.print(centerJustifyPlayer.format((playerID) + ".  " + playerName));
		System.out.println(centerJustifyPlayer.format(p.getPlayerName() + "'s score: " + p.getPlayerScore()));
		System.out.println(centerJustifyPlayer.format("Laid down cards: "));
		int i = 1;
		for (Card c : p.laidDown) 
		{
			System.out.print(centerJustifyCard.format(i + ".  | " + c.toString() + "  | "));
			i++;
		}
		System.out.println();
		System.out.println(centerJustifyPlayer.format("Cards in hand: "));
		i = 1;

		sortHand(p.hand);

		for (Card c : p.hand) 
		{
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
		players.add(players.poll());
		currentPlayer = players.peek();
		printPlayerInfoLeft(currentPlayer);
		players.add(players.poll());
		currentPlayer = players.peek();
		printPlayerInfoRight(currentPlayer);
		printDeckAndDiscard();
		players.add(players.poll());
		currentPlayer = players.peek();
		printCurrentPlayerInfo(currentPlayer);
	}

	/**
	 * This function displays the table if there were 4 players in the game.
	 */

	public void displayTableForFourPlayers()
	{
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

	public void displayOptions() 
	{
		done = true;
		int option = 0;
		do {
			try {
				System.out.println("\n1.  Pick up from Deck.");
				System.out.println("2.  Pick up from discard pile.");
				option = playerInput.nextInt();
				if (option < 1 || option > 2)
					throw new InputMismatchException();
				done = false;
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("\tInvalid input!");
				option = 0;
			}
			playerInput.nextLine();
		} while (done);
		if (option == 1) 
		{
			draw(currentPlayer.hand);
			System.out.println();
		} else {
			drawFromDiscard(currentPlayer.hand);
		}
	}

	/**
	 * This function prints the deck and the discard pile on the game table.
	 */

	public void printDeckAndDiscard() 
	{
		System.out.println();
		
		System.out.print(centerJustifyPlayer.format("========================"));
		System.out.print(centerJustifyPlayer.format("|  Deck: | X |         |"));
		if(shuffledDeck.size() <= 9)
			System.out.print(centerJustifyPlayer.format("|  Deck has " + (shuffledDeck.size()) + " card(s)  |"));
		else
			System.out.print(centerJustifyPlayer.format("|  Deck has " + (shuffledDeck.size()) + " card(s) |"));
		System.out.print(centerJustifyPlayer.format("|                      |"));
		System.out.print(centerJustifyPlayer.format("|  Discarded Cards:    |"));

		int i = 1;

		for (Card c : discardPile)
		{
			if (i < 10)
				System.out.print(centerJustifyCard.format("|  " + i + "....| " + c.toString() + "  |      | "));
			else
				System.out.print(centerJustifyCard.format("|  " + i + "...| " + c.toString() + "  |      | "));
			i++;
		}
		System.out.print(centerJustifyPlayer.format("========================"));
		if(shuffledDeck.size() < 5)
		{
			System.out.println();
			System.out.print(centerJustifyCard.format("Less than 5 cards remaining in the deck."));
			System.out.print(centerJustifyCard.format("The game will reset after deck runs out."));
		}
		System.out.println("\n");
	}

	/**
	 * This function displays the turn.
	 */

	public void displayTurn() 
	{
		int option = 0;
		int oldSize = 0, newSize = 0;
		done = true;
		do {
			do {
				try {
					System.out.println("\n1. Make a run.");
					System.out.println("2.  Discard a card.");
					option = playerInput.nextInt();
					if (option < 1 || option > 2)
						throw new InputMismatchException();
					done = false;
				} catch (InputMismatchException e)
				{
					System.out.println("\tInvalid Input!");
					option = 0;
				}
				playerInput.nextLine();

			} while (done);

			if (option == 1)
			{
				if (isRun(currentPlayer.hand)) 
				{
					oldSize = currentPlayer.laidDown.size();
					currentPlayer.laidDown.addAll(suitRun(currentPlayer.hand));
					newSize = currentPlayer.laidDown.size();
					currentPlayer.playerScore += (newSize - oldSize) * 5;
					if (highestScore < currentPlayer.getPlayerScore()) 
					{
						highestScore = currentPlayer.getPlayerScore();
						highestName = currentPlayer.getPlayerName();
					}

					displayTable();
				} else {
					System.out.println("A run is not possible with cards in your hand!");
				}
			}
		} while (option != 2);

		discard(currentPlayer.hand);
	}

	/**
	 * This function lets the player make a run
	 * 
	 * @param hand The hand of the current player
	 * @return Returns an arrayList of the cards that could be laid down by a player
	 */

	public ArrayList<Card> suitRun(ArrayList<Card> hand) 
	{
		int numberOfCards = 0;
		int cardNumber = 0;
		ArrayList<Card> runCards = new ArrayList<Card>();
		done = true;

		do {
			numberOfCards = 0;
			cardNumber = 0;
			runCards = new ArrayList<Card>();
			int option = 0;
			do {
				try {
					System.out.println("1.  Do a match run.");
					System.out.println("2.  Do a suit run.");
					option = playerInput.nextInt();
					if (option > 2 || option < 1)
						throw new InputMismatchException();
					done = false;
				} catch (InputMismatchException e) 
				{
					System.out.println("\tInvalid input!");
					option = 0;
				}
				playerInput.nextLine();
			} while (done);

			done = true;
			do {
				try {
					System.out.print("Please enter the number of cards you want to lay down: ");
					numberOfCards = playerInput.nextInt();
					if (numberOfCards < 3)
						throw new InputMismatchException();
					done = false;
				} catch (InputMismatchException e) 
				{
					System.out.println("\tInvalid input!");
				}
				playerInput.nextLine();
			} while (done);

			done = true;

			for (int i = 0; i < numberOfCards; i++) 
			{
				do {
					try {
						System.out.print("Enter card number: ");
						cardNumber = playerInput.nextInt() - 1;
						if (cardNumber > hand.size() || cardNumber < 0) 
						{
							throw new InputMismatchException();
						}
						runCards.add(hand.get(cardNumber));
					} 
					catch (InputMismatchException e)
					{
						System.out.println("\tInvalid input!");
						numberOfCards++;

					}
					done = false;
					playerInput.nextLine();
				} while (done);
			}

			if (option == 1)
			{
				checkMatchRun(runCards);
				if (checkMatchRun(runCards)) 
				{
					for (Card c : runCards) 
					{
						hand.remove(c);
					}
					break;
				} else
					System.out.println("No possible match run with selected cards!");
			} 
			else if (option == 2) 
			{
				checkSuitRun(runCards);
				if (checkSuitRun(runCards))
				{
					for (Card c : runCards) 
					{
						hand.remove(c);
					}
					break;
				} 
				else
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

	public boolean checkMatchRun(ArrayList<Card> hand) 
	{
		for (int i = 0; i < hand.size() - 2; i++) 
		{
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()
					&& hand.get(i).getRank() == hand.get(i + 2).getRank())
				continue;
			else if (hand.get(i).getRank() != hand.get(i + 1).getRank()
					|| hand.get(i).getRank() != hand.get(i + 2).getRank())
				return false;
		}

		return true;
	}

	/**
	 * This function specifically checks for a Suit run.
	 * 
	 * @param hand The cards which are checked to see if there is a possible run.
	 * @return True if there is a possible run, false otherwise.
	 */

	public boolean checkSuitRun(ArrayList<Card> hand) 
	{

		for (int i = 0; i < hand.size() - 2; i++) 
		{
			if (hand.get(i).getSuit() == hand.get(i + 1).getSuit()
					&& hand.get(i).getSuit() == hand.get(i + 2).getSuit())
				continue;
			else if (hand.get(i).getSuit() != hand.get(i + 1).getSuit()
					|| hand.get(i).getSuit() != hand.get(i + 2).getSuit())
				return false;
		}

		ArrayList<Card> clubCards = new ArrayList<Card>();
		ArrayList<Card> spadeCards = new ArrayList<Card>();
		ArrayList<Card> diamondCards = new ArrayList<Card>();
		ArrayList<Card> heartCards = new ArrayList<Card>();

		// sort all the cards as per the suit and store them in specific ArrayLists
		// and sort all the ArrayLists

		for (Card c : hand) 
		{
			if (c.getSuit() == 0) // add club cards to ArrayList
			{
				clubCards.add(c);
				sortHand(clubCards);
			} else if (c.getSuit() == 1) // add all diamond cards to the ArrayList
			{
				diamondCards.add(c);
				sortHand(diamondCards);
			} else if (c.getSuit() == 2) // add all heart cards to the ArrayList
			{
				heartCards.add(c);
				sortHand(heartCards);
			} else // add all spade cards to the ArrayList
			{
				spadeCards.add(c);
				sortHand(spadeCards);
			}
		}

		// there is a run only if there are more than 2 cards of a certain suit
		// so the check made to ensure that there are more than 2 cards
		// if not skip to the next one

		if (clubCards.size() > 2)
		{
			for (int i = 0; i < clubCards.size() - 2; i++)
			{
				if ((clubCards.get(i + 1).getRank() - clubCards.get(i).getRank()) != 1
						|| (clubCards.get(i + 2).getRank() - clubCards.get(i).getRank()) != 2)
					return false;
			}
		}

		if (diamondCards.size() > 2) {
			for (int i = 0; i < diamondCards.size() - 2; i++)
			{
				if ((diamondCards.get(i + 1).getRank() - diamondCards.get(i).getRank()) != 1
						|| (diamondCards.get(i + 2).getRank() - diamondCards.get(i).getRank()) != 2)
					return false;
			}
		}

		if (heartCards.size() > 2) {
			for (int i = 0; i < heartCards.size() - 2; i++)
			{
				if ((heartCards.get(i + 1).getRank() - heartCards.get(i).getRank()) != 1
						|| (heartCards.get(i + 2).getRank() - heartCards.get(i).getRank()) != 2)
					return false;
			}
		}

		if (spadeCards.size() > 2) 
		{
			for (int i = 0; i < spadeCards.size() - 2; i++)
			{
				if ((spadeCards.get(i + 1).getRank() - spadeCards.get(i).getRank()) != 1
						|| (spadeCards.get(i + 2).getRank() - spadeCards.get(i).getRank()) != 2)
					return false;
			}
		}

		return true;
	}

	/**
	 * This functions makes sure that the cards picked up by the player from the
	 * discard pile make a run. If there is no possible run from the cards picked up
	 * from the discard pile and the cards in players hand than the function returns
	 * false, true otherwise.
	 * 
	 * @param hand The hand of the player with chosen cards from the discard pile
	 * @return True if the hand makes a successful run, false otherwise.
	 */

	public boolean isRun(ArrayList<Card> hand) 
	{

		// check for a match run

		for (int i = 0; i < hand.size() - 2; i++) 
		{
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()) 
			{
				if (hand.get(i).getRank() == hand.get(i + 2).getRank())
					return true;
			}
		}

		// check for a suit run

		ArrayList<Card> clubCards = new ArrayList<Card>();
		ArrayList<Card> spadeCards = new ArrayList<Card>();
		ArrayList<Card> diamondCards = new ArrayList<Card>();
		ArrayList<Card> heartCards = new ArrayList<Card>();

		for (Card c : hand)
		{
			if (c.getSuit() == 0) // add club cards to ArrayList
			{
				clubCards.add(c);
				sortHand(clubCards);
			} 
			else if (c.getSuit() == 1) // add all diamond cards to the ArrayList
			{
				diamondCards.add(c);
				sortHand(diamondCards);
			} 
			else if (c.getSuit() == 2) // add all heart cards to the ArrayList
			{
				heartCards.add(c);
				sortHand(heartCards);
			} 
			else // add all spade cards to the ArrayList
			{
				spadeCards.add(c);
				sortHand(spadeCards);
			}
		}

		if (clubCards.size() > 2)
		{
			for (int i = 0; i < clubCards.size() - 2; i++) 
			{
				if ((clubCards.get(i + 1).getRank() - clubCards.get(i).getRank()) == 1)
					if ((clubCards.get(i + 2).getRank() - clubCards.get(i).getRank()) == 2)
						return true;
			}
		}
		if (diamondCards.size() > 2) 
		{
			for (int i = 0; i < diamondCards.size() - 2; i++) 
			{
				if ((diamondCards.get(i + 1).getRank() - diamondCards.get(i).getRank()) == 1)
					if ((diamondCards.get(i + 2).getRank() - diamondCards.get(i).getRank()) == 2)
						return true;
			}
		}

		if (heartCards.size() > 2) 
		{
			for (int i = 0; i < heartCards.size() - 2; i++) 
			{
				if ((heartCards.get(i + 1).getRank() - heartCards.get(i).getRank()) == 1)
					if ((heartCards.get(i + 2).getRank() - heartCards.get(i).getRank()) == 2)
						return true;
			}
		}

		if (spadeCards.size() > 2)
		{
			for (int i = 0; i < spadeCards.size() - 2; i++)
			{
				if ((spadeCards.get(i + 1).getRank() - spadeCards.get(i).getRank()) == 1)
					if ((spadeCards.get(i + 2).getRank() - spadeCards.get(i).getRank()) == 2)
						return true;
			}
		}

		return false;
	}

	/**
	 * This function sorts the hand
	 * 
	 * @param hand The hand which is to be sorted.
	 */

	public void sortHand(ArrayList<Card> hand) 
	{
		for (int i = 0; i < hand.size() - 1; i++) 
		{
			for (int j = i + 1; j < hand.size(); j++) 
			{
				if (hand.get(i).getRank() > hand.get(j).getRank())
				{
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

	public void discard(ArrayList<Card> hand) 
	{
		done = true;
		int num = 0;
		do {
			try {
				System.out.print("Choose a card to discard: ");
				num = playerInput.nextInt();
				if (num > hand.size() || num <= 0) {
					throw new InputMismatchException();
				}
				done = false;
			}
			catch (InputMismatchException e) 
			{
				System.out.println("\tInvalid input!");
			}
			playerInput.nextLine();
		} while (done);

		discardPile.add(hand.remove(num - 1));
	}

	/**
	 * This function lets the player draw a card from the deck.
	 * 
	 * @param hand The hand in which the drawn card will be added.
	 */

	public void draw(ArrayList<Card> hand) 
	{
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

	public void drawFromDiscard(ArrayList<Card> hand) 
	{
		int cardNumber = 0;
		done = true;
		do {
			try {

				System.out.print("Enter the card number you want: ");
				cardNumber = (playerInput.nextInt() - 1);
				if (cardNumber > hand.size() || cardNumber < 0) 
				{
					throw new InputMismatchException();
				}
				ArrayList<Card> tempHand = new ArrayList<Card>();
				done = false;
				for (int i = 0; i < hand.size(); i++)
				{
					tempHand.add(hand.get(i));
				}

				for (int i = cardNumber; i < discardPile.size(); i++) 
				{
					tempHand.add(discardPile.get(i));
				}

				int temp = cardNumber;
				sortHand(tempHand);

				if (!isRun(tempHand))
				{
					clearConsole();
					displayTable();
					System.out.println("No run possible with the card chosen...");
					displayOptions();
					return;
				}

				while (cardNumber != discardPile.size())
				{
					Card removeCard = discardPile.get(cardNumber);
					hand.add(removeCard);
					cardNumber++;
				}
				int pileSize = discardPile.size() - 1;
				while (temp - 1 != pileSize) 
				{
					discardPile.remove(pileSize);
					pileSize--;
				}

				clearConsole();
				displayTable();
			} 
			catch (InputMismatchException e)
			{
				System.out.println("\tInvalid Input!");
			}
			playerInput.nextLine();
		} while (done);
	}

	/**
	 * This function changes the turn.
	 */

	public void nextTurn()
	{
		clearConsole();
		players.add(players.poll());
		if (players.peek().hand.isEmpty())
		{
			System.out.println("Players hand is empty!");
			System.out.println("New round to commence!");
			resetGame();
		}
		if (shuffledDeck.isEmpty())
		{
			System.out.println("The deck is empty!");
			System.out.println("New round to commence!");
			resetGame();
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
