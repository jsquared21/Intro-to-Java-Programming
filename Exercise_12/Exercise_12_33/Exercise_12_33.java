/*********************************************************************************
* (Search Web) Modify Listing 12.18 WebCrawler.java to search for the word       *
* Computer Programming starting from the URL http://cs.armstrong.edu/liang.      *
* Your program terminates once the word is found. Display the URL for the page   *
* that contains the word.                                                        *
*********************************************************************************/
import java.util.*;

public class Exercise_12_33 {
	/** Main method */
	public static void main(String[] args) {
		// Word to be searched for
		String searchWord = "Computer Programming";

		// URL to start search
		String startingURL = "http://cs.armstrong.edu/liang";

		// Invoke crawler
		crawler(startingURL, searchWord);
	}

	public static void crawler(String startingURL, String word) {
		ArrayList<String> listOfPendingURLs = new ArrayList<>();
		ArrayList<String> listOfTraversedURLs = new ArrayList<>();

		listOfPendingURLs.add(startingURL);
		while (!listOfPendingURLs.isEmpty()) {
			String urlString = listOfPendingURLs.remove(0);
			if (!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				if (containsString(urlString, word)) {
					System.out.println("The word " + word + 
						" was found on URL: " + urlString);
					System.exit(0);
				}

				for (String s: getSubUrls(urlString)) {
					if (!listOfTraversedURLs.contains(s))
						listOfPendingURLs.add(s);
				}
			}
		}

		System.out.println(word + " was not found after crawling " + startingURL);
	}

	/** Returns true if the url contains the specified word */
	public static boolean containsString(String urlString, String word) {
		ArrayList<String> list = new ArrayList<>();

		try {
			java.net.URL url = new java.net.URL(urlString);
			Scanner input = new Scanner(url.openStream());

			while (input.hasNext()) {
				String line = input.nextLine();
				if (line.contains(word))
					return true;
			}
		}
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}

		return false;
	}

	public static ArrayList<String> getSubUrls(String urlString) {
		ArrayList<String> list = new ArrayList<>();

		try {
			java.net.URL url = new java.net.URL(urlString);
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			while (input.hasNext()) {
				String line = input.nextLine();
				current = line.indexOf("http:", current);
				while (current > 0) {
					int endIndex = line.indexOf("\"", current);
					if (endIndex > 0) { // Ensure that a correct URL is found
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					}
					else
						current = -1;
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}

		return list;
	}
}