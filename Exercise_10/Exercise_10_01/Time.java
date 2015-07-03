                   //UML diagram
/************************************************
*                      Time                     *
*-----------------------------------------------*
* -hour: long                                   *
* -minute: long                                 *
* -second: long                                 *
* Time()                                        *
* Time(elapseTime: long)                        *
* Time(hour: long, minute: long, second: long)  *
* getHour(): long                               *
* getMinute(): long                             *
* getSecond(): long                             *
* setTime(elapseTime: long)                     *
************************************************/

// Implement Time class
public class Time {
	// Data fields
	private long hour;
	private long minute;
	private long second;

	// Creates a Time object for the current time
	Time() {
		this(0);	
	}

	// Constructs a Time object with a specified elapsed 
	// time since midnight, January 1, 1970, in milliseconds.
	Time(long elapseTime) {
		setTime(elapseTime);
	}

	// Constructs a Time object with the specified hour, minute, and second
	Time(long hour, long minute, long second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// Return hour
	public long getHour() {
		return hour;
	}

	// Return minute
	public long getMinute() {
		return minute;
	}

	// Return second
	public long getSecond() {
		return second;
	}

	// Sets a new time for the object using the elapsed time
	public void setTime(long elapseTime) {
		long totalMilliseconds = System.currentTimeMillis();
		long totalSeconds = totalMilliseconds / 1000;
		second = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;
		minute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		hour = totalHours % 24;

		if (elapseTime > 0) {
			totalSeconds = elapseTime / 1000;
			second += totalSeconds % 60;
			totalMinutes = totalSeconds / 60;
			minute += totalMinutes % 60;
			totalHours = totalMinutes / 60;
			hour += totalHours % 24;
		}
	}
}