/*********************************************************************************
* (Baby name popularity ranking) The popularity ranking of baby names from years *
* 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored in files *
* named babynameranking2001.txt, babynameranking2002.txt, . . . ,                *
* babynameranking2010.txt. Each file contains one thousand lines. Each line      *
* contains a ranking, a boy’s name, number for the boy’s name, a girl’s name,    *
* and number for the girl’s name. For example, the first two lines in the file   *
* babynameranking2010.txt are as follows:                                        *
*                                                                                *
*    1      Jacob       21,875          Isabella                22,731           *
*    2      Ethan       17,866          Sophia                  20,477           *
*                                                                                *
* So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s  *
* name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named Jacob   *
* and 22,731 girls are named Isabella. Write a program that prompts the user to  *
* enter the year, gender, and followed by a name, and displays the ranking of    *
* the name for the year.                                                         *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_12_31 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the year, gender and name 
		System.out.print("Enter the year: ");
		String year = input.nextLine();

		System.out.print("Enter the gender: ");
		String gender = input.nextLine();

		System.out.print("Enter the name: ");
		String name = input.nextLine();

		// Create an ArrayList
		ArrayList<String> list = new ArrayList<>();

		// Read text from url
		try {
			java.net.URL url = new java.net.URL(
			"http://www.cs.armstrong.edu/liang/data/babynamesranking" +
			year + ".txt");
			
			// Create input file from url
			input = new Scanner(url.openStream());
			while (input.hasNext()) {
				for (int i = 0; i < 5; i++) {
					list.add(i, input.next());
				}

				// Display ranking for the name for the year
				if (list.get(gender(gender)).equals(name)) {
					System.out.println(
						name + " is ranked #" + list.get(0) + " in year " + year);
					System.exit(0);
				}
				list.clear();
			}
		}
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}

		System.out.println("The name " + name + " is not ranked in year " + year);
	}

	/** Returns the index for the corresponding gender */
	public static int gender(String gender) {
		if (gender.equals("M"))
			return 1;
		else
			return 3;
	}
}