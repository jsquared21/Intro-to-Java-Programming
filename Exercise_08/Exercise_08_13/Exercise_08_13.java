/*********************************************************************************
* (Locate the largest element) Write the following method that returns the       *
* location of the largest element in a two-dimensional array.                    *
*                                                                                *
* public static int[] locateLargest(double[][] a)                                *
*                                                                                *
* The return value is a one-dimensional array that contains two elements. These  *
* two elements indicate the row and column indices of the largest element in the *
* two-dimensional array. Write a test program that prompts the user to enter a   *
* two-dimensional array and displays the location of the largest element in the  *
* array.                                                                         *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_13 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a two-dimensional array 
		System.out.print("Enter the number of rows and columns of the array: ");
		int row = input.nextInt();
		int column = input.nextInt();

		double[][] array = new double[row][column];

		System.out.println("Enter the array:");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = input.nextDouble();
			}
		}

		// Get the location of the largest element
		int[] location = locateLargest(array);

		// Display results
		System.out.println("The location of the largest element is at (" +
			location[0] + ", " + location[1] + ")");
	}

	/** locateLargest returns the location of the 
	    largest element in a two-dimensional array*/
	public static int[] locateLargest(double[][] a) {
		int[] l = new int[2];
		l[0] = 0;
		l[1] = 0;
		double max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {
					l[0] = i;
					l[1] = j;
					max = a[i][j];
				}
			}
		}
		return l;
	}
}