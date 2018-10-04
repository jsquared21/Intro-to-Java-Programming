/**********************************
*            MyPoint              *
*---------------------------------*
* -x: double                      *
* -y: double                      *
* +MyPoint()                      *
* +MyPoint(x: double, y: double)  *
* +getX(): double                 *
* +getY(): double                 *
* +distance(myPoint: MyPoint)     *
* +distance(x: double, y: double) *
**********************************/

// Implement MyPoint class
public class MyPoint {
	// Data fields
	private double x;
	private double y;

	/** Constructor that creates a point (0, 0) */
	MyPoint() {
		this(0, 0);
	}

	/** Constructs a point with specified coordinates */
	MyPoint(double x, double y) {
		this.x = x;
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

	/** Returns the distance from this point to 
   *   a specified point of the MyPoint type */
   public double distance(MyPoint myPoint) {
   	return Math.sqrt(Math.pow(myPoint.getX() - x, 2) + 
   			 Math.pow(myPoint.getY() - y, 2));
   }

   /** Returns the distance from this point to another
 	*   point with specified x- and y-coordinates. */
 	public double distance(double x, double y) {
 		return distance(new MyPoint(x, y));
 	}
}