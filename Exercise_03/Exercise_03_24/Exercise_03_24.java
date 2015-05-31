/*
(Game: pick a card) Write a program that simulates picking a card from a deck
of 52 cards. Your program should display the rank (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10,
Jack, Queen, King) and suit (Clubs, Diamonds, Hearts, Spades) of the card.
Here is a sample run of the program:
*/
public class Exercise_03_24 {
	public static void main(String[] args) {
		// Generate a random integer 1 - 13
		int rank = (int)((Math.random() * (14 - 1)) + 1);

		// Generate a random integer 1 - 4
		int suit = (int)(Math.random() * 4);

		// Display card picked from deck
		System.out.print("The card you picked is ");
		switch(rank) // Get rank
		{
			case 1: System.out.print("Ace"); break;
			case 2: System.out.print(rank); break;
			case 3: System.out.print(rank); break;
			case 4: System.out.print(rank); break;
			case 5: System.out.print(rank); break;
			case 6: System.out.print(rank); break;
			case 7: System.out.print(rank); break;
			case 8: System.out.print(rank); break;
			case 9: System.out.print(rank); break;
			case 10: System.out.print(rank); break;
			case 11: System.out.print("Jack"); break;
			case 12: System.out.print("Queen"); break;
			case 13: System.out.print("King"); 
		}
		System.out.print(" of ");
		switch (suit) // Get suit
		{
			case 0: System.out.println("Clubs"); break;
			case 1: System.out.println("Diamonds"); break;
			case 2: System.out.println("Hearts"); break;
			case 3: System.out.println("Spades"); 
		}
	}
}