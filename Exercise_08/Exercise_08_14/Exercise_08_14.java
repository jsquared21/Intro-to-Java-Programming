/*********************************************************************************
* (Explore matrix) Write a program that prompts the user to enter the length of  *
* a square matrix, randomly fills in 0s and 1s into the matrix, prints the       *
* matrix, and finds the rows, columns, and diagonals with all 0s or 1s.          *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_14 {
	/** Main method */
	public static void main(String[] args) {
		// Create a square matrix
		int[][] matrix = getMatrix();

		// Display matrix
		print(matrix);

		// Display results
		int[] rows = allRow(matrix);
		int count = 0;
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] >= 0)
				System.out.println("All " + rows[i] + "s on row " + (i + 1));
			else
				count++;
			if (count == rows.length)
				System.out.println("No same numbers on a row");
		}

		int[] columns = allColumn(matrix);
		count = 0;
		for (int i = 0; i < columns.length; i++) {
			if (columns[i] >= 0)
				System.out.println("All " + columns[i] + "s on column " + (i + 1));
			else
				count++;
			if (count == columns.length)
				System.out.println("No same numbers on a column");
		}

		int n = allMajorDiagonal(matrix);
		switch (n) {
			case 0:
			case 1: System.out.println("All " + n + "s on the major diagonal");
					  break;
			default: System.out.println("No same numbers on the major diagonal");
				
		}

		n = allSubDiagonal(matrix);
		switch (n) {
			case 0:
			case 1: System.out.println("All " + n + "s on the sub-diagonal");
					  break;
			default: System.out.println("No same numbers on the sub-diagonal");
				
		}

	}

	/** allSubDiagonal returns 0 or 1 if all 0s or 1s  
	    on the sub-diagonal, otherwise returns -1 */
	public static int allSubDiagonal(int[][] m) {
		int[] count = new int[2]; // Counts 0s and 1s
		// Initialize count array to 0;
		count[0] = 0;
		count[1] = 0;
		for (int i = 0, j = m.length - 1; i < m.length; i++, j--) {
			count[m[i][j]]++;
			if (count[0] == m.length)
				return 0;
			if (count[1] == m.length)
				return 1;
		}
		return -1;
	}

	/** allMajorDiagonal returns 0 or 1 if all 0s or 1s  
	    on the major diagonal, otherwise returns -1 */
	public static int allMajorDiagonal(int[][] m) {
		int[] count = new int[2]; // Counts 0s and 1s
		// Initialize count array to 0;
		count[0] = 0;
		count[1] = 0;
		for (int i = 0; i < m.length; i++) {
			count[m[i][i]]++;
			if (count[0] == m.length)
				return 0;
			if (count[1] == m.length)
				return 1;
		}
		return -1;
	}

	/** allColumn returns 0 or 1 if a column has   
	    all 0s or 1s, otherwise returns -1 */
	public static int[] allColumn(int[][] m) {
		// Initilize array to hold results with -1
		int[] result = new int[m.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		int[] count = new int[2]; // Counts 0s and 1s
		for (int i = 0; i < m.length; i++) {
			// Initialize count array to 0;
			count[0] = 0;
			count[1] = 0;

			for (int j = 0; j < m[i].length; j++) {
				count[m[j][i]]++;
				if (count[0] < j + 1 && count[1] < j + 1) {
					break;
				}
			}

			if (count[0] >= m.length || count[1] >= m.length)
				result[i] = count[0] > count[1] ? 0 : 1;
		}
		return result;
	}

	/** allRow returns 0 or 1 if a row has   
	    all 0s or 1s, otherwise returns -1 */
	public static int[] allRow(int[][] m) {
		// Initilize array to hold results with -1
		int[] result = new int[m.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		int[] count = new int[2]; // Counts 0s and 1s
		for (int i = 0; i < m.length; i++) {
			// Initialize count array to 0;
			count[0] = 0;
			count[1] = 0;

			for (int j = 0; j < m[i].length; j++) {
				count[m[i][j]]++;
				if (count[0] < j + 1 && count[1] < j + 1) {
					break;
				}
			}

			if (count[0] >= m.length || count[1] >= m.length)
				result[i] = count[0] > count[1] ? 0 : 1;
		}
		return result;
	}

	/** getMatrix prompts the user to enter the length of a square matrix 
		 and randomly fills in 0s and 1s into the matrix, then returns it */
	public static int[][] getMatrix() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the size for the matrix: ");
		int size = input.nextInt();
		int[][] m = new int[size][size];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = (int)(Math.random() * 2);
			}
		}
		return m;
	}

	/** print displays all elements in a matrix */
	public static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
}