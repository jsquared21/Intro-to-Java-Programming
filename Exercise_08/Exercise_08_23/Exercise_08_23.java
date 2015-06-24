/*********************************************************************************
* (Game: find the flipped cell) Suppose you are given a 6-by-6 matrix filled     *
* with 0s and 1s. All rows and all columns have an even number of 1s. Let the    *
* user flip one cell (i.e., flip from 1 to 0 or from 0 to 1) and write a program *
* to find which cell was flipped. Your program should prompt the user to enter a *
* 6-by-6 array with 0s and 1s and find the first row r and first column c where  *
* the even number of the 1s property is violated (i.e., the number of 1s is not  *
* even). The flipped cell is at (r, c).                                          *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_23 {
	public static void main(String[] args) {
		// Prompt the user to enter a 6-by-6 matrix
		System.out.println("Enter a 6-by-6 matrix row by row:");
		int[][] matrix = getMatrix();

		// Find the first row r and first column c where 
		// the even number of the 1s property is violated
		int row = oddRow1s(matrix);
		int column = oddColumn1s(matrix);

		// Display the flipped cell
		if (row < 0 || column < 0)
			System.out.println("No cell has been flipped");
		else {
			System.out.println(
				"The flipped cell is at (" + row + ", " + column + ")");
		}
	}

	/** getMatrix initializes and returns a 6 x 6 matrix of user input */
	public static int[][] getMatrix() {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		// Create a 6 x 6 matrix
		int[][] m = new int[6][6];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextInt();
			}
		}
		return m;
	}

	/** oddRow1s returns index of row with odd number of 1s */
	public static int oddRow1s(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 1)
					count++;
			}
			if (count % 2 != 0)
				return i;
		}
		return -1;
	}

	/** oddColumn1s returns index of column with odd number of 1s*/
	public static int oddColumn1s(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m.length; j++) {
				if (m[j][i] == 1)
					count++;
			}
			if (count % 2 != 0)
				return i;
		}
		return -1;
	}
}