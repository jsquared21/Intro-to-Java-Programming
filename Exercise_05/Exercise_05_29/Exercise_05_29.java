/*
(Display calendars) Write a program that prompts the user to enter the year and
first day of the year and displays the calendar table for the year on the console. For
example, if the user entered the year 2013, and 2 for Tuesday, January 1, 2013,
your program should display the calendar for each month in the year, as follows:
									January 2013
							Sun Mon Tue Wed Thu Fri Sat
							 			1   2   3   4   5
							 6   7   8   9  10  11  12
							13  14  15  16  17  18  19
							20  21  22  23  24  25  26
							27  28  29  30  31
*/
import java.util.Scanner;

public class Exercise_05_29 {
	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the year and first day of the year
		System.out.print("Enter year: ");
		int year = input.nextInt();
		System.out.print("Enter first day of the year: ");
		int day = input.nextInt();

		// Create header of calender 
		String header; 
		System.out.println();
		for (int month = 1; month <= 12; month++) {
			header = "";
			// Concat current month string to header
			switch (month) { 
				case 1: header += "January "; break;
				case 2: header += "February "; break;
				case 3: header += "March "; break;
				case 4: header += "April "; break;
				case 5: header += "May "; break;
				case 6: header += "June "; break;
				case 7: header += "July "; break;
				case 8: header += "August "; break;
				case 9: header += "September "; break;
				case 10: header += "October "; break;
				case 11: header += "November "; break;
				case 12: header += "December "; break;
			}
			// Concat current year to header
			header += year + "";

			// Center header string
			for (int b = 0; b < 23 - (header.length() / 2); b++) {
				System.out.print(" ");
			}

			// Display header and days of the week string
			System.out.println(
				header + "\n-----------------------------------------------\n " +
				"Sun    Mon    Tue    Wed    Thu    Fri    Sat");

			// Compute day of the week
			day %= 7;
			for (int b = 0; b <= day * 7; b++) {
				System.out.print(" ");
			}

			// Compute last day of present month
			int lastDay = 0;
			if ( month == 1 || month == 3  || month == 5 || month == 7 ||
				  month == 8 || month == 10 ||month == 12)
				lastDay += 31;
			else if (month == 4 || month == 6 || month == 9 || month == 11)
				lastDay += 30;
			else { // Test for leap year
				if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
					lastDay += 29;
				else
					lastDay += 28;
			}

			// Display calender for current month
			for (int d = 1; d <= lastDay; d++) {
				// Add a black space before numbers less than 10
				if (d < 10) 
					System.out.print(" ");
				// Start new line after satuarday
				if (day % 7 == 6)
					System.out.print(d + "\n ");
				else {
					System.out.print(d + "     ");
					// After last day of the month go to new line
					if (d == lastDay) 
						System.out.println();
				}
				day++; // increment day

			}
			System.out.println();
		}
	}
}  