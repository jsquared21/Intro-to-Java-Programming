/*********************************************************************************
* (Remove duplicates) Write a method that removes the duplicate elements from    *
* an array list of integers using the following header:                          *
*                                                                                *
* public static void removeDuplicate(ArrayList<Integer> list)                    *
*                                                                                *
* Write a test program that prompts the user to enter 10 integers to a list and  *
* displays the distinct integers separated by exactly one space.                 *
*********************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise_11_13 {
	/** Main method */
	public static void main(String[] args) {
		// Create a scanner
		Scanner input = new Scanner(System.in);

		// Create an ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>();

		// Prompt ther user to enter 10 integers
		System.out.print("Enter 10 integers: ");
		for (int i = 0; i < 10; i++) {
			list.add(input.nextInt());
		}

		// Invoke removeDuplicate method
		removeDuplicate(list);

		// Display the distinct integers
		System.out.print("The distinct integers are ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	/** Removes the duplicate elements from an array list of integers */
	public static void removeDuplicate(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j))
					list.remove(j);
			}
		}
	}
}