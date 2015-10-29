/**********************************************************************************
* (Clone PriorityQueue) Define MyPriorityQueue class that extends PriorityQueue   *
* to implement the Cloneable interface and implement the clone() method to clone  *
* a priority queue.                                                               *
**********************************************************************************/
public class Exercise_20_12 {
	public static void main(String[] args) throws CloneNotSupportedException {
		// Create a string MyPriorityQueue and 4 state names
		MyPriorityQueue<String> queue1 = new MyPriorityQueue<>();
		queue1.offer("Oklahoma");
		queue1.offer("Indiana");
		queue1.offer("Georgia");
		queue1.offer("Texas");

		// Clone queue1 to queue2
		MyPriorityQueue<String> queue2 = queue1.clone();

		// Add 2 more state names to queue 1
		queue1.offer("New York");
		queue1.offer("New Jersey");

		// Remove 1 state from queue 2
		queue2.remove();
		
		// Display queues
		System.out.print("Queue1: ");
		while (queue1.size() > 0) {
			System.out.print(queue1.remove() + " ");
		}
		System.out.println();

		System.out.print("Queue2: ");
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
		System.out.println();
	}
}