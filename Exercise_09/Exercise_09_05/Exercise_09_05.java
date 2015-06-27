/*********************************************************************************
* (Use the GregorianCalendar class) Java API has the GregorianCalendar class in  *
* the java.util package, which you can use to obtain the year, month, and day of *
* a date. The no-arg constructor constructs an instance for the current date,    *
* and the methods get(GregorianCalendar.YEAR), get(GregorianCalendar.MONTH), and *
* get(GregorianCalendar.DAY_OF_MONTH) return the year, month, and day.           *
* Write a program to perform two tasks:                                          *
*                                                                                *
* ■ Display the current year, month, and day.                                    *
* ■ The GregorianCalendar class has the setTimeInMillis(long), which can be used *
* to set a specified elapsed time since January 1, 1970. Set the value to        *
* 1234567898765L and display the year, month, and day.                           *
*********************************************************************************/
import java.util.GregorianCalendar;

public class Exercise_09_05 {
	/** Main method */
	public static void main(String[] args) {
		// Create a GregorianCalendar object
		GregorianCalendar calender = new GregorianCalendar();

		// Display the current year, month, and day in format Mth/Day/Year
		System.out.print("\nCurrent year, month, and day in format Mth/Day/Year: ");
		System.out.println(calender.get(calender.MONTH) + "/" +
			calender.get(calender.DAY_OF_MONTH) + "/" + calender.get(calender.YEAR));

		// Set elapsed time since January 1, 1970 to 1234567898765L
		calender.setTimeInMillis(1234567898765L);

		// Display the year, month and day
		System.out.print("\nElapsed time since January 1, 1970 set to " +
			"1234567898765L in format Mth/Day/Year: ");
		System.out.println(calender.get(calender.MONTH) + "/" +
			calender.get(calender.DAY_OF_MONTH) + "/" + calender.get(calender.YEAR));
	}
}