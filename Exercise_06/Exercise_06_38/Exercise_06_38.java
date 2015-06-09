/*
(Generate random characters) Use the methods in RandomCharacter in Listing
6.10 to print 100 uppercase letters and then 100 single digits, printing ten per line.
*/
public class Exercise_06_38 {
	/** Main Method */
	public static void main(String[] args) {
		final int NUMNBER_OF_UPPERCASE_LETTERS = 100; // Number of uppercase letters
		final int NUMNBER_OF_SINGLE_DIGITS = 100;	// Number of single digits
		final int NUMBERS_PER_LINE = 10; // Print 10 characters per line

		// Print 100 uppercase letters
		for (int i = 1; i <= NUMNBER_OF_UPPERCASE_LETTERS; i++) {
			System.out.print(RandomCharacter.getRandomUpperCaseLetter());
			System.out.print(i % NUMBERS_PER_LINE == 0 ? "\n" : " ");
		}

		// Print 100 single digits
		for (int i = 1; i <= NUMNBER_OF_SINGLE_DIGITS; i++) {
			System.out.print(RandomCharacter.getRandomDigitCharacter());
			System.out.print(i % NUMBERS_PER_LINE == 0 ? "\n" : " ");
		}
	}
}