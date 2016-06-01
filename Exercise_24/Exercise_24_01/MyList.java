public interface MyList<E> extends java.lang.Iterable<E> {
	/** Add a new element at the end of this list */
	public void add(E e);

	/** Add a new element at the specified index in this list */
	public void add(int index, E e);

	/** Clear the list */
	public void clear();

	/** Return true if this list contains the element */
	public boolean contains(E e);

	/** Return the element from this list at the specified index */
	public E get(int index);

	/** Return the index of the first matching element in this list.
	 *  Return -1 if no match. */
	public int indexOf(E e);

	/** Return true if this list doesn't contain any elements */
	public boolean isEmpty();

	/** Return the index of the last matching element in this list
	 * Return -1 if no match. */
	public int lastIndexOf(E e);

	/** Remove the first occurrence of the element e from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e);

	/** Remove the element at the specified postion in this list.
	 *  Shift any subsequent element to the left
	 *  Return the element that was removed from the list. */
	public E remove(int index);

	/** Replace the element at the specified position in this list
	 * with the specified element and return the old element. */
	public Object set(int index, E e);

	/** Return the number of elements in this list */
	public int size();

	/** Adds the elements in otherList to this list.
	  * Returns true if this list changed as a result of the call */
	public boolean addAll(MyList<E> otherList);

	/** Removes all the elemants in otherList from this list
	  * Returns true if this list changed as a result of the call */
	public boolean removeAll(MyList<E> otherList);

	/** Retains the elements in this list that are also in otherList
	  * Returns true if this list changed as a result of the call */
	public boolean retainAll(MyList<E> otherList);
}