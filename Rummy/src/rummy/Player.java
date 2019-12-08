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
	 * @return The current score of the player
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
}
