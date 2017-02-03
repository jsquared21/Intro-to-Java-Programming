import java.util.Scanner;

/*
Adapted by Sleekpanther from SquirrelCoder's initial idea from 29-Jan-17.
Uses arrays, even though they technically aren't introduced until chapter 7. But it simplifies this a lot

6.34 (Print calendar) Programming Exercise 3.21 uses Zeller's congruence to calculate
the day of the week. Simplify Listing 6.12, PrintCalendar.java, using Zeller's
algorithm to get the start day of the month.


Exercise 3.21 details
(Science: day of the week) Zeller's congruence is an algorithm developed by
Christian Zeller to calculate the day of the week. The formula is:
h=(q + (26(m+1))/10 + k + k/4 + j/4 +5*j)%7
h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5: Thursday, 6: Friday).
q is the day of the month.
m is the month (3: March, 4: April, ..., 12: December). January and February are counted as months 13 and 14 of the previous year.
j is the century (i.e. year/100)
k is the year of the century (i.e., year % 100).

Note that the division in the formula performs an integer division. Write a program
that prompts the user to enter a year, month, and day of the month, and
displays the name of the day of the week.
(Hint: January and February are counted as 13 and 14 in the formula, so you need
to convert the user input 1 to 13 and 2 to 14 for the month and change the year to the previous year.)
 */
public class PrintCalendar {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// get & validate user year
		System.out.print("Enter full year (e.g., 2012): ");
		int year = keyboard.nextInt();
		while (!isValidYear(year)) {				//validate input
			System.out.println("Invalid Year!");
			System.out.print("Enter full year (e.g., 2012): ");
			year = keyboard.nextInt();
		}
		
		// get & validate user month
		System.out.print("Enter month as number between 1 and 12: ");
		int month = keyboard.nextInt();
		while (!isValidMonth(month)) {			//validate input
			System.out.println("Invalid Month!");
			System.out.print("Enter month as number between 1 and 12: ");
			month = keyboard.nextInt();
		}
		
		
		printCalendarHeader(month, year);	// print the calendar header

		printFirstDay(month, year);			// print the calendar first day

		printCalendarItself(month, year);	// print the calendar itself
	}

	public static boolean isValidYear(int year) {
		return year > 0;		//might want to check an upper bound, not sure if this formula works for HUGE numbers
	}

	public static boolean isValidMonth(int month) {
		return month > 0  &&  month <= 12;
	}

	public static void printCalendarHeader(int month, int year) {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "Septemter", "October", "November", "December"};

		System.out.print("\t\t"+months[month-1]+"\t");		//access the month array with a -1 offset since arrays count from 0
		System.out.println(year);
		System.out.println("---------------------------");
		
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
	}

	public static void printFirstDay(int month, int year) {
		int firstDay = dayOfWeek(1, month, year);		//calculate the 1st day

		String leadingTabs = "1";		//Holds any leading tabs to align 1st row of numbers in a calendar. This takes care of firstDay=1

		//cases for firstDay between 2 & 6 (adds a "\t" at the beginning of the string each iteration)
		//Loop starts from 1 since we want 1 less tab than the value of firstDay (firstDay=1 is 0 tabs, firstDay=2 is 1 tab, firstDay=3 is 2 tabs, firstDay=4 is 3 tabs, firstDay=5 is 4 tabs)
		for(int i = 1; i<firstDay; i++){
			leadingTabs = "\t" + leadingTabs;
		}
		if(firstDay == 0){			//reset it & ignore what the loop did if it's 0. THIS IS A SPECIAL CASE. We want 6 tabs
			leadingTabs = "\t\t\t\t\t\t1";
		}

		System.out.print(leadingTabs + "\t");
	}

	public static void printCalendarItself(int month, int year) {
		// find out the last day of that month
		// whether it's 28/29/30/31 days
		int lastDayOfMonth = lastDayOfMonth(month, year);

		// print the calendar itself
		for (int i = 2; i <= lastDayOfMonth; i++) {
			int printedDay = dayOfWeek(i, month, year);
			if (printedDay == 1) {
				System.out.println();
			}
			System.out.print(i + "\t");
		}
	}
	
	//Implement Zeller's Algorithm
	public static int dayOfWeek(int dayOfMonth, int month, int year) {
		if (month == 1 || month == 2) {
			month = month + 12;
			year--;
		}
		int q, m, j, k;
		q = dayOfMonth;
		m = month;			//adjusted month (corrected for January & February being 13 & 14 respectively)
		j = year/100;		//century
		k = year%100;		//year of the century
		int dayOfTheWeek = (q + (26*(m+1) /10) + k + k/4 + j/4 + (5*j)) % 7;		//performs integer division where appropriate (like the Algorithms wants)
		return dayOfTheWeek;
	}

	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	public static int lastDayOfMonth(int month, int year) {
		int lastDayOfMonth;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			lastDayOfMonth = 31;
		} else if (month == 2) {
			if (isLeapYear(year)) {
				lastDayOfMonth = 29;
			} else {
				lastDayOfMonth = 28;
			}
		} else {
			lastDayOfMonth = 30;
		}
		return lastDayOfMonth;
	}
	
}