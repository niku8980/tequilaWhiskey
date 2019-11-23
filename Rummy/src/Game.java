import java.util.*;


public class Game 
{
	static int numberOfPlayers;
	static Character yesOrNo;
	static boolean aceHigh;
	static int scoreCap;
	static Queue<Player> players;
	static Scanner playerInput;
	
	
	public Game()
	{
		numberOfPlayers = 0;
		yesOrNo = 'n';
		aceHigh = false;
		scoreCap = 0;
		players = new LinkedList<Player>();
		playerInput = new Scanner(System.in);
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
		nextTurn();
		displayTable();
		//clearConsole();
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
		Deck shuffledDeck = new Deck();
		shuffledDeck.createDeck();
		//shuffledDeck.printDeck();
		int playerID = 0;
		Player tempPlayer = new Player();
		Card tempCard = new Card();
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
			//System.out.println( " came out of print " + tempCard.toString());
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
		System.out.printf("%25s%n", "Laid down");
		System.out.printf("%25s%n", players.peek().getPlayerName());
		players.add(players.poll());
		
		System.out.printf("%n%25s", "| X |");
		System.out.printf("%n%25s%n", "| discard |");
		
		System.out.printf("%n%25s%n",  "Laid down");
		System.out.printf("%25s%n", players.peek().getPlayerName());
		
	}
	
	public void displayTableForThreePlayers()
	{
		players.add(players.poll());
		players.add(players.poll());
		
		System.out.printf("%-50s%n", "Laid down");
		System.out.printf("%-50s%n", players.peek().getPlayerName());
		
		players.add(players.poll());
		players.add(players.poll());
		
		System.out.printf("%50s%n", "Laid down");
		System.out.printf("%50s%n", players.peek().getPlayerName());
		
		
		players.add(players.poll());
		players.add(players.poll());
		
		System.out.printf("%n%25s", "| X |");
		System.out.printf("%n%25s%n", "| discard |");
		System.out.println();
		System.out.println();
		System.out.printf("%n%25s%n",  "Laid down");
		System.out.printf("%25s%n", players.peek().getPlayerName());
		System.out.printf("%5s", "");
		
		for(Card c: players.peek().hand)
		{
			System.out.print("| " + c.toString() + " | " );
		}
	}
	
	public void displayTableForFourPlayers()
	{
		players.add(players.poll());
		players.add(players.poll());
		
		//System.out.printf("%25s%n", "Laid down");
		System.out.printf("%25s%n", players.peek().getPlayerName());
		
		players.add(players.poll());
		players.add(players.poll());
		players.add(players.poll());
//		System.out.printf("%-50s%n", "Laid down");
		System.out.printf("%-50s%n", players.peek().getPlayerName());

		System.out.println();
		System.out.println();
		System.out.printf("%n%25s", "| X |");
		System.out.printf("%n%25s%n", "| discard |");
		System.out.println();
		System.out.println();

		
		players.add(players.poll());
		players.add(players.poll());
		//players.add(players.poll());
//		System.out.printf("%50s%n", "Laid down");
		System.out.printf("%50s%n", players.peek().getPlayerName());
		
			
		players.add(players.poll());
//		players.add(players.poll());
//		players.add(players.poll());
//		System.out.printf("%n%25s%n",  "Laid down");
		System.out.printf("%25s%n", players.peek().getPlayerName());
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
