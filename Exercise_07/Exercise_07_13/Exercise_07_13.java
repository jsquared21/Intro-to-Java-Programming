/*********************************************************************************
* (Random number chooser) Write a method that returns a random number between    *
* 1 and 54, excluding the numbers passed in the argument. The method header is   *
* specified as follows:                                                          *
* public static int getRandom(int... numbers)                                    *
*********************************************************************************/
public class Exercise_07_13 {
	
	/** Method getRandom returns a random number between 1 and 54,
	*   excluding the numbers passed in the argument.*/
	public static int getRandom(int... numbers) {
		int num;	// Random number
		boolean isExcluded; // Is the number excluded
		do { 
			isExcluded = false;
			num = 1 + (int)(Math.random() * 5);
			for (int e: numbers) {
				if (num == e)
					isExcluded = true;
			}
		} while (isExcluded); // Test if number is Excluded
		return num;
	}
}