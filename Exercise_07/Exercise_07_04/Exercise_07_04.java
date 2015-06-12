/*
(Analyze scores) Write a program that reads an unspecified number of scores and
determines how many scores are above or equal to the average and how many
scores are below the average. Enter a negative number to signify the end of the
input. Assume that the maximum number of scores is 100.
*/
import java.util.Scanner;

public class Exercise_07_04 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// prompt ther user to enter an scores
		System.out.print("Enter scores: (negative number signifies end): ");
		
		int[] scores = new int[100];  	// Initialize score array
		int num; 						   	// Hold user input
		int numberOfScores; 			   	// Number of scores
		int average; 					   	// Average score
		numberOfScores = average = 0;		// Initialize accumulator to 0;
		for (int i = 0; i < 100; i++) {
			num = input.nextInt();			
			if (num < 0)						// A negative number signifies end
				break;
			
			scores[i] = num;					// fill scores array
			average += num;					// Add scores to average
			numberOfScores++;					// Increment number of scores
		}

		average /= numberOfScores;	

		int aboveOrEqual;						// Scores above or equal to average
		int below;								// Scores below average
		aboveOrEqual = below = 0;
		for (int i = 0; i < numberOfScores; i++) {
			if (scores[i] >= average)
				aboveOrEqual++;				// Increment aboveOrEqual
			else
				below++;							// Increment below
		}

		// Display results
		System.out.println("\nAverage of scores: " + average);
		System.out.println(
			"Number of scores above or equal to average: " + aboveOrEqual);
		System.out.println(
			"Number of scores below average: " + below);
	}
}