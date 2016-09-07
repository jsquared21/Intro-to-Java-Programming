public interface MySet<E> extends java.lang.Iterable<E> {
	/** Remove all elements in this set */
	public void clear();

	/** Return true if element is in set */
	public boolean contains(E e);

	/** Add an element to the set */
	public E add(E e);

	/** Remove the element from the set */
	public boolean remove(E e);

	/** Return true if the set doesn't contain any elements */
	public boolean isEmpty();

	/** Return the number of elements in the set */
	public int size();
}