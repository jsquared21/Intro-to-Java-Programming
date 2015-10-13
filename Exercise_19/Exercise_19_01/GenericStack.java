public class GenericStack<E> {
	private E[] list = (E[])new Object[10];
	private int size = 0;
 	
 	/** Return the number of elements in the stack */
	public int getSize() {
		return size;
	}

	/** Return the top element from the stack */
	public E peek() {
		return list[size - 1];
	}

	/** Push a new element to the top of the stack */
	public void push(E o) {
		if (size >= list.length) {
			doubleList();
		}
		list[size++] = o;
	}

	/** Return and remove the top element from the stack */
	public E pop() {
		E o = list[--size];
		return o;
	}

	/** Test whether the stack is empty */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Create a new array that is double the current array size
	  * and copy the elements from the current array to the new array */
	private void doubleList() {
		E[] tempList = (E[])new Object[list.length * 2];
		System.arraycopy(list, 0, tempList, 0, list.length);
		list = tempList;
	}

	@Override // Override the toString array in the Object class
	public String toString() {
		return "stack: " + list.toString();
	}
}