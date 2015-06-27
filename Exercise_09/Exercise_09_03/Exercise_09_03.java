/*********************************************************************************
* (Use the Date class) Write a program that creates a Date object, sets its      *
* elapsedtime to 10000, 100000, 1000000, 10000000, 100000000, 1000000000,        *
* 10000000000, and 100000000000, and displays the date and time using the        *
* toString() method, respectively.                                               *
*********************************************************************************/
public class Exercise_09_03 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Date object
		java.util.Date date = new java.util.Date();

		// Display the date and time for elapsedtime 10000,   
		// 100000, 1000000, 10000000, 100000000, 1000000000, 
		// 10000000000, and 100000000000, respectively
		System.out.println("\nThe dates and times for elapsedtimes 10000, "  +
			"100000, 1000000, 10000000,\n100000000, 1000000000, 10000000000," +
			" and 100000000000, respectively");
		for (long i = 10000; i <= 1e11; i *= 10) {
			date.setTime(i);
			System.out.println(date.toString());
		}
	}
}