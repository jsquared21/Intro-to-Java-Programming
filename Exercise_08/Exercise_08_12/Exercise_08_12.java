/*********************************************************************************
* (Financial application: compute tax) Rewrite Listing 3.5, ComputeTax.java,     *
* using arrays. For each filing status, there are six tax rates. Each rate is    *
* applied to a certain amount of taxable income. For example, from the taxable   *
* income of $400,000 for a single filer, $8,350 is taxed at 10%, (33,950 - 8,350)*
* at 15%, (82,250 - 33,950) at 25%, (171,550 - 82,550) at 28%, (372,550 - 82,250)*
* at 33%, and (400,000 - 372,950) at 36%. The six rates are the same for all     *
* filing statuses, which can be represented in the following array:              *
*                                                                                *
* double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};                         *
*                                                                                *
* The brackets for each rate for all the filing statuses can be represented in a * 
* two dimensional array as follows:                                              *
* int[][] brackets = {                                                           *
* 	 {8350, 33950, 82250, 171550, 372950},  // Single filer                       *
* 	 {16700, 67900, 137050, 20885, 372950}, // Married jointly                    *
* 	                                        // -or qualifying widow(er)           *
* 	 {8350, 33950, 68525, 104425, 186475},  // Married separately                 *
* 	 {11950, 45500, 117450, 190200, 372950} // Head of household                  *
*  };                                                                            *
*                                                                                *
* Suppose the taxable income is $400,000 for single filers. The tax can be       *
* computed as follows:                                                           *
*                                                                                *
* tax = brackets[0][0] * rates[0] +                                              *
* 	 (brackets[0][1] – brackets[0][0]) * rates[1] +                               *
* 	 (brackets[0][2] – brackets[0][1]) * rates[2] +                               *
* 	 (brackets[0][3] – brackets[0][2]) * rates[3] +                               *
* 	 (brackets[0][4] – brackets[0][3]) * rates[4] +                               *
* 	 (400000 – brackets[0][4]) * rates[5]                                         *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_12 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Tax rates
		double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

		// The brackets for each rate for all the filing statuses
		int[][] brackets = {
			{8350, 33950, 82250, 171550, 372950},  // Single filer
			{16700, 67900, 137050, 20885, 372950}, // Married jointly
																// -or qualifying widow(er)
			{8350, 33950, 68525, 104425, 186475},  // Married separately
			{11950, 45500, 117450, 190200, 372950} // Head of household
		};
			
		// Prompt the user to enter filing status
		System.out.print("(0-single filer, 1-married jointly or " +
			"qualifying widow(er), 2-married separately, 3-head of " +
			"household) Enter the filing status: ");
		int status = getStatus();

		// Prompt the user to enter taxable income
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();


		// Display the result
		System.out.printf("Tax is $%6.2f\n", 
			computeTax(brackets, rates, status, income)); 
	}

	/** computeTax computes and returns the total 
	    tax for the filing status brackets */
	public static double computeTax(int[][] brackets, double[] rates,
		int status, double income) {
		double tax = 0, incomeTaxed = 0;
		for (int i = 4; i >= 0; i--) {
			if (income > brackets[status][i])
 				tax += (incomeTaxed = income - brackets[status][i]) * rates[i + 1];
				income -= incomeTaxed;
		} 
		return tax += brackets[status][0] * rates[0];
	}

	/** getStatus returns a valid status */
	public static int getStatus(){
		Scanner input = new Scanner(System.in);
		int status;
		do {
			status = input.nextInt();
			if (status < 0 || status > 3)
				System.out.println("Error: invalid status");
		} while (status < 0 || status > 3);
		return status;
	}
}