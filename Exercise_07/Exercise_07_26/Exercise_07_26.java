/*********************************************************************************
* (Strictly identical arrays) The arrays list1 and list2 are strictly identical  *
* if their corresponding elements are equal. Write a method that returns true if *
* list1 and list2 are strictly identical, using the following header:            *
*                                                                                *
* public static boolean equals(int[] list1, int[] list2)                         *
*                                                                                *
* Write a test program that prompts the user to enter two lists of integers and  *
* displays whether the two are strictly identical. Here are the sample runs.     *
* Note that the first number in the input indicates the number of the elements   *
* in the list. This number is not part of the list.                              *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_26 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two lists
		System.out.print("Enter list1: ");
		int[] list1 = new int[input.nextInt()];
		for (int i = 0; i < list1.length; i++)
			list1[i] = input.nextInt(); 	

		System.out.print("Enter list2: ");
		int[] list2 = new int[input.nextInt()];
		for (int i = 0; i < list2.length; i++)
			list2[i] = input.nextInt();

		// Display whether the two are strictly identical
		System.out.println("Two lists are" + (equals(list1, list2) ? " " : " not ") 
			+ "strictly identical");
	}
	/** equals returns true is the two arrays are indentical. False otherwise */
	public static boolean equals(int[] list1, int[] list2) {
		if (list1.length != list2.length)
			return false;

		for (int i = 0; i < list1.length; i++) {
			if (list1[i] != list2[i])
				return false;
		}
		return true;
	}
}