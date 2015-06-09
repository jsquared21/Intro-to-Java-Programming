/*
(Mersenne prime) A prime number is called a Mersenne prime if it can be written
in the form 2p - 1 for some positive integer p. Write a program that finds all
Mersenne primes with p … 31 and displays the output as follows:
p             2^p –1
-----------------------
2             3
3             7
5             31
...
*/
public class Exercise_06_28 {
	/** Main Method */
	public static void main(String[] args) {
		System.out.println("\np           2^p-1");
		System.out.println("--------------------");
		for (int p = 2; p <= 31; p++) {
			if (PrimeNumberMethod.isPrime(p)) {
				System.out.printf("%-13d", p);
				System.out.println(mersennePrime(p));
			}
			
		}
	}

	/** Method mersennePrime returns the mersenne prime */
	public static int mersennePrime(int num) {
		return (int)Math.pow(2, num) - 1;
	}

}