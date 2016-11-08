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
	private final HashMap<String,HashMap<String,Course>> Courses;
    private final HashMap<String,Professor> Professors;
	private static CSV data = null;
	
	public HashMap<String,Course> getCoursesMap(String termcode)
	{
		return Courses.get(termcode);
	}
	public HashMap<String, Student> getStudentsMap()
	{
		return Students;
	}
	public HashMap<String, Professor> getProfessorsMap()
	{
		return Professors;
	}
	
	public ClassMover() throws IOException
	{
		Students = new HashMap<String,Student>();
		Courses = new HashMap<String,HashMap<String,Course>>();
		Professors = new HashMap<String,Professor>(500);
		
		
		String[] columnArrays = new String[] {"Term Code", "Class Code", "Subject Code", "Course Number", "Section Number",
											"Instructor Name", "Banner ID", "Begin Time 1", "End Time1", "Bldg Code1", "Room Code1",
											"Monday Ind1", "Tuesday Ind1", "Wednesday Ind1", "Thursday Ind1", "Friday Ind1", "Saturday Ind1",
											"Sunday Ind1", "Ovrall Cumm GPA  Hours Earned", "Section Max Enrollment"};
		if(data == null)
			data = CSV.openColumns("cs374_f16_anon.csv", columnArrays);
		//data.printToStream(System.out, 6, 1, 50);
		for(int i = 0;i < data.rowCount();i++)
		{

            String TimeStart = data.getDataPoint("Begin Time 1",i);
            String TimeEnd = data.getDataPoint("End Time1", i);
            
            if(TimeStart.equals("") || TimeEnd.equals(""))
            	continue;
            
            String TermCode = data.getDataPoint("Term Code",i);
            String Course = data.getDataPoint("Subject Code", i) + data.getDataPoint("Course Number", i)
            			+ "." + String.format("%2s", data.getDataPoint("Section Number", i)).replaceFirst(" ", "0");
            String bannerID = data.getDataPoint("Banner ID", i);
            String profName = data.getDataPoint("Instructor Name", i);
            
            Student S;		Professor P;		Course C;
            HashMap<String,Course> Cmap;
            
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
            
            if(!Courses.containsKey(TermCode))
            {
            	Cmap = new HashMap<String,Course>();
            	Courses.put(TermCode, Cmap);
            }
            else Cmap = Courses.get(TermCode);
            	
            if(!Cmap.containsKey(Course))
            {
                C = new Course(TermCode,Course,P);
                
                boolean[] HasDay = new boolean[Day.values().length];
                HasDay[0] = !data.getDataPoint("Sunday Ind1", i).equals("");
                HasDay[1] = !data.getDataPoint("Monday Ind1", i).equals("");
                HasDay[2] = !data.getDataPoint("Tuesday Ind1", i).equals("");
                HasDay[3] = !data.getDataPoint("Wednesday Ind1", i).equals("");
                HasDay[4] = !data.getDataPoint("Thursday Ind1", i).equals("");
                HasDay[5] = !data.getDataPoint("Friday Ind1", i).equals("");
                HasDay[6] = !data.getDataPoint("Saturday Ind1", i).equals("");
	            
                for(int d = 0;d < HasDay.length;d++)
                {
                	if(HasDay[d])
                		C.setClassPeriod(Day.values()[d],Integer.parseInt(TimeStart),Integer.parseInt(TimeEnd));
                }
                
                Cmap.put(Course,C);
            }
            else C = Cmap.get(Course);
               
            C.addStudent(S);
            S.addCourse(C);
		}
        
	}

	public static void main(String... args) throws Exception
	{
		ClassMover Mover = new ClassMover();
		//System.out.println(String.format("%2s", data.getDataPoint("Term Code", 1)).replaceFirst(" ","0"));
	}
}
