package implementation;

/**
 * A class that holds what days and times a course meets.
 * 
 * @author Sebastian Snyder
 */
public class ScheduleData
{
	private final TimeRange[] Data;
	
	public ScheduleData()
	{
		Data = new TimeRange[Day.values().length];
	}
	
	public void setData(Day D, byte StartHr, byte StartMn, byte EndHr, byte EndMn)
	{
		if(Data[D.ordinal()] == null)
		{
			TimeRange T = new TimeRange();
			T.StartHour = StartHr;		T.StartMinute = StartMn;
			T.EndHour = EndHr;			T.EndMinute = EndMn;
			Data[D.ordinal()] = T;
		}
		else
		{
			throw new IllegalStateException("Course Data for "+D.name()+" defined twice.");
		}
	}

	public void setData(Day day, int Sh, int Sm, int Eh, int Em) {
		setData(day,(byte)Sh,(byte)Sm,(byte)Eh,(byte)Em);
	}
}

class TimeRange
{
	public byte StartHour, StartMinute;
	public byte EndHour, EndMinute;
}

