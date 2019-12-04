package rummy;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestAlignString.class, TestCard.class, TestDeck.class, TestPlayer.class, TestSuite.class })
public class TestRunner
{
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
