public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the last

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	@Override /** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	@Override /** Return true if this list doesn't contain any elements */
	public boolean isEmpty() {
		return size == 0;
	}

	@Override /** Return the number of elements in this list */
	public int size() {
		return size;
	}

	@Override /** Remove the first occurence of the element e
		*	from this list. Shift any subsequent elements to the left.
		*  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else
			return false;
	}

	@Override /** Adds the elements in otherList to this list.
		* Returns true if this list changed as a result of the call */
	public boolean addAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = 0; i < otherList.size(); i++) {
			E e = otherList.get(i);
			if (!contains(e)){
				add(e);
				changed = true;
			}
		}
		return changed;
	}

	@Override /** Removes all the elements in otherList from this list
		* Returns true if this list changed as a result of the call */
	public boolean removeAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = 0; i < otherList.size(); i++) {
			E e = otherList.get(i); 
			if (contains(e)) {
				remove(e);
				changed = true;
			}
		}
		return changed;
	}

	@Override /** Retains the elements in this list that are also in otherList
		* Returns true if this list changed as a result of the call */
	public boolean retainAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = size - 1; i >= 0; i--) {
			E e = get(i);
			if (!otherList.contains(e)) {
				remove(i);
				changed = true;
			}
		}
		return changed;
	}
}