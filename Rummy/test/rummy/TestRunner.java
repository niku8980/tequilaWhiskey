package rummy;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is the test runner which tests all the test cases.
 * @author Brandon Staton, Dillon Kilroy, Nikunj Patel
 * @version 1.0
 */

@RunWith(Suite.class)
@SuiteClasses({ TestAlignString.class, TestCard.class, TestDeck.class, TestPlayer.class, TestSuite.class })
public class TestRunner
{
	/**
	 * The main test function
	 * @param args The arguments passed in the command line
	 */
	
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(TestSuite.class);
		for(Failure failure: result.getFailures())
		{
			System.out.println(failure.toString());;
		}
		System.out.println("Succesful tests: " + result.wasSuccessful());
	}
}
