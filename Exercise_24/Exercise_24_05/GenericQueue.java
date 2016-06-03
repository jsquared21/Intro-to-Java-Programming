public class GenericQueue<E> extends java.util.LinkedList<E> {

	public void enqueue(E e) {
		addLast(e);
	}

	public E dequeue() {
		return removeFirst();
	}

	public int getSize() {
		return size();
	}
}