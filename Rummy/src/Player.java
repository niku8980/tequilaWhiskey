import java.util.*;
import java.io.*;

public class Player extends Deck
{
	int playerID;				
	int score;
	String playerName;
	ArrayList<Deck> hand;
	
	public Player() {
		super();
		playerID = 0;
		score = 0;
		playerName = new String();
		hand = new ArrayList<Deck>();
	}

	public int getPlayerID() 
	{
		return playerID;
	}

	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
	}

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}

	public String getPlayerName() 
	{
		return playerName;
	}

	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}	
}
