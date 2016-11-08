package step_definitions;

import implementation.*;
import junit.framework.Assert;
import cucumber.api.java.en.*;
import cucumber.api.java.Before;
/**
 * @author Sebastian Snyder
 */
public class ClassMoverTest
{
	private ClassMover C;
	
	@Before
	public void Before() throws Exception
	{
		CSV.DEBUG_MODE = true;
		C = new ClassMover();
	}


	@Given("^A \"(.*?)\" teaches \"(.*?)\"$")
	public void aTeaches(String professor, String course) throws Throwable 
	{
    	Professor p = C.getProfessorsMap().get(professor);
    	Course c = C.getCoursesMap().get(course);
    	Assert.assertTrue(c.getInstructor() == p);
	}

	@Given("^Student with \"(.*?)\" is enrolled \"(.*?)\"$")
	public void studentWithIsEnrolled(String banner, String course) throws Throwable 
	{
	    Student s = C.getStudentsMap().get(banner);
	    Course c = C.getCoursesMap().get(course);
	    Assert.assertTrue(s.getCourseSet().contains(c));
	}
	
	@Given("^Student \"(.*?)\" on \"(.*?)\" between \"(.*?)\" and \"(.*?)\" in term \"(.*?)\"$")
	public void studentOnBetweenAndInTerm(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
    	// Write code here that turns the phrase above into concrete actions
    	throw new PendingException();
	}

	@Then("^the student \"(.*?)\" available$")
	public void theStudentAvailable(String arg1) throws Throwable {
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
