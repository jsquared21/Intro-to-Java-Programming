/*********************************************************************************
* (Process scores in a text file on the Web) Suppose that the text file on the   *
* Web http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified      *
* onumber f scores. Write a program that reads the scores from the file and      *
* displays their total and average. Scores are separated by blanks.              *
*********************************************************************************/
import java.util.*;

public class Exercise_12_23 {
	/** Main method */
	public static void main(String[] args) {
		// Create an ArrayList
		ArrayList<Double> list = new ArrayList<>();

		// Read file from web
		try {
			java.net.URL url = new java.net.URL(
				"http://cs.armstrong.edu/liang/data/Scores.txt");
			Scanner input = new Scanner(url.openStream());
			
			while (input.hasNext()) {
				list.add(input.nextDouble());
			}

			// Invoke sum method
			double total = sum(list);

			// Display total and average
			System.out.printf("Total scores: %.0f\n", total);
			System.out.printf("Average score: %.0f\n", (total / list.size()));

		}	// handle exceptions
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: so such file");
		}
	}

	/** Returns the sum of the elements in an ArrayList */
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
}