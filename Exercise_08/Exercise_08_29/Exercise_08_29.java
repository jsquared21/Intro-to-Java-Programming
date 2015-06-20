/*********************************************************************************
* (Identical arrays) The two-dimensional arrays m1 and m2 are identical if they  *
* have the same contents. Write a method that returns true if m1 and m2 are      *
* identical, using the following header:                                         *
*                                                                                *
* public static boolean equals(int[][] m1, int[][] m2)                           *
*                                                                                *
* Write a test program that prompts the user to enter two 3 * 3 arrays of        *
* integers and displays whether the two are identical.                           *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_29 {
	/** Main method */
	public static void main(String[] args) {
		// Prompt the user to enter two 3 x 3 arrays
		System.out.print("Enter list1: ");
		int[][] list1 = getArray();
		System.out.print("Enter list1: ");
		int[][] list2 = getArray();

		// Displays whether the two lists are identical
		System.out.println("The two arrays are" + 
			(equals(list1, list2) ? " " : " not ") + "identical");
	}

	/** getArray initializes a 3 x 3 array with user input */
	public static int[][] getArray() {
		Scanner input = new Scanner(System.in);
		final int ROWS = 3;
		final int COLUMNS = 3;
		int[][] m = new int[ROWS][COLUMNS];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextInt();
			}
		}
		return m;
	}

	/** sort sorts each column in a 3 x 3 array in accending order */
	public static void sort(int[][] m) {
		for (int r = 0; r < 3; r++) {
			for (int i = 0; i < 3; i++) {
				// Find the min in the column 1
				int min = m[r][i];
				int minIndex = i;
	
				for (int j = i + 1; j < 3; j++) {
					if (min > m[r][j]) {
						min = m[r][j];
						minIndex = j;
					}
				}
	
				// Swap
				if (minIndex != i) {
					m[r][minIndex] = m[r][i];
					m[r][i] = min;
				}
			}
		}
	}

	/** equals returns true if m1 and m2 are identical */
	public static boolean equals(int[][] m1, int[][] m2) {
		sort(m1);
		sort(m2);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (m1[i][j] != m2[i][j])
					return false;
			}
		}
		return true;
	}
}