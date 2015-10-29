import java.util.*;

public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {
	@Override /** Override the protected clone 
		method defined in the Object class */
	public MyPriorityQueue<E> clone() throws CloneNotSupportedException {
		MyPriorityQueue<E> temp = new MyPriorityQueue<>();
		temp.addAll((MyPriorityQueue<E>)super.clone());
		return temp;
	}

}