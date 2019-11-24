import java.util.*;

public class Player
{
	int playerID;				
	int playerScore;
	String playerName;
	ArrayList<Card> hand;
	ArrayList<Card> laidDown;
	Scanner playerInput;
	
	public Player() {
		super();
		playerID = -1;
		playerScore = 0;
		playerName = new String();
		hand = new ArrayList<Card>();
		laidDown = new ArrayList<Card>();
		playerInput = new Scanner(System.in);
	}

	public int getPlayerID() 
	{
		return playerID;
	}

	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
	}

	public int getPlayerScore() 
	{
		return playerScore;
	}

	public void setScore(int score) 
	{
		this.playerScore = score;
	}

	public String getPlayerName() 
	{
		return playerName;
	}

	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}	
	
	public void printPlayerInfo(int playerID)
	{
		System.out.println("\tPlayer ID: " + (this.playerID + 1));
		System.out.println("\tPlayer Name: " + this.playerName);
		System.out.println("\tPlater Score: " + this.playerScore);
	}
}
