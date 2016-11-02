package implementation;

import java.util.HashSet;

/**
 * A class that represents a professor.
 * This class stores all of the professor's courses.
 * 
 * @author Sebastian Snyder
 */
public class Professor
{
	private final String NAME;
	private final HashSet<Course> Courses;
	
	public Professor(String name)
	{
        NAME = name;
        Courses = new HashSet<Course>();
	}

	/**
	 * Gets this Professor's name.
	 * @return this Professor's name.
	 */
	public String getName()
	{
		return NAME;
	}

	public void addCourse(Course c)
	{
		Courses.add(c);
	}

}
