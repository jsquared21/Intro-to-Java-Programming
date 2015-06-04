/*
(Statistics: compute mean and standard deviation) In business applications, you
are often asked to compute the mean and standard deviation of data. The mean is
simply the average of the numbers. The standard deviation is a statistic that tells
you how tightly all the various data are clustered around the mean in a set of data.
For example, what is the average age of the students in a class? How close are the
ages? If all the students are the same age, the deviation is 0.
Write a program that prompts the user to enter ten numbers, and displays the
mean and standard deviations of these numbers using the following formula:
*/
import java.util.Scanner;

public class Exercise_05_45 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double mean, 				// Holds the mean
				 deviation, 		// Holds the standard deviation
				 number;				// Holds user input
		mean = deviation = 0;	// Set mean and deviation to 0

		// Prompt the user to enter ten numbers
		System.out.print("Enter ten numbers: ");

		// Compute mean and standard deviation
		for (int i = 1; i <= 10; i++) {
			number = input.nextDouble();
			mean += number;
			deviation += Math.pow(number, 2); 
		}
		deviation =  Math.sqrt((deviation - (Math.pow(mean, 2) / 10)) / (10 - 1));
		mean /= 10;

		// Display results
		System.out.println("The mean is " + mean);
		System.out.printf("The standard deviation is %.5f\n", deviation);
	}
}