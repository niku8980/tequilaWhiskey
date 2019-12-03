package rummy;

/**
 * This is the main class of the program.
 * @author Brandon Staton, Dillon Kilroy, Nick Patel
 *
 */
public class Driver {

	/**
	 * This the main function of the program
	 * @param args The string arguments passed when running on the command line.
	 */
	
	public static void main(String[] args)
	{
		/**
		 * The game.
		 */
		Game newGame = new Game();
		
		/**
		 * Play the game
		 */
	
		newGame.setUpGame();  
	}

}
