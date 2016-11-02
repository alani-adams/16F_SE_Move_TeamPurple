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
	private final HashSet<Course> Courses;
	private final String BANNER;
    
	public Student(String banner)
	{
		BANNER = banner;
		Courses = new HashSet<Course>();
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
	 * Adds a course to the list of this student's courses
	 * @param course The course to add
	 */
	public void addCourse(Course c)
	{
		if(Courses.contains(c))
		{
			Courses.add(c);
			c.addStudent(this);
		}
	}

}
