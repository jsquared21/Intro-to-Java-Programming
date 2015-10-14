import java.util.ArrayList;

public class GenericStack<E> extends ArrayList<E> {

	/** Return the element at the top of the stack */
	public E peek() {
		return get(size() - 1);
	}

	/** Push and element on to the stack */
	public void push(E o) {
		add(o);
	}

	/* Return and remove the element 
	 * on the top of the stack */
	public E pop() {
		E o = get(size() - 1);
		remove(size() - 1);
		return o;
	}

	@Override // Override the string method in the ArrayList class
	public String toString() {
		return "stack: " + super.toString();
	}
}