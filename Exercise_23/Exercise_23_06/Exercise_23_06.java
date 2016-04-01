/*********************************************************************************
* (Check order) Write the following overloaded methods that check whether an     *
* array is ordered in ascending order or descending order. By default, the       *
* method checks ascending order. To check descending order, pass false to the    *
* ascending argument in the method.                                              *
*********************************************************************************/
import java.util.Comparator;

public class Exercise_23_06 {
	/* Overloaded method checks whether an int array is in ascending order */
	public static boolean ordered(int[] list) {
		return ordered(list, true);
	}

	/* Overloaded method checks whether an int 
	    array is in ascending of descending order */
	public static boolean ordered(int[] list, boolean ascending) {
		boolean descending = !ascending;

		for (int i = 0; i < list.length - 1; i++) {
			if (ascending && list[i] > list[i + 1]) {
				return false;
			}
			else if (descending && list[i] < list[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/* Overloaded method checks whether an 
		array of doubles is in ascending order */
	public static boolean ordered(double[] list) {
		return ordered(list, true);
	}

	/* Overloaded method checks whether an array of
		doubles is in ascending or descending order */
	public static boolean ordered(double[] list, boolean ascending) {
		boolean descending = !ascending;

		for (int i = 0; i < list.length - 1; i++) {
			if (ascending && list[i] > list[i + 1])
				return false;
			else if (descending && list[i] < list[i + 1])
				return false;
		}
		return true;
	}

	/* Overload method checks whether an 
		array of objects is in ascending order */
	public static <E extends Comparable<E>> boolean ordered(E[] list) {
		return ordered(list, true);
	}

	/* Overload method checks whether an array of
		objects is in ascending or descending order */
	public static <E extends Comparable<E>> boolean 
			ordered(E[] list, boolean ascending) {
		boolean descending = !ascending;

		for (int i = 0; i < list.length - 1; i++) {
			if (ascending && list[i].compareTo(list[i + 1]) > 0)
				return false;
			else if (descending && list[i].compareTo(list[i + 1]) < 0)
				return false;
		}
		return true;
	}

	/* Overload method checks whether an 
		array of elements is in ascending order */
	public static <E> boolean ordered(
			E[] list, Comparator<? super E> comparator) {
		return ordered(list, comparator, true);
	}

	/* Overload method checks whether an array of 
		elements is in ascending or descending order */
	public static <E> boolean ordered(E[] list, 
			Comparator<? super E> comparator, boolean ascending) {
		boolean descending = !ascending;

		for (int i = 0; i < list.length - 1;  i++) {
			if (ascending && comparator.compare(list[i], list[i + 1]) > 0)
				return false;
			else if (descending && comparator.compare(list[i], list[i +1]) < 0)
				return false;
		}
		return true;
	}

	/** A test method */
	public static void main(String[] args) {
		// Create three integer arrays
		int[] list1 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; // No order
		int[] list2 = {1, 3, 5, 6, 12, 14, 20}; // ascending order
		int[] list3 = {20, 14, 12, 5, 3, -2}; // descending order

		// Create three double arrays
		double[] list4 = {2.1, 3.5, 2.1, 5.3, 6.7, 1.0, -2.6, 3.8, 14.2, 12.1};
		double[] list5 = {1.1, 3.0, 5.7, 6.8, 12.0, 14.2, 20.5}; // ascending order
		double[] list6 = {20.0, 14.0, 12.0, 5.5, 3.0, -2.0}; // descending order

		// Create an array of Integers 
		Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; // no order

		// Create an array of Characters
		Character[] charArray = {'J', 'a', 'r'}; // ascending order

		// Create an array of Strings
		String[] stringArray = {"Tom", "Carl", "Ann"}; // descending order

		// Create an array of 10 GeometricObjects
		GeometricObject[] list7 = {new Circle(5), new Rectangle(4,5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)}; // no order


		GeometricObject[] list8 = {new Circle(3), new Rectangle(3, 10),
			new Circle(5)}; // ascending order

		GeometricObject[] list9 = {new Circle(10), new Rectangle(3, 10),
			new Circle(2)}; // descending order

		// Check an display the order of the arrays
		System.out.println("List1 is" + 
			(ordered(list1) ? " " : " not ") + "ordered in ascending order.");

		System.out.println("List2 is" + 
			(ordered(list2) ? " " : " not ") + "ordered in ascending order.");

		System.out.println("List3 is" + 
			(ordered(list3, false) ? " " : " not ") + "ordered in descending order.");

		System.out.println("List2 is" + 
			(ordered(list2, false) ? " " : " not ") + "ordered in descending order.");

		System.out.println("List4 is" + 
			(ordered(list4) ? " " : " not ") + "ordered in ascending order.");

		System.out.println("List5 is" + 
			(ordered(list5) ? " " : " not ") + "ordered in ascending order.");

		System.out.println("List6 is" + 
			(ordered(list6, false) ? " " : " not ") + "ordered in descending order.");

		System.out.println("List5 is" + 
			(ordered(list5, false) ? " " : " not ") + "ordered in descending order.");

		System.out.println("The array of Integers is" + 
			(ordered(intArray) ? " " : " not ") + "ordered in ascending order.");

		System.out.println("The array of Characters is" + 
			(ordered(charArray) ? " " : " not ") + "ordered in ascending order.");

		System.out.println("The array of Strings is" + 
			(ordered(stringArray, false) ? " " : " not ") + 
			"ordered in descending order.");

		System.out.println("The array of Characters is" + 
			(ordered(charArray, false) ? " " : " not ") + 
			"ordered in descending order.");

		System.out.println("List7 is" + (ordered(list7, 
			new GeometricObjectComparator()) ? " " : " not ") + 
			"ordered in ascending order.");

		System.out.println("List8 is" + (ordered(list8, 
			new GeometricObjectComparator()) ? " " : " not ") +
			"ordered in ascending order.");

		System.out.println("List9 is" + (ordered(list9, 
			new GeometricObjectComparator(), false) ? " " : " not ") + 
			"ordered in descending order.");

		System.out.println("List8 is" + (ordered(list8, 
			new GeometricObjectComparator(), false) ? " " : " not ") + 
			"ordered in descending order.");
	}
}