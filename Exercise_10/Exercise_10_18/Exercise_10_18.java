/*********************************************************************************
* (Large prime numbers) Write a program that finds five prime numbers larger     *
* than Long.MAX_VALUE.                                                           *
*********************************************************************************/
import java.math.BigInteger;

public class Exercise_10_18 {
	/** Main method */
	public static void main(String[] args) {
		// Find five prime numbers larger than Long.MAX_VALUE
		BigInteger number = new BigInteger(Long.MAX_VALUE + "");
		number = incrementNumber(number);
		int count = 0;
		final int NUMBER_OF_PRIMES = 5;

		System.out.println();
		while (count < NUMBER_OF_PRIMES) {
			if (isPrime(number)){
				System.out.println(number);
				count++;
			}
			isPrime(number);
			number = incrementNumber(number);
		}
	}

	/** Increment BigInteger number */
	public static BigInteger incrementNumber(BigInteger n) {
		return n.add(new BigInteger("1"));
	} 

	/** Return true if number is prime */
	public static boolean isPrime(BigInteger n) {
		BigInteger end = n.divide(new BigInteger("2"));
		for (BigInteger d = new BigInteger("2"); 
			d.compareTo(end) <= 0; d = incrementNumber(d)) {
			BigInteger x = n.remainder(d);
			BigInteger y = new BigInteger("0");
			if (x.compareTo(y) == 0)
				return false;
		}
		return true;
	}

}