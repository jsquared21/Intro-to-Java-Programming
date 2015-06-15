/*********************************************************************************
* (Pattern recognition: consecutive four equal numbers) Write the following      *
* method that tests whether the array has four consecutive numbers with the same *
* value.                                                                         *
*                                                                                *        
* public static boolean isConsecutiveFour(int[] values)                          *
*                                                                                *        
* Write a test program that prompts the user to enter a series of integers and   *
* displays if the series contains four consecutive numbers with the same value.  *
* Your program should first prompt the user to enter the input size—i.e., the    *
* number of values in the series.                                                *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_30 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the input size
		System.out.print("Enter the number of values: ");
		int[] values = new int[input.nextInt()];

		// Promt the user to enter the values
		System.out.print("Enter the values: ");
		for (int i = 0; i < values.length; i++)
			values[i] = input.nextInt();
		
		// Display if the series contains for consecutive numbers
		System.out.println("The list has" + 
			(isConsecutiveFour(values) ? " " : " no ") + "consecutive fours");
	}

	/** isConsecutiveFour tests whether the array has  
   *   four consecutive numbers with the same value */
	public static boolean isConsecutiveFour(int[] values) {
		int count = 1; // number of consecutive numbers
		
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i] == values[i + 1]) 
				count++;
			
			if (count >= 4) 
				return true;
	
			if (values[i] != values[i + 1])
				count = 1;	
		}
		return false;
	}
}