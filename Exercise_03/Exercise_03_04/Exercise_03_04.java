/*
(Random month) Write a program that randomly generates an integer between 1
and 12 and displays the English month name January, February, …, December for
the number 1, 2, …, 12, accordingly.
*/
public class Exercise_03_04 {
	public static void main(String[] args) {
		// Generate an integer between 1 and 12.
		int month = (int)((Math.random() * 12));

		// Display the English month name
		switch (month)
		{
			case 0: System.out.println("January"); break;
			case 1: System.out.println("February"); break;
			case 2: System.out.println("March"); break;
			case 3: System.out.println("April"); break;
			case 4: System.out.println("May"); break;
			case 5: System.out.println("June"); break;
			case 6: System.out.println("July"); break;
			case 7: System.out.println("August"); break;
			case 8: System.out.println("September"); break;
			case 9: System.out.println("October"); break;
			case 10: System.out.println("November"); break;
			case 11: System.out.println("December");
		}
	}
}
