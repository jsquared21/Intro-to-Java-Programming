/*********************************************************************************
* (ArrayIndexOutOfBoundsException) Write a program that meets the following      *
* requirements:                                                                  *
*                                                                                *
* ■ Creates an array with 100 randomly chosen integers.                          *
* ■ Prompts the user to enter the index of the array, then displays the          *
*   corresponding element value. If the specified index is out of bounds,        *
*   display the message "Out of Bounds".                                         *
*********************************************************************************/
import java.util.*;

public class Exercise_12_03 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Invoke getArray method
		int[] array = getArray();

		// Prompt the user to enter the index of the array
		System.out.print("Enter the index of the array: ");
		try {
			// Display the corresponding element value
			System.out.println("The corresponding element value is " + 
				array[input.nextInt()]);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds.");
		}
	}

	/** Returns an array with 100 randomly chosen integers */
	public static int[] getArray() {
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 100) + 1;
		}
		return array;
	}
}