import java.util.Comparator;

public class MyPriorityQueue<E>{
	private Comparator<? super E> comparator;
	private Heap<E> heap;

	MyPriorityQueue(Comparator<? super E> comparator) {
		this.comparator = comparator; 
		this.heap = new Heap<>(comparator);
	}

	public void enqueue(E newObject) {
		heap.add(newObject);
	}

	public E dequeue() {
		return heap.remove();
	}

	public int getSize() {
		return heap.getSize();
	}
}