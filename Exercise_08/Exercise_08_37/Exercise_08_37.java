/*********************************************************************************
* (Guess the capitals) Write a program that repeatedly prompts the user to enter *
* a capital for a state. Upon receiving the user input, the program reports      *
* whether the answer is correct. Assume that 50 states and their capitals are    *
* stored in a twodimensional array, as shown in Figure 8.10. The program prompts *
* the user to answer all states’ capitals and displays the total correct count.  *
* The user’s answer is not case-sensitive.                                       *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_37 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Store 50 states and their capitals in a two-dimensional array
		String[][] statesAndCapitals = getData();

		int count = 0;	// Correct answer					
		// Repeatedly prompt the user to enter the capital of a state
		for (int i = 0; i < statesAndCapitals.length; i++) {
			System.out.print("What is the capital of "
				+ statesAndCapitals[i][0] + "? ");
			String capital = input.nextLine();

			if (isEqual(statesAndCapitals[i][1], capital)) {
				System.out.println("Your answer is correct");
				count++;
			}
			else {
				System.out.println("The correct answer should be " + 
					statesAndCapitals[i][1]);
			}
		}

		// Display the total correct count
		System.out.println("\nThe correct count is " + count);
	}

	/** isEqual returns true if a is equal to c */
	public static boolean isEqual(String c, String a) {
		if (c.length() != a.length())
			return false;

		for (int i = 0; i < c.length(); i++) {
			if (c.charAt(i) != a.charAt(i))
				return false;
		}

		return true;
	}

	/** getData initializes the array with the 50 states and their capitals */
	public static String[][] getData() {
		String[][] d = {
			{"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
			{"Arkansas", "Little Rock"}, {"California", "Sacramento"},
			{"Colorado", "Denver"}, {"Connecticut", "Hartford"}, 
			{"Delaware", "Dover"}, {"Florida", "Tallahassee"}, 
			{"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
			{"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
			{"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"}, 
			{"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, 
			{"Maryland", "Annapolis"}, {"Massachusetts", "Boston"}, 
			{"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, 
			{"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"}, 
			{"Montana", "Helena"}, {"Nebraska", "Lincoln"}, 
			{"Nevada	", "Carson City"}, {"New Hampshire", "Concord"}, 
			{"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, 
			{"New York", "Albany"}, {"North Carolina", "Raleigh"}, 
			{"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
			{"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"}, 
			{"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, 
			{"South Carolina", "Columbia"}, {"South Dakota", "Pierre"}, 
			{"Tennessee", "Nashville"}, {"Texas", "Austin"}, 
			{"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"}, 
			{"Virginia", "Richmond"}, {"Washington", "Olympia"}, 
			{"West Virginia", "Charleston"}, {"Wisconsin", "Madison"}, 
			{"Wyoming", "Cheyenne"}};
		return d;
	}
}