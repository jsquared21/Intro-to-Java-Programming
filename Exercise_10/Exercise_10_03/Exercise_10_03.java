/*********************************************************************************
* (The MyInteger class) Design a class named MyInteger. The class contains:      *
*                                                                                *
* ■ An int data field named value that stores the int value represented by this  *
*   object.                                                                      *
* ■ A constructor that creates a MyInteger object for the specified int value.   *
* ■ A getter method that returns the int value.                                  *
* ■ The methods isEven(), isOdd(), and isPrime() that return true if the         *
*   value in this object is even, odd, or prime, respectively.                   *
* ■ The static methods isEven(int), isOdd(int), and isPrime(int) that            *
*   return true if the specified value is even, odd, or prime, respectively.     *
* ■ The static methods isEven(MyInteger), isOdd(MyInteger), and                  *
*   isPrime(MyInteger) that return true if the specified value is even, odd,     *
*   or prime, respectively.                                                      *
* ■ The methods equals(int) and equals(MyInteger) that return true if            *
*   the value in this object is equal to the specified value.                    *
* ■ A static method parseInt(char[]) that converts an array of numeric           *
*   characters to an int value.                                                  *
* ■ A static method parseInt(String) that converts a string into an int          *
*   value.                                                                       *
*                                                                                *
* Draw the UML diagram for the class and then implement the class. Write a       *
* client program that tests all methods in the class.                            *
*********************************************************************************/
public class Exercise_10_03 {
	/** Main method */
	public static void main(String[] args) {
		// Create an array of test values
		int[] values = {5, 6, 7, 8, 9}; 

		// Test isEven(int), isOdd(int), and isPrime(int)
		System.out.println("\nTest if values are even using isEven(int):");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i] + " " + MyInteger.isEven(values[i]));
		}

		System.out.println("\nTest if values are odd using isOdd(int):");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i] + " " + MyInteger.isOdd(values[i]));
		}

		System.out.println("\nTest if values are prime using isPrime(int):");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i] + " " + MyInteger.isPrime(values[i]));
		}

		// Test MyInteger(), isEven(), isOdd(), isPrime() and getValue()
		System.out.println("\nTest if values are even using isEven():");
		for (int i = 0; i < values.length; i++) {
			// Create a MyInteger
			MyInteger value = new MyInteger(values[i]);
			System.out.println(value.getValue() + " " + value.isEven());
		}

		System.out.println("\nTest if values are odd using isOdd():");
		for (int i = 0; i < values.length; i++) {
			// Create a MyInteger
			MyInteger value = new MyInteger(values[i]);
			System.out.println(value.getValue() + " " + value.isOdd());
		}

		System.out.println("\nTest if values are prime using isPrime():");
		for (int i = 0; i < values.length; i++) {
			// Create a MyInteger
			MyInteger value = new MyInteger(values[i]);
			System.out.println(value.getValue() + " " + value.isPrime());
		}

		// Test isEven(MyInteger), isOdd(MyInteger), isPrime(MyInteger)
		System.out.println("\nTest if values are even using isEven(MyInteger):");
		for (int i = 0; i < values.length; i++) {
			// Create a MyInteger
			MyInteger value = new MyInteger(values[i]);
			System.out.println(value.getValue() + " " + MyInteger.isEven(value));
		}

		System.out.println("\nTest if values are odd using isOdd(MyInteger):");
		for (int i = 0; i < values.length; i++) {
			// Create a MyInteger
			MyInteger value = new MyInteger(values[i]);
			System.out.println(value.getValue() + " " + MyInteger.isOdd(value));
		}

		System.out.println("\nTest if values are prime using isPrime(MyInteger):");
		for (int i = 0; i < values.length; i++) {
			// Create a MyInteger
			MyInteger value = new MyInteger(values[i]);
			System.out.println(value.getValue() + " " + MyInteger.isPrime(value));
		}

		// Test equals(int) and equals(MyInteger)
		int[] values2 = {5, 9, 7};
		MyInteger value = new MyInteger(9);
		System.out.println("\nTest if " + value.getValue() + 
			" is equal to the specified value:");
		for (int i = 0; i < values2.length; i++) {
			System.out.println(values2[i] + " " + value.equals(values2[i]));
		}

		System.out.println("\nTest if " + value.getValue() + 
			" is equal to the specified value:");
		for (int i = 0; i < values2.length; i++) {
			MyInteger myInteger = new MyInteger(values2[i]);	
			System.out.println(values2[i] + " " + value.equals(myInteger));
		}

		// Test parseInt(char[]) and parseInt(String)
		System.out.println("\nTest parseInt(char[]) and parseInt(String):");
		// Create a character array
		char[] numericCharacters = {'3', '4', '2'};

		// Create a string
		String numericString = "658";
		System.out.print("\'");
		for (int i = 0; i < numericCharacters.length; i++) {
		 	System.out.print(numericCharacters[i] + "");
		} 
		System.out.println("\' + \"" + numericString + "\" = " + 
			(MyInteger.parseInt(numericCharacters) + 
			MyInteger.parseInt(numericString)));
	}
}