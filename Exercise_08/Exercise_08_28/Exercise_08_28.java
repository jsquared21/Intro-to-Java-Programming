/*********************************************************************************
* (Strictly identical arrays) The two-dimensional arrays m1 and m2 are strictly  *
* identical if their corresponding elements are equal. Write a method that       *
* returns true if m1 and m2 are strictly identical, using the following header:  *
*                                                                                *
* public static boolean equals(int[][] m1, int[][] m2)                           *
*                                                                                *
* Write a test program that prompts the user to enter two 3 * 3 arrays of        *
* integers and displays whether the two are strictly identical. Here are the     *
* sample runs.                                                                   *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_28 {
	/** Main method */
	public static void main(String[] args) {
		// Prompt the user to enter two 3 x 3 arrays of integers
		System.out.print("Enter list1: ");
		int[][] list1 = getArray();
		System.out.print("Enter list2: ");
		int[][] list2 = getArray();

		// Display whether the two arrays are strictly identical.
		System.out.println("The two arrays are" + 
			(equals(list1, list2) ? " " : " not ") + "strictly identical");
	}

	/** equals returns true if m1 and m2 are strictly identical */
	public static boolean equals(int[][] m1, int[][] m2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (m1[i][j] != m2[i][j])
					return false;
			}
		}
		return true;
	}

	/** getArray initializes and returns a 3 X 3 array */
	public static int[][] getArray() {
		Scanner input = new Scanner(System.in);
		int[][] m = new int[3][3];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextInt();
			}
		}
		return m;
	}
}