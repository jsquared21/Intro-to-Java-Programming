/*
(Financial application: find the sales amount) You have just started a sales job
in a department store. Your pay consists of a base salary and a commission. The
base salary is $5,000. The scheme shown below is used to determine the commission
rate.

			Sales Amount                   Commission Rate
			------------------------------------------------
			$0.01–$5,000                     8 percent
			$5,000.01–$10,000               10 percent
			$10,000.01 and above            12 percent

Note that this is a graduated rate. The rate for the first $5,000 is at 8%, the next
$5000 is at 10%, and the rest is at 12%. If the sales amount is 25,000, the commission
is 5,000 * 8% + 5,000 * 10% + 15,000 * 12% = 2,700.

Your goal is to earn $30,000 a year. Write a program that finds the minimum sales
you have to generate in order to make $30,000.
*/
public class Exercise_05_39 {
	public static void main(String[] args) {
		// Create a consstant value for commmission sought
		final double COMMISSION_SOUGHT = 30000; 
		double salesAmount, 				// Sales amount
				 commission,				// Employee commission
				 balance;					// Sales balance
		salesAmount = 0;					// Initialize accumulator to 0
		do {	
			balance = commission = 0;	// Set balance and commission to 0
			salesAmount += 0.01;			// Increase sales amount by $0.01

			// If sales amount is $10,000.01 and above commission rate is 12%
			if (salesAmount > 10000)
				commission += (balance = salesAmount - 10000) * 0.12;

			// If sales amount is $5,000.01-$10,000 commission rate is 10%
			if (salesAmount > 5000)
				commission += (balance -= balance - 5000) * 0.10;

			// If sales amount is $0.01-$5,000 commission rate is 8%
			if (salesAmount > 0)
				commission += balance * 0.08;

			// While commission is less than commission sought loop
		} while (commission < COMMISSION_SOUGHT);

		// Display results
		System.out.printf("Minimum sales to earn $30,000: $%.0f\n", salesAmount);
	}
}