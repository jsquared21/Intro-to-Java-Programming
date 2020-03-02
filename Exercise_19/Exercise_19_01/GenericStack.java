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
		if (--size < 0)
		    size = 0;
		E o = list[size];
		E[] new_list = (E[]) new Object[list.length];
		System.arraycopy(list, 0, new_list, 0, size);
		list = new_list;
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
		String s = "Stack: [";
		if (isEmpty())
			return s + "]";
		for (int i = 0; i < size; i++) {
		    if (i == size-1)
			s += list[i].toString() + "]";
		    else 
			s += list[i].toString() + ", ";
		}
		return s;
	}
}
