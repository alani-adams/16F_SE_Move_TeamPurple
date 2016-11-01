package implementation;

import java.util.HashSet;

/**
 * A class that represents a course and the semester it's in.
 * 
 * @author Sebastian Snyder
 */
public class Course
{
	private String CourseID;
	private HashSet<Student> Students;
	private Professor Instructor;
	private ScheduleData CourseTimes;
	
	public Course(String courseID, HashSet<Student> students, Professor instructor, ScheduleData courseTimes)
	{
        CourseID = courseID;
        Students = students;
        Instructor = instructor;
        CourseTimes = courseTimes;
	}

}
