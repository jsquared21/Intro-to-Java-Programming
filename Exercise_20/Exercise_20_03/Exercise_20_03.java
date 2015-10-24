/*********************************************************************************
* (Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs   *
* of states and capitals so that the questions are displayed randomly.           *
*********************************************************************************/
import java.util.*;

public class Exercise_20_03 {
	protected static List<String> states = new ArrayList<>();
	protected static List<String> capitals = new ArrayList<>();

	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Store 50 states and their capitals in two lists
		getData();

		int count = 0;	// Correct answer					
		// Repeatedly prompt the user to enter the capital of a state
		for (int i = 0; i < states.size(); i++) {
			System.out.print("What is the capital of "
				+ states.get(i) + "? ");
			String capital = input.nextLine();

			if (isEqual(capitals.get(i), capital)) {
				System.out.println("Your answer is correct");
				count++;
			}
			else {
				System.out.println("The correct answer should be " + 
					capitals.get(i));
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
	public static void getData() {
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

		// Seperate the states and capitals into two lists
		for (int i = 0; i < d.length; i++) {
			states.add(d[i][0]);
			capitals.add(d[i][1]);
		}
		
		// Shuffles both lists using an identical randam sequence
		long seed = System.currentTimeMillis();
		Collections.shuffle(states, new Random(seed));
		Collections.shuffle(capitals, new Random(seed));
	}
}