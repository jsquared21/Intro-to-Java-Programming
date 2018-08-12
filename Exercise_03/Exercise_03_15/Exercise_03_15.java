/*
(Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a threedigit
number. The program prompts the user to enter a three-digit number and
determines whether the user wins according to the following rules:
1. If the user input matches the lottery number in the exact order, the award is
$10,000.
2. If all digits in the user input match all digits in the lottery number, the award is
$3,000.
3. If one digit in the user input matches a digit in the lottery number, the award is
$1,000.
*/
import java.util.Scanner;

public class Exercise_03_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Generate a random three-digit number
		int lottery = 123;

		// Prompt the user to enter a three-digit number
		System.out.print("Enter a three-digit number: ");
		int guess = input.nextInt();

		// Extract digits from lottery
		int lotteryDigit1 = lottery / 100;
		int remainingDigits = lottery % 100;
		int lotteryDigit2 = remainingDigits / 10;
		int lotteryDigit3 = remainingDigits % 10;

		// Extract digits from guess
		int guessDigit1 = guess / 100;
		remainingDigits = guess%100;
		int guessDigit2 = remainingDigits / 10;
		int guessDigit3 = remainingDigits % 10;

		
		System.out.println("The lottery number is " + lottery);
		
		// Check the guess
		if (guess == lottery)
			System.out.println("Exact match: you win $10,000");
		else if ((guessDigit1==lotteryDigit2 && guessDigit2==lotteryDigit3 && guessDigit3==lotteryDigit1)||
				(guessDigit1==lotteryDigit2 && guessDigit2==lotteryDigit1 && guessDigit3==lotteryDigit3)||
				(guessDigit1==lotteryDigit3 && guessDigit2==lotteryDigit1 && guessDigit3==lotteryDigit2)||
				(guessDigit1==lotteryDigit3 && guessDigit2==lotteryDigit2 && guessDigit3==lotteryDigit1)||
				(guessDigit1==lotteryDigit1 && guessDigit2==lotteryDigit3 && guessDigit3==lotteryDigit2))
				{
					System.out.println("Match all digits: you win $3,000");
				}
		else if(guessDigit1==lotteryDigit1||guessDigit1==lotteryDigit2||guessDigit1==lotteryDigit3||
				guessDigit2==lotteryDigit2||guessDigit2==lotteryDigit1||guessDigit2==lotteryDigit3||
				guessDigit3==lotteryDigit3||guessDigit3==lotteryDigit1||guessDigit3==lotteryDigit2)
				{
					System.out.println("Match one digit: you win $1,000");
				}
		else
			System.out.println("Sorry,no match");
	}
}