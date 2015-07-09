/*********************************************************************************
* (Square numbers) Find the first ten square numbers that are greater than       *
* Long.MAX_VALUE. A square number is a number in the form of n2. For example,    *
* 4, 9, and 16 are square numbers. Find an efficient approach to run your        *
* program fast.                                                                  *
*********************************************************************************/
import java.math.BigInteger;

public class Exercise_10_17 {
	/** Main method */
	public static void main(String[] args) {
		// Find the first ten square numbers  
		// that are greater than Long.MAX_VALUE
		BigInteger i = new BigInteger(Long.MAX_VALUE + ""); 
		BigInteger end = i.add(new BigInteger("10"));

		// Display results
		for (i = new BigInteger(Long.MAX_VALUE + ""); 
			i.compareTo(end) <= 0; 
			i = i.add(new BigInteger("1"))) {
			System.out.println(i.multiply(i)); 
		}		
	}
}