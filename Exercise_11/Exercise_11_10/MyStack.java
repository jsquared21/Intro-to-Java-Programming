/*****************************
*           MyStack          *
*----------------------------*
* -list: ArrayList<Object>   *
* +MyStack()                 *
* +peek(): Object            *
* +pop(): Object             *
* +push(o: Object): void     *
*****************************/
// Implement MyStack class
public class MyStack 
		extends java.util.ArrayList {
	// Data fields
	private java.util.ArrayList<Object> list;

	// Constructor
	/** Construct a default MyStack object */
	public MyStack() {
		list = new java.util.ArrayList<Object>();
	}

	/** Add a new element to 
	  * the top of this stack */
	public void push(Object o) {
		list.add(0, o);
	}

	/** Return the top element in this  
	  * stack without removing it */
	public Object peek() {
		return list.get(0);
	}

	/** Return an remove the 
	  * top element in this stack */
	public Object pop() {
		Object o = list.get(0);
		list.remove(0);
		return o;
	}

	/** Return a string of all elements in MyStack */
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
}
