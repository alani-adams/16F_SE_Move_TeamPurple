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


/**
 * 
 * @author Sebastian Snyder
 */
public class ClassMover
{
	private final HashMap<String,Student> Students;
	private final HashMap<String,Course> Courses;
    private final HashMap<String,Professor> Professors;
	
	public ClassMover() throws IOException
	{
		Students = new HashMap<String,Student>();
		Courses = new HashMap<String,Course>();
		Professors = new HashMap<String,Professor>();
		
		
		String[] columnArrays = new String[] {"Term Code", "Class Code", "Subject Code", "Course Number", "Section Number",
											"Instructor Name", "Banner ID", "Begin Time 1", "End Time1", "Bldg Code1", "Room Code1",
											"Monday Ind1", "Tuesday Ind1", "Wednesday Ind1", "Thursday Ind1", "Friday Ind1", "Saturday Ind1",
											"Sunday Ind1", "Ovrall Cumm GPA  Hours Earned", "Section Max Enrollment"};

		CSV data = CSV.openColumns("cs374_anon-modified.csv", columnArrays);
		//data.printToStream(System.out, 6, 1, 50);
		for(int i = 0;i < data.columnCount();i++)
		{
            String courseID = data.getDataPoint("Subject Code", i) + data.getDataPoint("Course Number", i) + "." + data.getDataPoint("Section Number", i) + " ";
            courseID += String.format("%2s", data.getDataPoint("Term Code",i)).replaceAll(" ", "0");
            String bannerID = data.getDataPoint("Banner ID", i);
            String profName = data.getDataPoint("Instructor Name", i);
            Student S;		Professor P;		Course C;
            
			if(!Students.containsKey(bannerID))
			{
                S = new Student(bannerID);
                Students.put(bannerID, S);
			}
            else S = Students.get(bannerID);
			
            if(!Professors.containsKey(profName))
            {
                P = new Professor(profName);
                Professors.put(profName, P);
            }
            else P = Professors.get(profName);

            if(!Courses.containsKey(courseID))
            {
                C = new Course(courseID,P);
                
                boolean[] HasDay = new boolean[Day.values().length];
                HasDay[0] = !data.getDataPoint("Sunday Ind1", i).equals("");
                HasDay[1] = !data.getDataPoint("Monday Ind1", i).equals("");
                HasDay[2] = !data.getDataPoint("Tuesday Ind1", i).equals("");
                HasDay[3] = !data.getDataPoint("Wednesday Ind1", i).equals("");
                HasDay[4] = !data.getDataPoint("Thursday Ind1", i).equals("");
                HasDay[5] = !data.getDataPoint("Friday Ind1", i).equals("");
                HasDay[6] = !data.getDataPoint("Saturday Ind1", i).equals("");
                
                int TimeStart = Integer.parseInt(data.getDataPoint("Begin Time 1",i));
                int TimeEnd = Integer.parseInt(data.getDataPoint("End Time1", i));
                
                for(int d = 0;d < HasDay.length;d++)
                {
                	if(HasDay[d])
                		C.setClassPeriod(Day.values()[d],TimeStart,TimeEnd);
                }
                
                Courses.put(courseID,C);
            }
            else C = Courses.get(courseID);
               
            C.addStudent(S);
		}
        
	}

	public static void main(String... args) throws Exception
	{
		ClassMover Mover = new ClassMover();
		System.out.println(Mover);
	}
}
