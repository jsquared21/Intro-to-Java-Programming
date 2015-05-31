/*
(Days of a month) Write a program that prompts the user to enter a year and the
first three letters of a month name (with the first letter in uppercase) and displays
the number of days in the month.
*/
import java.util.Scanner;

public class Exercise_04_17 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a year and
		// the first three letter of a month name
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		System.out.print("Enter a month: ");
		String month = input.next();

		// Test for leap year
		boolean leapYear = 
			((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

		// Display the number of day in the month
		System.out.print(month + " " + year + " has ");
		
		if ( month.equals("Jan") || month.equals("Mar") || 
			  month.equals("May") || month.equals("Jul") ||
			  month.equals("Aug") || month.equals("Oct") ||
			  month.equals("Dec"))
			System.out.println(31 + " days");
		else if (month.equals("Apr") || month.equals("Jun") || 
			month.equals("Sep") || month.equals("Nov"))
			System.out.println(30 + " days");
		else
			System.out.println(((leapYear) ? 29 : 28) + " days");	
	}
}