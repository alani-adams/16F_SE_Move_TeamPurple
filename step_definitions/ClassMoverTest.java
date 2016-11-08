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
	private static ClassMover C;
	
	Student TestStu;
	Professor TestProf;
	String TestTerm;
	Day TestDay;
	short TestStartTime;
	short TestEndTime;
	
	@Before
	public void Before() throws Exception
	{
		if(C == null)
		{
			C = new ClassMover();
		}
	}
	
	@Given("^Student \"(.*?)\" on \"(.*?)\" between \"(.*?)\" and \"(.*?)\" in term \"(.*?)\"$")
	public void student_on_between_and_in_term(String Banner, String DayChar, String Ts, String Te, String TermCode) throws Throwable {
	    TestStu = C.getStudentsMap().get(Banner);
	    TestDay = Day.getFromChar(DayChar.charAt(0));
	    TestTerm = TermCode;
	    TestStartTime = Short.parseShort(Ts);
	    TestEndTime = Short.parseShort(Te);
	    Assert.assertNotNull(TestStu);
	}
	
	@Then("^the student \"(.*?)\" available$")
	public void the_student_available(String is) throws Throwable {
	    Assert.assertTrue(is.equals("is not") ^ TestStu.SlotFree(TestTerm, TestDay, TestStartTime, TestEndTime));
	}

	@Given("^Professor \"(.*?)\" on \"(.*?)\" between \"(.*?)\" and \"(.*?)\" in term \"(.*?)\"$")
	public void professor_on_between_and_in_term(String Pname, String DayChar, String Ts, String Te, String TermCode) throws Throwable {
		TestProf = C.getProfessorsMap().get(Pname);
	    TestDay = Day.getFromChar(DayChar.charAt(0));
	    TestTerm = TermCode;
	    TestStartTime = Short.parseShort(Ts);
	    TestEndTime = Short.parseShort(Te);
	    Assert.assertNotNull(TestProf);
	}

	@Then("^the Professor \"(.*?)\" available$")
	public void the_Professor_available(String is) throws Throwable {
	    Assert.assertTrue(is.equals("is not") ^ TestProf.SlotFree(TestTerm, TestDay, TestStartTime, TestEndTime));
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
