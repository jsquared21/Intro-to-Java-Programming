/*
(Assign grades) Write a program that reads student scores, gets the best score,
and then assigns grades based on the following scheme:
Grade is A if score is >= best - 10;
Grade is B if score is >= best - 20;
Grade is C if score is >= best - 30;
Grade is D if score is >= best - 40;
Grade is F otherwise.
The program prompts the user to enter the total number of students, then prompts
the user to enter all of the scores, and concludes by displaying the grades. Here
is a sample run:
*/
import java.util.Scanner;

public class Exercise_07_01 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the total number of students
		System.out.print("Enter the nubmer of students: ");
		int[] scores = new int[input.nextInt()];
		char[] grades = new char[scores.length];

		// Prompt the user to enter all the scores
		System.out.print("Enter " + scores.length + " scores: ");
		for (int i = 0; i < scores.length; i++) {
			scores[i] = input.nextInt();
		}

		// Get grades
		getGrades(scores, grades);

		// Display results
		for (int i = 0; i < scores.length; i++) {
			System.out.println("Student " + i + " score is " + 
				scores[i] + " and grade is " + grades[i]);
		}
	}

	/** Method max returns the is highest score */
	public static int max(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}

	/** Method getGrade assigns grades based on grading scheme */
	public static void getGrades(int[] scores, char[] grades) {
		int best = max(scores);
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= best - 10)
				grades[i] = 'A';
			else if (scores[i] >= best - 20)
				grades[i] = 'B';
			else if (scores[i] >= best - 30)
				grades[i] = 'C';
			else if (scores[i] >= best - 40)
				grades[i] = 'D';
			else
				grades[i] = 'F';
		}
	} 
}