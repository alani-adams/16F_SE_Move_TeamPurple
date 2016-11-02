package step_definitions;

import implementation.*;
import cucumber.api.java.en.*;
import cucumber.api.java.Before;

import static org.junit.Assert.*;

import java.io.IOException;
/**
 * @author Sebastian Snyder
 */
public class ClassMoverTest
{
	@Before
	public void Before() throws Exception
	{
		CSV.DEBUG_MODE = true;
		ClassMover C = new ClassMover();
		C.main("IT101.01");
	}


	@Given("^A \"(.*?)\" teaches \"(.*?)\"$")
	public void aTeaches(String profName, String course) throws Throwable 
	{
    	// Write code here that turns the phrase above into concrete actions
    	throw new PendingException();
	}

	@Given("^Student with \"(.*?)\" is enrolled \"(.*?)\"$")
	public void studentWithIsEnrolled(String banner, String course) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}

/**
 * An Exception that exists purely for my convenience. I'll throw it if and when I need
 * to fail a test, but assertions aren't sufficiently elegant or logical for my purposes.
 */
class TestFailedException extends Exception
{
	//So that the compiler stops yelling at me
	private static final long serialVersionUID = 1L;
	
	public TestFailedException(String M)
	{
		super(M);
	}
}
