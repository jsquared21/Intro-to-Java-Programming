/*********************************************************************************
* (Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000   *
* award if two digits from the user input are in the lottery number. (Hint: Sort *
* the three digits in the lottery number and three digits in the user input into *
* two lists, and use the Collection’s containsAll method to check whether the    *
* two digits in the user input are in the lottery number                         *
*********************************************************************************/
import java.util.*;

public class Exercise_20_08 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create two lists
		List<Integer> lotteryList = new ArrayList<>();
		List<Integer> guessList = new ArrayList<>();

		// Generate a random three-digit number
		lotteryList.add((int)(Math.random() * 10));
		lotteryList.add((int)(Math.random() * 10));
		lotteryList.add((int)(Math.random() * 10));

		// Prompt the user to enter a three-digit number
		System.out.print("Enter a three-digit number: ");
		int guess = input.nextInt();

		// Extract digits from guess
		guessList.add(guess / 100);
		int remainingDigits = guess % 100;
		guessList.add(remainingDigits / 10);
		guessList.add(remainingDigits % 10);

		// Display the lottery number
		System.out.print("The lottery number is ");
		for (Integer e: lotteryList) {
			System.out.print(e);
		}
		System.out.println();

		// Check the guess numbers to lottery numbers
		// for exact match and display the result
		if (guessList.equals(lotteryList)) {
			System.out.println("Exact match: you win $10,000");
			System.exit(0);
		}

		// Check the guess numbers to lottery numbers
		// for all digits match and display the result
		if (guessList.containsAll(lotteryList)) {
			System.out.println("All digits match: you win $3,000");
			System.exit(0);
		}

		// Sort the lists
		Collections.sort(lotteryList);
		Collections.sort(guessList);

		// Check the guess numbers to lottery numbers
		// for two digits match and display the result
		List<Integer> list1 = Arrays.asList(lotteryList.get(0), lotteryList.get(1));
		List<Integer> list2 = Arrays.asList(lotteryList.get(0), lotteryList.get(2));
		List<Integer> list3 = Arrays.asList(lotteryList.get(1), lotteryList.get(2));
		if (guessList.containsAll(list1) ||
			 guessList.containsAll(list2) ||
			 guessList.containsAll(list3)) {
			System.out.println("Two digits match: you win $2,000");
		}
	}
}