package implementation;

import java.util.HashSet;

/**
 * A class that represents a course and the semester it's in.
 * 
 * @author Sebastian Snyder
 */
public class Course
{
	private final String COURSE_ID;
	private final HashSet<Student> Students;
	private final Professor Instructor;
	private final ScheduleData CourseTimes;

	public Course(String courseID, Professor p)
	{
		COURSE_ID = courseID;
		Instructor = p;
		p.addCourse(this);
		Students = new HashSet<Student>();
		CourseTimes = new ScheduleData();
	}


	/**
	 * Gets the Course ID for this course
	 * @return the Course ID for this course
	 */
	public String getCourseID()
	{
		return COURSE_ID;
	}

	/**
	 * @return the Professor of this course
	 */
	public Professor getInstructor()
	{
		return Instructor;
	}
	
	/**
	 * Adds a student to the course
	 * @param s the Student to add
	 */
	public void addStudent(Student s)
	{
		Students.add(s);
	}	
	/**
	 * Sets the timeslot of this class for a given day of the week
	 * @param day The day to set
	 * @param timeStart The start time, where timeStart/100 is the
	 *        hour and timeStart%100 is the minute.
	 * @param timeEnd The end time, where timeEnd/100 is the hour
	 *        and timeEnd%100 is the minute.
	 */
	public void setClassPeriod(Day day, int timeStart, int timeEnd)
	{
		 CourseTimes.setData(day, timeStart/100, timeStart%100,   timeEnd/100, timeEnd%100);
	}

}