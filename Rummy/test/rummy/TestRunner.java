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
