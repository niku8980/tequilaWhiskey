package rummy;
import java.util.*;
/**
 * This is the player class which resembles a player in the game 
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0 *
 */
public class Player
{
	/**
	 * The ID number of the player
	 */
	int playerID;				
	
	/**
	 * Current score of the player
	 */
	
	int playerScore;
	
	/**
	 * Name of the player
	 */
	
	String playerName;
	
	/**
	 * The hand of the player 
	 */
	
	ArrayList<Card> hand;
	
	/**
	 * The laid down cards by the player
	 */
	
	ArrayList<Card> laidDown;
	 
	/**
	 * The constructor initializes all the attributes of the player 
	 * to their default values.
	 */
	
	public Player() 
	{
		playerID = -1;
		playerScore = 0;
		playerName = new String();
		hand = new ArrayList<Card>();
		laidDown = new ArrayList<Card>();
	}

	/**
	 * This function returns the ID number of the player
	 * @return The ID number of the player
	 */
	
	public int getPlayerID() 
	{
		return playerID;
	}

	/**
	 * This function sets the ID number of the player
	 * @param playerID The ID of the player
	 */
	
	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
	}
	
	/**
	 * This function returns the current score of the player
	 * @return The currente score of the player
	 */

	public int getPlayerScore() 
	{
		return playerScore;
	}
	
	/**
	 * This function sets the score of the player
	 * @param score The score to be set
	 */

	public void setScore(int score) 
	{
		this.playerScore = score;
	}

	/**
	 * This function returns the name of the player
	 * @return The name of the player
	 */
	
	public String getPlayerName() 
	{
		return playerName;
	}

	/**
	 * This functions sets the player's name
	 * @param playerName The name of the player
	 */
	
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}	
	
	/**
	 * This function prints the player's information
	 * @param playerID ID number of the player whose information is to be printed.
	 */
	
	public void printPlayerInfo(int playerID)
	{
		System.out.println("\tPlayer ID: " + (this.playerID + 1));
		System.out.println("\tPlayer Name: " + this.playerName);
		System.out.println("\tPlater Score: " + this.playerScore);
	}
}
