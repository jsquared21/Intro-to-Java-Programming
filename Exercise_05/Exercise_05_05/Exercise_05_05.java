/*
(Conversion from kilograms to pounds and pounds to kilograms) Write a program
that displays the following two tables side by side:

Kilograms Pounds    |    Pounds Kilograms
1            2.2    |    20          9.09
3            6.6    |    25         11.36
...          
197        433.4    |    510       231.82
199        437.8    |    515       234.09
*/

public class Exercise_05_05 {
	public static void main(String[] args) {
		// Create constant value for number of pounds per kilogram
		final double POUNDS_PER_KILOGRAM = 2.2;

		// Display table header
		System.out.println(
			"Kilograms    Pounds     |     Pounds      Kilograms");
		for (int k = 1, p = 20; k <= 199 && p <= 515; k += 2, p += 5) {
			System.out.printf(
				"%-12d%7.1f", k, (k * POUNDS_PER_KILOGRAM));
			System.out.print("     |     ");
			System.out.printf(
				"%-9d%12.2f\n",
				p, (p / POUNDS_PER_KILOGRAM));
		}
	}
}