import java.util.*;

public class Game 
{
	static int numberOfPlayers;
	static Character yesOrNo;
	static boolean aceHigh;
	static int scoreCap;
	static Queue<Player> players;
	static Scanner playerInput;
	static ArrayList<Card> discardPile;
	static Deck shuffledDeck = new Deck();
	
	StringAlignUtils leftJustify;
	StringAlignUtils centerJustify;
	StringAlignUtils rightJustify;
	
	
	public Game()
	{
		numberOfPlayers = 0;
		yesOrNo = 'n';
		aceHigh = false;
		scoreCap = 0;
		players = new LinkedList<Player>();
		playerInput = new Scanner(System.in);
		leftJustify = new StringAlignUtils(150, "LEFT");
		centerJustify = new StringAlignUtils(150, "CENTER");
		rightJustify = new StringAlignUtils(150, "RIGHT");
		discardPile = new ArrayList<Card>();
	}
			
	void setUpGame() 
	{
//		welcomeScreen();
		getGameInfo();
		setUpPlayers();
//		clearConsole();
		
		distributeCards();
		
		//printStats();
		displayTable();
		
		players.peek().laidDown.addAll(suitRun(players.peek().hand));
		displayTable();
		
		nextTurn();
		//clearConsole();
		
	}
	
	
	public void playTheGame()
	{
		
		
		
		//suitRun();
		
	}
	
	public static void welcomeScreen()
	{
		System.out.print("\tWelcome to the rummy: \n");
		System.out.println("\tThis game could be played by upto 4: ");
		System.out.println("\tYou would have an option to play with high or low!");
		System.out.println("\n\tOkay! Enough of it. lets dive in setting up the game...");
	}
	
	public static void getGameInfo()
	{
		System.out.print("\n\tCan you please enter number of players: ");
		numberOfPlayers = playerInput.nextInt();
		
		while(numberOfPlayers > 4 || numberOfPlayers < 2)
		{
			System.out.println("\tWooooowooow!!! Players must be between 2 - 4...");
			System.out.print("1\tCan you please enter number of players: ");
			numberOfPlayers = playerInput.nextInt();
		}
		
		System.out.print("\tHow about ace with high? (y/n): ");
		yesOrNo = playerInput.next().charAt(0);
		yesOrNo = Character.toLowerCase(yesOrNo);
		aceHigh = yesOrNo.equals('y');
				
		/* TODO: Check if the user enters valid input or not */
		
		System.out.print("\tHow about the score cap: ");
		scoreCap = playerInput.nextInt();
		
		System.out.println("\tAlright! Now lets set up players profile...\n");
	}

	public void setUpPlayers()
	{
		for(int i = 0; i < numberOfPlayers; i++)
		{
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
	
	public void distributeCards()
	{
		
		shuffledDeck.createDeck();
		Player tempPlayer = new Player();
		Card tempCard = new Card(0, 0);
		int cardsToBeDealt = 0;
		
		if(numberOfPlayers  == 2)
			cardsToBeDealt = 20;
		else if(numberOfPlayers == 3)
			cardsToBeDealt  = 21;
		else
			cardsToBeDealt = 28;
		
		while(cardsToBeDealt != 0)
		{
			tempPlayer = players.peek();
			tempCard = shuffledDeck.pop();
			tempPlayer.hand.add(tempCard);	
			players.add(players.poll());
			cardsToBeDealt--;
		}	
	}
	
	public void displayTable()
	{
		if(numberOfPlayers == 2)
			displayTableForTwoPlayers();
		else if(numberOfPlayers == 3)
			displayTableForThreePlayers();
		else
			displayTableForFourPlayers();
		displayOptions();
	}
	
	
	public void displayTableForTwoPlayers()
	{
		
		players.add(players.poll());
		
		System.out.println(centerJustify.format(players.peek().getPlayerName()));
		System.out.println(centerJustify.format("Laid down"));
		
		
		//System.out.printf("%50s%n", players.peek().getPlayerName());
//		System.out.printf("%100s%n", "Laid down");
		players.add(players.poll());
		
		//System.out.printf("%n%50s", "| X |");
		//System.out.printf("%n%50s%n", "| discard |");
	
		System.out.println(centerJustify.format("| X |"));
		System.out.println(centerJustify.format("| DISCARD |"));		
		
		
		System.out.println(centerJustify.format(players.peek().getPlayerName()));
		System.out.println(centerJustify.format("Laid down"));
		int i = 1;
		System.out.println("\n\n");
		
		for(Card c: players.peek().laidDown)
		{
			System.out.print(centerJustify.format(i + ".  | " + c.toString() + "  | " ));
			i++;
		}
		System.out.println("\n\n");
		System.out.println(centerJustify.format("Cards in hand: "));
		i = 1;
		for(Card c: players.peek().hand)
		{
			System.out.print(centerJustify.format(i + ".  | " + c.toString() + "  | " ));
			i++;
		}
		
		
		System.out.println("\nSorsted list\n");
		sortHand(players.peek().hand);
		
		for(Card c: players.peek().hand)
		{
			System.out.print(centerJustify.format(i + ".  | " + c.toString() + "  | " ));
			i++;
		}
		
//		System.out.printf("%50s%n", players.peek().getPlayerName());
//		System.out.printf("%50s%n", "Laid down");
	}
	
	public void displayTableForThreePlayers()
	{
		players.add(players.poll());
		players.add(players.poll());
		
		System.out.printf("%-100s%n", players.peek().getPlayerName());
		System.out.printf("%-100s%n", "Laid down");
		
		players.add(players.poll());
		players.add(players.poll());
		
		System.out.printf("%100s%n", players.peek().getPlayerName());
		System.out.printf("%100s%n", "Laid down");
		
		players.add(players.poll());
		players.add(players.poll());
		
		System.out.printf("%n%50s", "| X |");
		System.out.printf("%n%50s%n", "| discard |");
		System.out.println();
		System.out.println();
		
		System.out.printf("%50s%n", players.peek().getPlayerName());
		System.out.printf("%100s%n", "Laid down");
		System.out.printf("%5s", "");
		
		for(Card c: players.peek().hand)
		{
			System.out.print("|" + c.toString() + " | " );
		}
	}
	
	public void displayTableForFourPlayers()
	{
		players.add(players.poll());
		players.add(players.poll());
		System.out.print(centerJustify.format(players.peek().getPlayerName()));
		System.out.print(centerJustify.format("Laid down"));
		
		players.add(players.poll());
		players.add(players.poll());
		players.add(players.poll());
		//System.out.printf("%-100s", players.peek().getPlayerName());
		//System.out.printf("%n%-100s%n",  "Laid down");
		System.out.println(players.peek().getPlayerName());
		System.out.println("Laid down: ");

		System.out.println();
		System.out.println();
		System.out.printf("%n%50s", "| X |");
		System.out.printf("%n%50s%n", "| discard |");
		System.out.println();
		System.out.println();

		
		players.add(players.poll());
		players.add(players.poll());
		System.out.printf("%100s", players.peek().getPlayerName());
		System.out.printf("%n%100s%n",  "Laid down");
			
		players.add(players.poll());
		System.out.printf("%50s", players.peek().getPlayerName());
		System.out.printf("%n%50s%n",  "Laid down");
		System.out.printf("%5s", "");
		
		for(Card c: players.peek().hand)
		{
			System.out.print("| " + c.toString() + " | " );
		}
		
		System.out.println();
		System.out.println();
	}
	
	public void displayOptions()
	{
		System.out.println("\n1.  Pick up from Deck.");
		System.out.println("2.  Pick up from discard pile.");		
	}
	
	public ArrayList<Card> suitRun(ArrayList<Card> hand)
	{
		ArrayList<Card> cards  = new ArrayList<Card>();
		if(!checkRun(hand))
			System.out.println("There is no possible suit or set");
			
		else
		{
			int numberOfCards = 0;
			do
			{
				System.out.println("Enter the number of cards you want to lay down: ");
				numberOfCards = playerInput.nextInt();
			}while(numberOfCards < 3);
			
			while(numberOfCards != 0)
			{
				System.out.println("Enter the card number: ");
				Card removeCard = hand.remove(playerInput.nextInt()-1);
				cards.add(removeCard);
				numberOfCards--;
			}
		}
		
		return cards;
		
	}
	
	public boolean checkRun(ArrayList<Card> hand)
	{
		// match run check
		
		for(int i = 0 ; i < hand.size()-2; i++)
		{
			if(hand.get(i).getRank() == hand.get(i + 1).getRank())
				if(hand.get(i).getRank() == hand.get(i+2).getRank())
					return true;
		}

		// suit run check
		
		for(int i = 0 ; i < hand.size()-2; i++)
		{
			if(hand.get(i).getRank() == hand.get(i + 1).getRank() && hand.get(i).getSuit() == hand.get(i + 1).getSuit())
				if(hand.get(i).getRank() == hand.get(i+2).getRank() && hand.get(i).getSuit() == hand.get(i+2).getSuit())
					return true;
		}
		
		return false;
	}
	
	public void sortHand(ArrayList<Card> hand)
	{
		for(int i = 0; i < hand.size()-1; i++)
		{
			for(int j = i + 1; j < hand.size(); j++)
			{
				if(hand.get(i).getRank() > hand.get(j).getRank())
				{
					Card temp = hand.get(i);
					hand.set(i, hand.get(j));
					hand.set(j, temp);
				}
			}
		}
	}
	
	public void discard(ArrayList<Card> hand)
	{
		int num = 0;
		System.out.print("Choose a card to discard: ");
		num = playerInput.nextInt();
		
		discardPile.add(hand.remove(num-1));		
	}
	
	public void draw(ArrayList<Card> hand)
	{
		hand.add(shuffledDeck.pop());
	}
	
	
	
	public void nextTurn()
	{
		players.add(players.poll());
	}
	
	public void printStats()
	{
		for(Player p: players)
		{
			int playerID = 0;
			p.printPlayerInfo(playerID);
			playerID++;
		}		
	}
	
	public final static void clearConsole()
	{
		for (int i = 0; i < 100; ++i) System.out.println();
	}
}
