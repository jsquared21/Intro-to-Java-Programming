/*********************************************************************************
* (Implement the StringBuilder class) The StringBuilder class is provided        *
* in the Java library. Provide your own implementation for the following methods *
* (name the new class MyStringBuilder1):                                         *
*                                                                                *
* public MyStringBuilder1(String s);                                             *
* public MyStringBuilder1 append(MyStringBuilder1 s);                            *
* public MyStringBuilder1 append(int i);                                         *
* public int length();                                                           *
* public char charAt(int index);                                                 *
* public MyStringBuilder1 toLowerCase();                                         *
* public MyStringBuilder1 substring(int begin, int end);                         *
* public String toString();                                                      *
*********************************************************************************/
public class Exercise_10_27 {
	/** Main method */
	public static void main(String[] args) {
		// Create a MyStringBuilder1 object
		MyStringBuilder1 str1 = new MyStringBuilder1("TEST");

		System.out.println("\nAppend the string \" MyStringBuilder1\" to string: " + 
			str1.append(new MyStringBuilder1(" MyStringBuilder1")));

		// Display string with the integer 101 append to it
		System.out.println("\nAppend integer 101 to the string: " + str1.append(101));

		// Display the length of str1
		System.out.println("\nLength of string: " + str1.length());

		// Display character at index 2
		System.out.println("\nCharacter at index 2: " + str1.charAt(2));

		// Display str1 as lowercase
		System.out.println("\nString to lower case: " + str1.toLowerCase());

		// Display the substring of str1 from index 1 to 3
		System.out.println("\nSubstring of string from index 1 to 3: " + 
			str1.substring(1, 3));

		// Return the string
		System.out.println("\nDisplay string: " + str1.toString());
	}
}