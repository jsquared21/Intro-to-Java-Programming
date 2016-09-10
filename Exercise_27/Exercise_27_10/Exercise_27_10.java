/*********************************************************************************
* (Compare MyHashSet and MyArrayList) MyArrayList is defined in Listing 24.3.    *
* Write a program that generates 1000000 random double values between 0 and      *
* 999999 and stores them in a MyArrayList and in a MyHashSet. Generate a list of *
* 1000000 random double values between 0 and 999999. For each number in the     *
* list, test if it is in the array list and in the hash set. Run your program to *
* display the total test time for the array list and for the hash set.           *
*********************************************************************************/
public class Exercise_27_10 {
	static final int VALUES = 1000000;

	public static void main(String[] args) {
		MySet<Double> set = new MyHashSet<>(); // Create a MyHashSet
		MyList<Double> arrayList = new MyArrayList<>(); // Create a MyArrayList

		// Generate 1000000 random double values between 0 and 999999
		for (int i = 0; i < VALUES; i++) {
			double randomDouble = Math.random() * VALUES;
			set.add(randomDouble);
			arrayList.add(randomDouble);
		}
		
		// Create a list
		double[] list = new double[VALUES];
		for (int i = 0; i < list.length; i++) {
			list[i] = Math.random() * VALUES;
		}

		System.out.println("Total time for the hash set: " +
			testTimeSet(list, set) + " milliseconds");

		System.out.println("Total time for the array list: " +
			testTimeArray(list, arrayList) + " milliseconds");
	}

	/** Return total test time for the hash set */
	public static long testTimeSet(double[] list, MySet<Double> set) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < VALUES; i++) {
			set.contains(list[i]);
		}
		return System.currentTimeMillis() - startTime;
	}

	/** Return total test time for the array list */
	public static long testTimeArray(double[] list, MyList<Double> array) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < VALUES; i++) {
			array.contains(list[i]);
		}
		return System.currentTimeMillis() - startTime;
	}
}