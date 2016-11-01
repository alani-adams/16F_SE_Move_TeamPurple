package implementation;

import java.util.HashSet;

/**
 * A class that represents a student.
 * This class contains references to all of the student's courses.
 * 
 * @author Sebastian Snyder
 */
public class Student
{
	private HashSet<Course> Courses;
	private String Banner;
	
	public Student(String banner)
	{
		Banner = banner;
		Courses = new HashSet<Course>();
	}

}
