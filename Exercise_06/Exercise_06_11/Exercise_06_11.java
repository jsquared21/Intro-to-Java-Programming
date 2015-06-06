/*
(Financial application: compute commissions) Write a method that computes the
commission, using the scheme in Programming Exercise 5.39. The header of the
method is as follows:
public static double computeCommission(double salesAmount)

Write a test program that displays the following table:

               Sales Amount        Commission
               --------------------------------
               10000                 900.0
               15000                1500.0
               ...
               95000               11100.0
               100000              11700.0
*/
public class Exercise_06_11 {
	/** Main Method */
	public static void main(String[] args) {
		// Display table
		System.out.println("\n SalesAmount     Commission");
		System.out.println("-----------------------------");
		for (double salesAmount = 10000; salesAmount <= 100000; salesAmount += 5000) {
			System.out.printf(" %-16.0f", salesAmount);
			System.out.printf("%8.1f\n", computeCommission(salesAmount));
		}
	}

	/** Method commputeCommission computes the commission */
	public static double computeCommission(double salesAmount) {
		double balance, 					// Holds the balance
		       commission;				// Employee commission
		balance = commission = 0.0;	// Initialize balance and commission to 0

		// If sales amount is $10.000.01 and above commission rate is 12%
		if (salesAmount >= 10000.01)
			commission += (balance = salesAmount - 10000) * 0.12;

		// If sales amount is $5,000.01 to $10,000 commissin rate is 10%
		if (salesAmount >= 5000.01)
			commission += (balance -= balance - 5000) * 0.10;

		// If sales amount is $0.01 to $5,000.01 commissin rate is 8%
		if (salesAmount >= 0.01)
				commission += balance * 0.08;
			
		return commission;
	}
}