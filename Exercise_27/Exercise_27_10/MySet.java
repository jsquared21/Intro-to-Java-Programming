public interface MySet<E> extends java.lang.Iterable<E> {
	/** Remove all elements from this set */
	public void clear(); 

	/** Return true if the element is in the set */
	public boolean contains(E e);

	/** Add an element to the set */
	public boolean add(E e) ;

	/** Remove the element from the set*/
	public boolean remove(E e);

	/** Return true if the set doesn't contain any elements */
	public boolean isEmpty();

	/** Return the number of elements in the set */
	public int size();
}