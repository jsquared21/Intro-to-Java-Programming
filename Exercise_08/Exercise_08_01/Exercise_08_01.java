/*********************************************************************************
* (Sum elements column by column) Write a method that returns the sum of all the *
* elements in a specified column in a matrix using the following header:         *
* public static double sumColumn(double[][] m, int columnIndex)                  *
* Write a test program that reads a 3-by-4 matrix and displays the sum of each   *
* column.                                                                        *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_01 {
	/** Main method */
	public static void main(String[] args) {

		// Read a 3-by-4 matrix
		double[][] matrix = getMatrix();

		// Display the sum of each column
		for (int col = 0; col < matrix[0].length; col++) {	
			System.out.println(
				"Sum of the elements at column " + col + 
				" is " + sumColumn(matrix, col));
		}
	}

	/** getMatrix initializes an array with user input values */
	public static double[][] getMatrix() {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		final int ROWS = 3;
		final int COLUMNS = 4;
		double[][] m = new double[ROWS][COLUMNS];

		// Prompt the user to enter a 3-by-4 matrix
		System.out.println("Enter a " + ROWS + "-by-" + 
			COLUMNS + " matrix row by row:");
		for (int row = 0; row < m.length; row++)
			for (int col = 0; col < m[row].length; col++) 
				m[row][col] = input.nextDouble();
		return m;
	}

	/** sum returns the sum of the elements in columnIndex */
	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		for (int row = 0; row < m.length; row++) {
			sum += m[row][columnIndex];		
		}
		return sum;
	}
}