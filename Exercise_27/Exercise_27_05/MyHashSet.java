public class MyHashSet<E> implements MySet<E> {
	MyMap<E, E> map;

	public MyHashSet() {
		map = new MyHashMap<>();
	}

	public MyHashSet(int initialCapacity) {
		map = new MyHashMap(initialCapacity);
	}

	public MyHashSet(int initialCapacity, float loadFactorThreshold) {
		map = new MyHashMap(initialCapacity, loadFactorThreshold);
	}

	@Override /** Remove all elements in this set */
	public void clear() {
		map.clear();
	}

	@Override /** Return true if element is in set */
	public boolean contains(E e) {
		return map.containsKey(e) && map.containsValue(e);
	}

	@Override /** Add and element to the set */
	public E add(E e){
		E element = map.put(e, e);
		return element;
	}

	@Override /** Remove the element from the set */
	public boolean remove(E e) {
		if (!map.containsKey(e))
			return false;
		
		map.remove(e);
		return true;
	}

	@Override /** Return true if the set doesn't contain any elements */
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override /** Return the number of elements in the set */
	public int size() {
		return map.size();
	}

	@Override /** Return an iterator for the elements in this set */
	public java.util.Iterator<E> iterator() {
		return new MyHashSetIterator(this);
	}

	/** Inner class for iterator */
	private class MyHashSetIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list;
		private int current = 0; // Point to the current element in list
		private MyHashSet<E> set;

		/** Create a list from the set */
		public MyHashSetIterator(MyHashSet<E> set) {
			this.set = set;
			list = setToList();
		}

		@Override /** Next element for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		@Override /** Get current element an move cursor to the next */
		public E next() {
			return list.get(current++);
		}

		/** Remove the current element and refresh the list */
		public void remove() {
			// Delete the current element form the hash set
			set.remove(list.get(current));
			list.remove(current); // Remove current element from the list
		}
	}

	/** Copy elements in the hash set to an arry list */
	private java.util.ArrayList<E> setToList() {
		java.util.ArrayList<E> list = new java.util.ArrayList<>();
		java.util.Set<E> set = map.keySet();

		for (E e: set) {
			list.add(e);
		}

		return list;
	}

	@Override /** Return a string representation for this set */
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		java.util.ArrayList<E> list = setToList();

		for (int i = 0; i < list.size() - 1; i++) {
			builder.append(list.get(i) + ", ");
		}

		if (list.size() == 0)
			builder.append("]");
		else
			builder.append(list.get(list.size() - 1) + "]");
		return builder.toString();
	} 
}