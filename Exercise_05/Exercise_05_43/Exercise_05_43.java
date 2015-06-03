/*
(Math: combinations) Write a program that displays all possible combinations
for picking two numbers from integers 1 to 7. Also display the total number of
all combinations.
*/
public class Exercise_05_43 {
	public static void main(String[] args) {
		int count = 0; // Counts the number of combinations

		// Display all possible combination for 
		// picking to numbers from integers 1 to 7
		for (int number1 = 1; number1 < 7; number1++) {
			for (int number2 = number1 + 1; number2 <= 7; number2++) {
				System.out.println(number1 + " " + number2);
				count++; // Increment count
			}
		}

		// Display total number of all combinations
		System.out.println("The total number of all combinations is " + count);
	}
}