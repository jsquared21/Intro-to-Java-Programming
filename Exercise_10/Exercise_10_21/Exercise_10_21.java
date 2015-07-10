/*********************************************************************************
* (Divisible by 5 or 6) Find the first ten numbers greater than Long.MAX_VALUE   *
* that are divisible by 5 or 6.                                                  *
*********************************************************************************/
import java.math.BigInteger;

public class Exercise_10_21 {
	/** Main method */
	public static void main(String[] args) {
		// Find the first ten numbers greater than 
		// Long.MAX_VALUE that are divisible by 5 or 6.
		int count = 0;
		BigInteger n = new BigInteger(String.valueOf(Long.MAX_VALUE));
		BigInteger five = new BigInteger("5");
		BigInteger six = new BigInteger("6");
		BigInteger zero = new BigInteger("0");

		// Display results
		System.out.println("\nFirst ten numbers greater than Long.MAX_VALUE" +
			" that are divisible by 5 or 6:");
		while (count < 10) {
			n = n.add(new BigInteger("1"));
			if ((n.remainder(five)).compareTo(zero) == 0 || 
				 (n.remainder(six)).compareTo(zero) == 0) {
				System.out.println(n);
				count++;
			}
		}
	}
}