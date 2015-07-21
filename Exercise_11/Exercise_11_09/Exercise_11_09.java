/*********************************************************************************
* (Largest rows and columns) Write a program that randomly fills in 0s and 1s    *
* into an n-by-n matrix, prints the matrix, and finds the rows and columns with  *
* the most 1s. (Hint: Use two ArrayLists to store the row and column indices     *
* with the most 1s.) Here is a sample run of the program:                        *
*********************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_09 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the array size n
		System.out.print("Enter the array size n: ");
		int n = input.nextInt();

		// Create a n-by-n matrix
		int[][] array = new int[n][n];

		// Invoke fill method
		fill(array);

		// Display random array
		print(array);

		// Diplay the rows and columns with the most 1s
		System.out.print("The largest row index: ");
		print(largestRow(array));
		System.out.print("The largest column index: ");
		print(largestColumn(array));
	}

	/** Displays the integers in an list */
	public static void print(ArrayList<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println();
	}

	/** Return a list of the column indices with the most 1 */
	public static ArrayList<Integer> largestColumn(int[][] array) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		int[] count = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1)
					count[j]++;
			}
		}
		int max = max(count);
		getIndex(index, count, max);
		return index;
	}

	/** Return a list of the row indices with the most 1 */
	public static ArrayList<Integer> largestRow(int[][] array) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		int[] count = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[j][i] == 1)
					count[j]++;
			}
		}
		int max = max(count);
		getIndex(index, count, max);
		return index;
	} 

	/** Return the maximum integer in the array */
	public static int max(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	/** Adds the indices of x in count to the list */
	public static void getIndex(ArrayList<Integer> list, int[] count, int x) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] == x)
				list.add(i);
		}
	}
	
	/** Fill array randomly with 0s and 1s */
	public static void fill(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int)(Math.random() * 2);
			}
		}
	}

	/** Display matrix */
	public static void print(int[][] array) {
		System.out.println("The random array is");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}