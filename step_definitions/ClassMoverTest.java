package step_definitions;

import implementation.*;
import junit.framework.Assert;
import cucumber.api.java.en.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	Course TestCourse;
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
	
	
	@Given("^course \"(.*?)\" and time slot \"(.*?)\" to \"(.*?)\" on \"(.*?)\"$")
	public void course_and_and_and(String arg1, short arg2, short arg3, char arg4) throws Throwable {
		String[] Data = arg1.split(" ");
		//System.out.println(Arrays.toString(Data));
		HashMap<String,Course> Cmap = C.getCoursesMap(Data[0]);
		//System.out.println(Cmap);
	    TestCourse = Cmap.get(Data[1]);
	    TestDay = Day.getFromChar(arg4);
	    TestStartTime = arg2;
	    TestEndTime = arg3;
	    Assert.assertNotNull(TestCourse);
	}

	@Then("^\"(.*?)\" amount of students have a conflict")
	public void amount_of_students_have_a_conflict_and_the_professor_have_a_conflict(int arg1) throws Throwable
	{
	    Assert.assertEquals(arg1, C.GetStudentConflicts(TestCourse, TestDay, TestStartTime, TestEndTime).size());
	}
	
	@Then("^the professor \"(.*?)\" have a conflict$")
	public void the_professor_have_a_conflict(String arg1) throws Throwable
	{
		//System.out.println(C.CanMoveProfessor(TestCourse, TestDay, TestStartTime, TestEndTime));
	    Assert.assertTrue(arg1.equals("does") ^ C.CanMoveProfessor(TestCourse, TestDay, TestStartTime, TestEndTime));
	}
	@Given("^course \"(.*?)\" and \"(.*?)\"$")
	public void courseAnd(String course) throws Throwable {
    		// Write code here that turns the phrase above into concrete actions
    		throw new PendingException();
	}

	@Then("^\"(.*?)\" \"(.*?)\" fit this course\\.$")
	public void fitThisCourse(String rmCode, String check) throws Throwable {
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
