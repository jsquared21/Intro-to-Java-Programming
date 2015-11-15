/*********************************************************************************
* (Name for both genders) Write a program that prompts the user to enter one of  *
* the filenames described in Programming Exercise 12.31 and displays the names   *
* that are used for both genders in the file. Use sets to store names and find   *
* common names in two sets. Here is a sample run:                                *
*********************************************************************************/
import java.util.*;

public class Exercise_21_12 {
	
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
	
		// Prompt the user to enter one of file names
		System.out.print("Enter a file name for baby name ranking: ");
		String fileName = input.next();

		// Create to sets
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();

		try {
			java.net.URL url = new java.net.URL(
				"http://www.cs.armstrong.edu/liang/data/" + fileName);

			// Create input file from url and add names to sets
			Scanner inputStream = new Scanner(url.openStream());
			while (inputStream.hasNext()) {
				inputStream.next();
				set1.add(inputStream.next());
				inputStream.next();
				set2.add(inputStream.next());
				inputStream.next();
			}
		}
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors; no such file");
		}

		// Display the names that are used for both genders
		set1.retainAll(set2);
		System.out.println(set1.size() + " names used for both genders");
		System.out.print("They are ");
		for (String name: set1) {
			System.out.print(name + " ");
		}
		System.out.println();
	}
}