/*********************************************************************************
* (Game: locker puzzle) A school has 100 lockers and 100 students. All lockers   *
* are closed on the first day of school. As the students enter, the first        *
* student, denoted S1, opens every locker. Then the second student, S2,          *
* begins with the second locker, denoted L2, and closes every other locker.      *
* Student S3 begins with the third locker and changes every third locker (closes *
* it if it was open, and opens it if it was closed). Student S4 begins with      *
* locker L4 and changes every fourth locker. Student S5 starts with L5 and       *
* changes every fifth locker, and so on, until student S100 changes L100.        *
*                                                                                *
* After all the students have passed through the building and changed the        *
* lockers, which lockers are open? Write a program to find your answer and       *
* display all open locker numbers separated by exactly one space.                *
* (Hint: Use an array of 100 Boolean elements, each of which indicates whether a *
* locker is open (true) or closed (false). Initially, all lockers are closed.)   *
*********************************************************************************/
public class Exercise_07_23 {
	/** Main method */
	public static void main(String[] args) {
		String[] lockers = new String[100];

		// Close all the lockers
		closeAllLockers(lockers);

		// Invoke the stuentLockerChanges method
		studentLockerChanges(lockers);
		
		// Display all open lock numbers
		print(lockers);
	}

	/** isOpen returns true if l is the string "OPEN". False otherwise*/
	public static boolean isOpen(String l) {
		return l == "OPEN";
	}

	/** closeAllLockers fills the array with the string "CLOSED" */
	public static void closeAllLockers(String[] lockers) {
		for (int i = 0; i < lockers.length; i++) {
			lockers[i] = "CLOSED";
		}
	}

	/** studentLockerChanges changes the string in each 
	*   element from "CLOSED" to "OPEN" or Vice versa */
	public static void studentLockerChanges(String[] lockers) {
		int start = 0; // Locker student begins with

		for (int s = 1; s <= lockers.length; s++) {
			for (int l = 0; l < lockers.length; l += s) {
				if (isOpen(lockers[l]))
					lockers[l] = "CLOSED";
				else
					lockers[l] = "OPEN";
			}
			start++;
		}
	}

	/** print displays all open locker numbers separated by exactly one space */
	public static void print(String[] lockers) {
		for (int i = 0; i < lockers.length; i++) {
			if (isOpen(lockers[i])) {
				System.out.print("L" + (i + 1) + " ");
			}
		}
		System.out.println();
	}
}