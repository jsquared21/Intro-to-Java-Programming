/*********************************************************************************
* (Game: hangman) Write a hangman game that randomly generates a word and        *
* prompts the user to guess one letter at a time, as shown in the sample run.    *
* Each letter in the word is displayed as an asterisk. When the user makes a     *
* correct guess, the actual letter is then displayed. When the user finishes a   *
* word, display the number of misses and ask the user whether to continue to     *
* play with another word. Declare an array to store words, as follows:           *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_35 {
	/* Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String play; // 'y' or 'n'
		do {
			// Generate a random word 
			char[] word = getWord();
			
			// Display each letter in the word as an asterisk.
			char[] asterisks = new char[word.length];
			fillAsterisks(asterisks);

			int missed = 0; // number of wrong guesses
			do {
				// Prompt the user to guess one letter
				char guess = getGuess(asterisks);		
				
				// Check if is letter is correct
				if (!isCorrectGuess(word, asterisks, guess))
					missed++;
					
			} while (!isWordFinish(asterisks));
			
			// Print results
			print(word, missed);
			
			// Ask the user whether to continue to play with another word
			System.out.println("Do you want to guess another word? Enter y or n>");
			play = input.next();

		} while (play.charAt(0) == 'y');
	}

	/* getWord randomly generates a word from a list */
	public static char[] getWord() {
		String[] words = {"write", "that", "program", "monkey", "rooster", "dog", 
								"pig", "rat", "ox", "tiger", "rabbit", "dragon", "snake", 
								"horse", "sheep"};

		String pick = words[(int)(Math.random() * words.length)];
		char[] word = new char[pick.length()];

		for (int i = 0; i < word.length; i++) {
			word[i] = pick.charAt(i);
		}
		return word;
	}

	/** fillAsterisks initializes a list with asterisks */
	public static void fillAsterisks(char[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = '*';
		}
	}

	/** checkGuess tests if the users guess was correct */
	public static boolean isCorrectGuess(char[] word, char[] blanks, char guess) {
		boolean correct = false;
		int message = 2;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == guess) {
				correct = true;
				if (blanks[i] == guess)
					message = 1;
				else { 
					blanks[i] = guess; // the actual letter is then displayed.
					message = 0;
				}
			}
		}
		if (message > 0)
			print(message, guess);
		return correct;
	}

	/** isWordFinish */
	public static boolean isWordFinish(char[] blanks) {
		for (char e: blanks) {
			if (e == '*')
				return false;
		}
		return true;
	}

	/** print overloaded */
	public static void print(char[] word, int missed) {
		System.out.print("The word is ");
		System.out.print(word);
		System.out.println(" You missed " + missed + " time");
	}

	/** print overloaded */
	public static void print(int m, char guess) {
		System.out.print("\t" + guess);
		switch (m) {
			case 1 : System.out.println(" is already in the word"); break;
			case 2 : System.out.println(" is not in the word");
		}
	}

	/** getGuess prompts the user to guess one letter at a time */
	public static char getGuess(char[] asterisks){
		Scanner input = new Scanner(System.in);
		System.out.print("(Guess) Enter a letter in word ");
		System.out.print(asterisks);
		System.out.print(" > ");
		String g = input.next();
		return g.charAt(0);
	}
}