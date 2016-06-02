public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	/** Create a default list */
	public MyLinkedList() {
	}

	/** Create a list from an array of objects */
	public MyLinkedList(E[] objects) {
		super(objects);
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increate list size

		if (tail == null) // The new node is the only node in list
			tail = head;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node for e
		if (tail == null) {
			head = tail = newNode; // The on;y node in list
		}
		else {
			tail.next = newNode; // Link the new node with the last node
			tail = tail.next; // tail now points to the last node
		}

		size++; // Increase size
	}

	@Override /** Add a new element at the specified index
		* in this list. The lndex of the head element is 0 */
	public void add(int index, E e) {
		if (index == 0) addFirst(e); // Insert first
		else if (index >= size) addLast(e); // Insert last
		else { // Insert in the middle
			Node<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}

	/** Remove the head node and 
	 *  return the object that is contained in the removed node. */
	public E removeFirst() {
		if (size == 0) return null; // Nothing to delete
		else {
			Node<E> temp = head; // keep the first node temporarily
			head = head.next; // Move head to point to next node
			size--; // Reduce size by 1
			return temp.element; // Return the deleted element
		}
	}

	/** Remove the last node and
	 * return the object that is contained in the removed node. */
	public E removeLast() {
		if (size == 0) return null; // Nothing to remove
		else if (size == 1) { // Only one element in the list
			Node<E> temp = head;
			head = tail = null; // list becomes empty
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++)
				current = current.next;		

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override /** Remove the element at the specified position in this
		* list. Return the element that was removed from the list. */
	public E remove(int index) {
		if (index < 0 || index >= size) return null; // Out of range
		else if (index == 0) return removeFirst(); // Remove first
		else if (index == size - 1) return removeLast(); // Remove last
		else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			}
			else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override /** Clear the list */
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override /** Return true if this list contains the element e */
	public boolean contains(E e) {
		if (size == 0) return false;
		else {
			Node<E> current = head;

			while (current != null) {
				if (current.element == e)
					return true;
				current = current.next;
			}
		}
		return false;
	}

	@Override /** Return the element at the specified index */
	public E get(int index) {
		if (index < 0 || index >= size) return null; // Out of range
		else if (index == 0) return getFirst();
		else if (index == size - 1) return getLast();
		else {
			Node<E> current = head.next;

			for (int i = 1; i < index; i++)
				current = current.next;
			return current.element;
		}

	}

	@Override /** Return the index of the head matching element
		* in this list. Return -1 if no match. */
	public int indexOf(E e) {
		if (head.element == e) return 0;
		else if (tail.element == e) return size - 1;
		else {
			Node<E> current = head.next;
			int index = 1;
			while (current != null) {
				if (current.element == e)
					return index;
				current = current.next;
				index++;
			}
		}
		return -1;
	}

	@Override /** Return the index of the last matching element
		* in this list. Rreturn -1 if on match. */
	public int lastIndexOf(E e) {
		int index = -1;
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element == e)
				index = i;
			current = current.next;
		}

		return index;
	}

	@Override /** Replace the element at the specified position
		* in this list with the specified element. */
	public E set(int index, E e) {
		if (index < 0 || index > size - 1) return null;
		else {
			Node<E> current = head;
			for (int i = 0; i < index; i++)
				current = current.next;
	
			current.element = e;
			return current.element;
		}
	}

	@Override /** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	public class LinkedListIterator
			implements java.util.Iterator<E> {
		private Node<E> current = head; // Current index

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			System.out.println("Implementation left as an exercise");
		}
	}

	// This class is only used in LinkedList, so it is private.
	// This class does not need to access any
	// instance members of LinkedList, so it is defined static.
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}