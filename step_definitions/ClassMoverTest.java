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
    	//for(Course c2: C.getCoursesMap().values())
    	//	System.out.println(") -> "+c2.getCourseID());
    	Assert.assertTrue(c.getInstructor() == p);
	}

	@Given("^Student with \"(.*?)\" is enrolled \"(.*?)\"$")
	public void studentWithIsEnrolled(String banner, String course) throws Throwable 
	{
	    Student s = C.getStudentsMap().get(banner);
	    Course c = C.getCoursesMap().get(course);
	    System.out.println(banner+":");
	    for(Course c2:s.getCourseSet())
	    	System.out.println("  "+c2.getCourseID());
	    Assert.assertTrue(s.getCourseSet().contains(c));
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
