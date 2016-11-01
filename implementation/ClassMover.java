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

/**
 * 
 * @author Sebastian Snyder
 */
public class ClassMover
{
	private CSV data;
	
	public ClassMover() throws IOException
	{
		String[] columnArrays = new String[] {"Term Code", "Class Code", "Subject Code", "Course Number", "Section Number",
											"Instructor Name", "Banner ID", "Begin Time 1", "End Time1", "Bldg Code1", "Room Code1",
											"Monday Ind1", "Tuesday Ind1", "Wednesday Ind1", "Thursday Ind1", "Friday Ind1", "Saturday Ind1",
											"Sunday Ind1", "Ovrall Cumm GPA  Hours Earned", "Section Max Enrollment"};

		data = CSV.openColumns("cs374_anon-modified.csv", columnArrays);
		data.printToStream(System.out, 6, 1, 50);
	}

	public static void main(String... args) throws Exception
	{
		new ClassMover();

		System.out.println(args[0]);
	}
}
