/*
(Number of days in a year) Write a method that returns the number of days in a
year using the following header:
public static int numberOfDaysInAYear(int year)
Write a test program that displays the number of days in year from 2000 to 2020.
*/
public class Exercise_06_16 {
	/** Main Method */
	public static void main(String[] args) {
		// Display the number of days in year 2000 to 2020
		System.out.println("Year     Days in year");
		for (int year = 2000; year <= 2020; year++) {
			System.out.println(year + "         " + numberOfDaysInAYear(year));
		}
	}
	/** Method numberOfDaysInAYear returns the number of days in a year*/
	public static int numberOfDaysInAYear(int year){
		if (isLeapYear(year))
			return 366;
		else
			return 365;
	}

	/** Method isLeapYear tests if a year is a leap year*/
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
}
