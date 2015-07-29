/*********************************************************************************
* (Ranking summary) Write a program that uses the files described in Programming *
* Exercise 12.31 and displays a ranking summary table for the first five girl’s  *
* and boy’s names                                                                *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_12_32 {
	/** Main method */
	public static void main(String[] args) {
		// Create three ArrayLists
		ArrayList<String> boys = new ArrayList<>();
		ArrayList<String> girls = new ArrayList<>();
		ArrayList<String> line = new ArrayList<>();
		
		// Display header
		print();
		for (int year = 2010; year >= 2001; year--) {
			try {
				// Create URL object
				java.net.URL url = new java.net.URL(getURL(year));

				// Create an input URL stream
				Scanner input = new Scanner(url.openStream());

				// Process data from URL
				for (int i = 0; i < 5 && input.hasNext(); i++) {
					readURL(input, line);
					boys.add(line.get(1));
					girls.add(line.get(3));
				}
			}
			catch (java.net.MalformedURLException ex) {
				System.out.println("Invalid URL");
			}
			catch (java.io.IOException ex) {
				System.out.println("I/O Errors: no such file");
			}
			// Display data
			print(year, boys, girls);

			// Clear ArrayLists
			boys.clear();
			girls.clear();
		}	
	}

	/** Displays table data */
	public static void print(int year, ArrayList<String> b, ArrayList<String> g) {
		System.out.printf("%5d  ", year);
		for (int i = 0; i < 5; i++) {
			System.out.print(g.get(i));
			print(g.get(i));
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(b.get(i) + "  ");
			print(b.get(i));
		}
		System.out.println();
	}

	/** Add space padding between data in table */
	public static void print(String str) {
		int space = 10 - str.length();
		for (int j = 0; j < space; j++) {
				System.out.print(" ");
		}
	}

	/** Displays table header */
	public static void print() {
		System.out.println(
		"--------------------------------------------------------" +
		"-------------------------------------------------------------\n" +
		" Year  Rank 1    Rank 2    Rank 3    Rank 4    Rank 5    " +
		"Rank 1      Rank 2      Rank 3      Rank 4      Rank 5\n" +
		"--------------------------------------------------------" +
		"-------------------------------------------------------------");
	}

	/** Reads a URL input stream into an ArrayList */
	public static void readURL(Scanner input, ArrayList<String> list) {
			for (int i = 0; i < 5; i++) {
				list.add(i, input.next());
			}
	}

	/** Returns a formatted URL string */
	public static String getURL(int year) {
		return "http://www.cs.armstrong.edu/liang/data/babynamesranking" +
				year + ".txt";
	}
}