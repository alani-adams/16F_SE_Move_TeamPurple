package implementation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that represents a student.
 * This class contains references to all of the student's courses.
 * 
 * @author Sebastian Snyder
 */
public class Student
{
	private final HashMap<String,ArrayList<Course>> Courses;
	private final String BANNER;
    
	public Student(String banner)
	{
		BANNER = banner;
		Courses = new HashMap<String,ArrayList<Course>>();
	}

	/**
	 * Gets this Student's Banner ID.
	 * @return the Student's Banner ID.
	 */
	public String getBanner()
	{
		return BANNER;
	}

	/**
	 * Adds a course to the list of this student's courses.
	 * Silently fails if the course has no time slots.
	 * @param course The course to add
	 */
	public void addCourse(Course c)
	{
		if(!c.hasTime())
		{
			return;
		}
		ArrayList<Course> Cs;
		String TC = c.getTermCode();
		if(!Courses.containsKey(TC))
		{
			Cs = new ArrayList<Course>();
			Courses.put(TC, Cs);
		}
		else Cs = Courses.get(TC);
		Cs.add(c);
		//Cs.sort(Course.comparator());
	}

	/**
	 * Gets the set of courses this student is taking for a particular semester
	 * @param termcode the semester to check.
	 * @return an ArrayList of courses this student is taking for the given semester
	 */
	public ArrayList<Course> getCourseSet(String termcode)
	{
		return Courses.get(termcode);
	}
	
	/**
	 * Returns wheter or not a time range is free for a given time slot on a given day in a given semester
	 * @param Termcode the semester on which to test
	 * @param D the day to test on
	 * @param ST the start timecode
	 * @param ET the end timecode
	 * @return whether or not the timeslot is free
	 */
	public boolean SlotFree(String Termcode, Day D,short ST, short ET)
	{
		for(Course c: Courses.get(Termcode))
		{
			if(!c.SlotFree(D,ST,ET))
			{
				return false;
			}
		}
		return true;
	}
}
