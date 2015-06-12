/*
(Find the smallest n such that n^2 > 12,000) Use a while loop to find the smallest
integer n such that n^2 is greater than 12,000.
*/
public class Exercise_05_12 {
	public static void main(String[] args) {
		int n = 0;	// Start n at 0

		// Find the smallest n such that n^2 > 12,000
<<<<<<< HEAD
		while (Math.pow(n, 2) <= 12000) {
=======
		while (Math.pow(n, 2) < 12000) {
>>>>>>> f7c770b17f3c46acc01e28b1b7c3742d6c7130d0
			n++; 		// Increment n
		}

		// Display result
		System.out.println(
			"The smallest integer n such that n^2 is greater than 12,000: " + n);
	}
}