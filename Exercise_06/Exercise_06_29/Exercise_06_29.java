/*
(Twin primes) Twin primes are a pair of prime numbers that differ by 2. For example,
3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are twin primes.
Write a program to find all twin primes less than 1,000. Display the output as follows:
(3, 5)
(5, 7)
...
*/
public class Exercise_06_29 {
	/** Main Method */
	public static void main(String[] args) {
		// Find  and display all twin primes less than 1,000
		System.out.println();
		for (int p = 2; p < 1000; p++) {
			if (isTwinprime(p))
				System.out.println("(" + p + ", " + (p + 2) + ")");
		}
	}

	/** Method isTwinprime returns true if num and num + 2 are primes */
	public static boolean isTwinprime(int num) {
		return PrimeNumberMethod.isPrime(num) && PrimeNumberMethod.isPrime(num + 2);
	}
}