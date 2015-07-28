/*********************************************************************************
* (Create large dataset) Create a data file with 1,000 lines. Each line in the   *
* file consists of a faculty member’s first name, last name, rank, and salary.   *
* The faculty member’s first name and last name for the ith line are FirstNamei  *
* and LastNamei. The rank is randomly generated as assistant, associate, and     *
* full. The salary is randomly generated as a number with two digits after the   *
* decimal point. The salary for an assistant professor should be in the range    *
* from 50,000 to 80,000, for associate professor from 60,000 to 110,000, and for *
* full professor from 75,000 to 130,000. Save the file in Salary.txt.            *
*********************************************************************************/
import java.io.*;

public class Exercise_12_24 {
	/** Main method */
	public static void main(String[] args) throws FileNotFoundException {
		// Create File object
		File file = new File("Salary.txt");

		// Check if file exists 
		if (file.exists()) {
			System.out.println("File " + file.getName() + " already exists");
			System.exit(0);
		}
		String rank = "";
		double salary;
		try (
			// Create output file
			PrintWriter output = new PrintWriter(file);
		) {
			// Save data to file
			for (int i = 1; i <= 1000; i++) {
				output.print("FirstName" + i + " LastName" + i);
				rank = getRank();
				salary = getSalary(rank);
				output.printf(" " + rank + " %.2f\n", salary);
			}
		}
	}

	/** Return a randomly generated rank */
	public static String getRank() {
		String[] ranks = {"assistant", "associate", "full"};
		return ranks[(int)(Math.random() * ranks.length)];
	}

	/** Return a randomly generated salary */
	public static double getSalary(String rank) {
		if (rank.equals("assistant"))
			return  50000 + (double)(Math.random() * 30001);
		else if (rank.equals("associate"))
			return 60000 + (double)(Math.random() * 50001);
		else
			return 75000 + (double)(Math.random() * 55001); 
	}
}