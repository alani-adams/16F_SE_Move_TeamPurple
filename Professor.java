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
	private String Name;
	private HashSet<Course> Courses;
	
	public Professor(String name) {
        Name = name;
        Courses = new HashSet<Course>();
	}

}
