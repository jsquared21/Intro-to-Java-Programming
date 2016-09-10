public interface MyList<E> extends java.lang.Iterable<E> {
	/** Add a new element at the end of this list */
	public void add(E e);

	/** Add a new element at the specified index in this list */
	public void add(int index, E e);

	/** Clear the list */
	public void clear();

	/** Return true if list contains the element */
	public boolean contains(E e);

	/** Return the element from the list at the specified index */
	public E get(int index);

	/** Return the index of the first matching element in this list.
	 *	 Return -1 if no match. */
	public int indexOf(E e);

	/** Return true if this list doesn't contain any elements */
	public boolean isEmpty();
	
	/** Return the index of the last matching element in this list
	 *  Return -1 if no match. */
	public int lastIndexOf(E e);

	/** Remove the first occurence of the element e from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e);

	/** Remove the element at the specified position in this list.
	 *  Shift any subsequent elements to the left.
	 *  Return the element that was removed from the list. */
	public E remove(int index);

	/** Replace the element at the specified position in this list
	 *  with the specified element and return the old element. */
	public Object set(int index, E e);

	/** Return the number of elements in this list */
	public int size();
}