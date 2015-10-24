public class Point implements Comparable<Point> {
	private double x;
	private double y;

	Point() {}

	// Construct a Point of x, y
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/** Set x to specified value */
	public void setX(double x) {
		this.x = x;
	}

	/** Set y to specified value */
	public void setY(double y) {
		this.y = y;
	}

	/** Return x */
	public double getX() {
		return x;
	}

	/** Return y */
	public double getY() {
		return y;
	}

	@Override // Override the compareTo method in the Comparable class
	public int compareTo(Point point) {
		if (x == point.getX()) {
			// If two points have the same x-coordinates,
			// compare their y-coordinates.
			if (y > point.getY())
				return 1;
			else if (y < point.getY())
				return -1;
			else
				return 0;
		}
		else if (x > point.getX())
			return 1;
		else
			return -1;
	}

	@Override // Override the toString method in the Object class
	public String toString() {
		return "(" + String.format("%.2f", x) + ", " 
			+ String.format("%.2f", y) + ")";
	}
}