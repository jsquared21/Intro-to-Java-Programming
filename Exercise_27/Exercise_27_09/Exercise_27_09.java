/*********************************************************************************
* (Implement hashCode for string) Write a method that returns a hash code for    *
* string using the approach described in Section 27.3.2 with b value 31. The     *
* function header is as follows:                                                 *
*                                                                                *
* public static int hashCodeForString(String s)                                  *
*********************************************************************************/
public class Exercise_27_09 {
	public static void main(String[] args) {
		// Create a list if string
		String[] list = {"Mark", "Smith", "tops", "pots", "tod", "dot"};

		// Print the hash code for each string
		for (String e : list) {
			System.out.println("The hash code for \"" + e +
				"\" is " + hashCodeForString(e));
		}

	}

	/** Retrun the hash code for string */
	public static int hashCodeForString(String s) {
		int b = 31;
		int hashCode = 0;
		for (int i = 0; i < s.length(); i++) { 
			hashCode = b * hashCode + (int)s.charAt(i); 
		}
		return hashCode;
	}
}