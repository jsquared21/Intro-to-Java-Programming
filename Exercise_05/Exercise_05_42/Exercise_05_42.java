/*
(Financial application: find the sales amount) Rewrite Programming Exercise
5.39 as follows:
■ Use a for loop instead of a do-while loop.
■ Let the user enter COMMISSION_SOUGHT instead of fixing it as a constant.
*/
import java.util.Scanner;

public class Exercise_05_42 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double commission = 0.0, balance, salesAmount;

		// Let the user enter COMMISSION_SOUGHT
		System.out.print("Enter the commission sought: ");
		double commissionSought = input.nextDouble();

		// Find the sales amount
		for (salesAmount = 0.01; commission < commissionSought; salesAmount += 0.01) {
		 	balance = commission = 0.0;	// Set balance and commission to 0

			// If salest amount is $10,000.01 and above commission rate is 12%
			if (salesAmount >= 10000.01)
				commission += (balance = salesAmount - 10000) * 0.12;

			// If salest amount is $5,000.01-$10,000 commission rate is 10%
			if (salesAmount >= 5000.01)
				commission += (balance -= balance - 5000) * 0.10;

			// If salest amount is $0.01-$5,000 commission rate is 8%
			if (salesAmount >= 0.01)
				commission += balance * 0.08;
			//System.out.println(salesAmount);
		}

		// Display results
		System.out.printf(
			"Minimum sales to earn $%.0f: $%.0f\n", commissionSought, salesAmount);
	}
}