/*********************************************************************************
* (Culture: Chinese Zodiac) Simplify Listing 3.9 using an array of strings to    *
* store the animal names.                                                        *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_33 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner

		// Create array of Chinese Zodiac animal names
		String[] zodiacs = {"monkey", "rooster", "dog", "pig", "rat", "ox", "tiger",
									"rabbit", "dragon", "snake", "horse", "sheep"};

		// Prompt the user to enter a year
		System.out.print("Enter a year: ");
		int year = input.nextInt();

		// Display Chinese Zodiac sign for the given year
		System.out.println(zodiacs[year % 12]);
	}
}