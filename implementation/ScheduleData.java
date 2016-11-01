package implementation;

/**
 * A class that holds what days and times a course meets.
 * 
 * @author Sebastian Snyder
 */
public class ScheduleData
{
	private final TimeRange[] Days;
	
	public ScheduleData()
	{
		Days = new TimeRange[7];
	}
}

class TimeRange
{
	public byte StartHour, StartMinute;
	public byte EndHour, EndMinute;
}

