/**************************************************************************
* (Perform set operations on priority queues) Create two priority queues, *
* {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and              *
* {"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their union, *
* difference, and intersection.                                           *
**************************************************************************/
import java.util.*;

public class Exercise_20_10 {
	public static void main(String[] args) {
		// Create two priority queues
		PriorityQueue<String> queue1 = new PriorityQueue<>(Arrays.asList(
			"George", "Jim", "John", "Blake", "Kevin", "Michael"));

		PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList(
			"George", "Katie", "Kevin", "Michelle", "Ryan"));

		// Display the two sets and union, difference, and intersection
		System.out.println("Set1: " + queue1);
		System.out.println("Set2: " + queue2);
		System.out.println("Union of sets: " + union(queue1, queue2));
		System.out.println("Difference of sets: " + difference(queue1, queue2));
		System.out.println("Intersection of sets: " + intersection(queue1, queue2));
	}

	/** Method returns the union of two sets */
	private static <T> PriorityQueue<T> union(
			PriorityQueue<T> set1, PriorityQueue<T> set2) {
		PriorityQueue<T> union = new PriorityQueue<>(set1);
		union.addAll(set2); 
		return union;
	} 

	/** Method returns the difference of two sets */
	private static <T> PriorityQueue<T> difference(
			PriorityQueue<T> set1, PriorityQueue<T> set2) {
		PriorityQueue<T> difference = new PriorityQueue<>(set1);
		difference.removeAll(set2);
		return difference;
	}

	/** Method returns the intersection of two sets */
	private static <T> PriorityQueue<T> intersection(
			PriorityQueue<T> set1, PriorityQueue<T> set2) {
		PriorityQueue<T> intersection = new PriorityQueue<>(set1);
		intersection.retainAll(set2);
		return intersection;
	}
}