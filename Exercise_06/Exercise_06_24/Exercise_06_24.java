/*
(Display current date and time) Listing 2.7, ShowCurrentTime.java, displays the
current time. Improve this example to display the current date and time. The calendar
example in Listing 6.12, PrintCalendar.java, should give you some ideas on
how to find the year, month, and day.
*/
public class Exercise_06_24 {
	/** Main Method */
	public static void main(String[] args) {
		// Display current date and time
		System.out.println(time());
		System.out.println(date());
		System.out.println(month());
		System.out.println(day());
	}

	/** Method time returns the current time *************************************/
	public static String time() {
		final long TIME_ZONE_OFFSET = -4; // USA Time zone offset to GMT 

		// Obtain the total milliseconds since midnight, Jan 1, 1970
		long totalTime = System.currentTimeMillis();

		// Obtain total seconds since midnight, Jan 1, 1970
		totalTime /= 1000;

		// Obtain current minute and second
		String currentMinuteAndSecond = ""; // Holds Minutes and Seconds
		for (int i = 0; i < 2; i++) {
			currentMinuteAndSecond = 
				(totalTime % 60 < 10 ? ":0" + totalTime % 60 : ":" + totalTime % 60)
				+ currentMinuteAndSecond;
			totalTime /= 60;
		}
		
		String setAmOrPm = "";
		// Obtain current hour in 12 format
		long currentHour = totalTime % 24;
		if (currentHour == 0)
			currentHour = 24;

		if (currentHour > 12) {
			currentHour -= 12;
			setAmOrPm = " PM";
		}
		else
			setAmOrPm = " AM";

		//Add time zone offset to GMT
		currentHour += TIME_ZONE_OFFSET;

		return currentHour + currentMinuteAndSecond + setAmOrPm;
	}

	/** Method date **************************************************************/
	public static String date() {
		
		return year() + "";
	}

	/** Method year returns the current year *************************************/
	public static int year() {
		// Obtain the current year
		int currentYear = 
			(int)(System.currentTimeMillis() / millisecondPerYear()) + 1970;
		
		return currentYear;
	}

	/** Method month returns the current month ***********************************/
	public static int month() {
		// Obtain the current month
		int currentMonth =
			(int)((System.currentTimeMillis() % millisecondPerYear()) 
			/ millisecondsPerMonth());
		return currentMonth + 1;
	}

	/** Method day returns the current day ***************************************/
	public static int day(){
		// Obtain the current day
		return  getTotalNumberOfDays(year(), month());
	}

	/** Method millisecondPerYear */
	public static double millisecondPerYear() {
		return 3.15569E10;
	}

	/** Method millisecondsPerMonth */
	public static double millisecondsPerMonth() {
		return 2.63E9;
	}

	/** Get the total number of days since January 1, 1800 */
	public static int getTotalNumberOfDays(int year, int month) {
		int total = 0;	
		// Get the total days from 1800 to 1/1/year
		for (int i = 1800; i < year; i++)
		if (isLeapYear(i))
		total = total + 366;
		else
		 total = total + 365;
		
		// Add days from Jan to the month prior to the calendar month
		for (int i = 1; i < month; i++)
		total = total + getNumberOfDaysInMonth(year, i);
		
		return total;
	}

	/** Method isLeapyear */
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 400 != 0);
	}

	/** Get the number of days in a month */
	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 ||
		month == 8 || month == 10 || month == 12)
		return 31;
	
		if (month == 4 || month == 6 || month == 9 || month == 11)
		return 30;
	
		if (month == 2) return isLeapYear(year) ? 29 : 28;
		
		return 0; // If month is incorrect
	}

}