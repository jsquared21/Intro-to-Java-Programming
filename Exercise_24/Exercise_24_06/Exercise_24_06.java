/*********************************************************************************
* (Generic PriorityQueue using Comparator) Revise MyPriorityQueue in Listing     *
* 24.9, using a generic parameter for comparing objects. Define a new            *
* constructor with a Comparator as its argument as follows:                      *
*                                                                                *
* PriorityQueue(Comparator<? super E> comparator)                                *
*********************************************************************************/
import java.util.Comparator;

public class Exercise_24_06 {
	public static void main(String[] args) {
		// Create 4 GeometricObjects
		GeometricObject object1 = new Circle(5);
		GeometricObject object2 = new Rectangle(4, 5);
		GeometricObject object3 = new Circle(6.5);
		GeometricObject object4 = new Rectangle(2.4, 5);

		// Create a priority queue
		MyPriorityQueue<GeometricObject> priorityQueue
			= new MyPriorityQueue<>(new GeometricObjectComparator());

		// Enqueue objects
		priorityQueue.enqueue(object1);
		priorityQueue.enqueue(object2);
		priorityQueue.enqueue(object3);
		priorityQueue.enqueue(object4);

		// Dequeue and display the area of each object
		System.out.printf("%.2f ", priorityQueue.dequeue().getArea());
		System.out.printf("%.2f ", priorityQueue.dequeue().getArea());
		System.out.printf("%.2f ", priorityQueue.dequeue().getArea());
		System.out.printf("%.2f ", priorityQueue.dequeue().getArea());
		System.out.println();
	}
}