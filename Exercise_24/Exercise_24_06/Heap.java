import java.util.Comparator;
import java.util.ArrayList;

public class Heap <E>{
	private Comparator<? super E> comparator;
	private ArrayList<E> list = new ArrayList<>();


	/** Create a default heap */
	public Heap() {
	}

	/** Create a heap from an array of objcets using comparator */
	public Heap(Comparator<? super E> comparator) {
		this.comparator = comparator;
	}

	/** Create a heap from an array of objects using comparator */
	public Heap(E[] objects, Comparator<? super E> comparator) {
		this.comparator = comparator;
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}

	/** Add a new object into the heap */
	public void add(E newObject) {
		list.add(newObject); // Append to the heap
		int currentIndex = list.size() - 1; // The index of the last node

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			// Swap if the current object is greater than its parent
			
			if (comparator.compare(list.get(currentIndex), 
				list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break; // The tree is a heap now

			currentIndex = parentIndex;
		}
	}

	/** Remove the root from the heap */
	public E remove() {
		if (list.size() == 0) return null;

		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);

		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;

			// Find the maximum between two children
			if (leftChildIndex >= list.size()) break; // The tree is a heap
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (comparator.compare(list.get(maxIndex),
					list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}

			// Swap if the current node is less than the maximum
			if (comparator.compare(list.get(currentIndex),
				list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			}
			else
				break; // The tree is a heap
		}

		return removedObject;
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return list.size();
	}
}