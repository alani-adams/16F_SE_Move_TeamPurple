//
//  THIS IS A SKELETON. ON EACH NEW ECLIPSE PROJECT:
//    Edit the batch file to reflect the actual test class and base class files.
//    Edit the comment below to match the batch file.
//    Properly set Cucumber's run configuration.
//    Remove this checklist comment.
//    

//
//  Compile with:
//      javac -cp "jars/*;." step_definitions/BaseTest.java implementation/BaseClass.java
//      java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features
//
package implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author Sebastian Snyder
 */
public class ClassMover
{
	private CSV data;
	private HashMap<String,Student> Students;
	private HashMap<String,Course> Courses;
    private HashMap<String,Professor> Professors;
	
	public ClassMover() throws IOException
	{
		String[] columnArrays = new String[] {"Term Code", "Class Code", "Subject Code", "Course Number", "Section Number",
											"Instructor Name", "Banner ID", "Begin Time 1", "End Time1", "Bldg Code1", "Room Code1",
											"Monday Ind1", "Tuesday Ind1", "Wednesday Ind1", "Thursday Ind1", "Friday Ind1", "Saturday Ind1",
											"Sunday Ind1", "Ovrall Cumm GPA  Hours Earned", "Section Max Enrollment"};

		data = CSV.openColumns("cs374_anon-modified.csv", columnArrays);
		//data.printToStream(System.out, 6, 1, 50);
		for(int i = 0;i < data.columnCount();i++)
		{
            String courseID = data.getDataPoint("Subject Code", i) + data.getDataPoint("Course Number", i) + "." + data.getDataPoint("Section Number", i) + " ";
            courseID += String.format("%02s", data.getDataPoint("Term Code",i));
            Student S;
            Professor P;
			if(!Students.containsKey(data.getDataPoint("Banner ID", i)))
                S = new Student(data.getDataPoint("Banner ID", i));
            else
               S = Students.get(data.getDataPoint("Banner ID", i));
            if(!Professors.containsKey(data.getDataPoint("Instructor Name", i)))
                  P = new Professor(data.getDataPoint("Instructor Name", i));
                else
                  P = Professors.get(data.getDataPoint("Instructor Name", i));
            
               
            
		}
        
	}

	public static void main(String... args) throws Exception
	{
		ClassMover Mover = new ClassMover();
	}
}
