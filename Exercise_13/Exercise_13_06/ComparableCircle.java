/**************************************
*         ComparableCircle            *
*-------------------------------------*
* +ComparableCircle()                 *
* +ComparableCircle(radius: double)   *
* +ComparableCircle(radius: double,   *
*		color: String, filled: boolean) *
**************************************/

public class ComparableCircle extends Circle 
		implements Comparable<ComparableCircle> {

	public ComparableCircle() {
	}

	/** Construct a CoparableCircle with specified radius */
	public ComparableCircle(double radius) {
		super(radius);
	}

	/** Construct a CoparableCircle with specified properties */
	public ComparableCircle(double radius, String color, boolean filled) {
		super(radius, color, filled);
	}

	@Override // Implement the compareTo method defined in Comparable
	public int compareTo(ComparableCircle o) {
		if (getArea() > o.getArea())
			return 1;
		else if (getArea() < o.getArea())
			return -1;
		else
			return 0;
	}

	@Override // Implement the toString method defined in Circle
	public String toString() {
		return super.toString() + "\nArea: " + getArea();
	}
}