/*******************************************
*                MyDate                    *
*------------------------------------------*
* -year: int                               *
* -month: int                              *
* -day: int                                *
* +MyDate()                                *
* +MyDate(elapsedTime: long)               *
* +MyDate(year: int, month: int, day: int) *
* +getYear(): int                          *
* +getMonth(): int                         *
* +getDay(): int                           *
* +setDate(elapsedTime: long)              *
*******************************************/

import java.util.GregorianCalendar;

// Implement MyDate class
public class MyDate {
	// Data Fields
	private int year;
	private int month;
	private int day;

	/** Creates a MyDate object for the current date */
	MyDate() {
		GregorianCalendar calander = new GregorianCalendar();
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/** Creates a MyDate object with a specified elapsed time
	*	 since midnight, January 1, 1970, in milliseconds */
	MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}

	/** Creates a MyDate object with the 
	*   specified year, month, and day */
	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/** Return year */
	public int getYear() {
		return year;
	}

	/** Return month */
	public String getMonth() {
		String m = String.valueOf(month + 1);
		return (month < 10 ? "0" + m : m);
	}

	/** Return day */
	public String getDay() {
		String d = String.valueOf(day);
		return (day < 10 ? "0" + d : d);
	}

	/** Sets a new date for the object using the elapsed time */
	public void setDate(long elapsedTime) {
		GregorianCalendar calander = new GregorianCalendar();
		calander.setTimeInMillis(elapsedTime);
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	} 
}