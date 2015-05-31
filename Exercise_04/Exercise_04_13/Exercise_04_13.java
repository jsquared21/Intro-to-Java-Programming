/*
(Vowel or consonant?) Write a program that prompts the user to enter a letter and
check whether the letter is a vowel or consonant.
*/
import java.util.Scanner;

public class Exercise_04_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a letter
		System.out.print("Enter a letter: ");
		String s = input.nextLine();
		char ch = s.charAt(0);

		if (Character.isLetter(ch))
		{
			switch(Character.toUpperCase(ch))
			{
				case 'A': 
				case 'E': 
				case 'I': 
				case '0': 
				case 'U': System.out.println(ch + " is a vowel"); break;
				default : System.out.println(ch + " is a consonant"); 
			}
		}
		else
			System.out.println(ch + " is an invalid input");
	}
}