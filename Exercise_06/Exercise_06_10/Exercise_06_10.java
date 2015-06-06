/*
(Use the isPrime Method) Listing 6.7, PrimeNumberMethod.java, provides the
isPrime(int number) method for testing whether a number is prime. Use this
method to find the number of prime numbers less than 10000.
*/
public class Exercise_06_10 {
	/** Main Method */
	public static void main(String[] args) {
		int numberOfPrimes = 0;	// Counts the number of prime numbers

		// Find the number of prime numbers less than 10000
		for (int i = 1; i < 1000; i++) {
			if (PrimeNumberMethod.isPrime(i))
				numberOfPrimes++; // Increament 
		}

		// Display result
		System.out.println(
			"The number of prime numbers less than 10000: " + numberOfPrimes);
	}
}