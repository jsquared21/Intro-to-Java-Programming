/**********************************************************************
*                           Triangle2D                                *
*---------------------------------------------------------------------*
* -p1: MyPoint                                                        *
* -p2: MyPoint                                                        *
* -p3: MyPoint                                                        *
* +Triangle2D()                                                       *
* +Triangle2D(p1: MyPoint, p2: MyPoint, p3: MyPoint)                  *
* +setP1(p1: MyPoint)                                                 *
* +setP2(p2: MyPoint)                                                 *
* +setP3(p3: MyPoint)                                                 *
* +getP1(): MyPoint                                                   *
* +getP2(): MyPoint                                                   *
* +getP3(): MyPoint                                                   *
* +getSignedArea(): double                                            *
* +getArea(): double                                                  *
* +getPerimeter(): double                                             *
* +contains(p: MyPoint): boolean                                      *
* +contains(t: Triangle2D): boolean                                   *
* +overlaps(t: Triangle2D): boolean                                   *
**********************************************************************/

// Implement Triangle2D class
public class Triangle2D {
	// Data fields
	private MyPoint p1;
	private MyPoint p2;
	private MyPoint p3;
	
	// Constructors
	/** Creates a default triangle with the points 
	 * (0,0), (1,1) and (2,5) */
	Triangle2D() {
		this(new MyPoint(0,0), new MyPoint(1,1), new MyPoint(2,5));
	}
	
	/** Creates a triangle with specified points p1, p2 and p3 */
	Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	// Methods
	/** Return point p1 */
	public MyPoint getP1() {
		return p1;
	}
	
	/** Return point p2 */
	public MyPoint getP2() {
		return p2;
	}
	
	/** Return point p3 */
	public MyPoint getP3() {
		return p3;
	}
	
	/** Set p1 to specified point */
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}
	
	/** Set p2 to specified point */
	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}
	
	/** Set p3 to specified point */
	public void setP3(MyPoint p3) {
		this.p3 = p3;
	}
	
	/** Returns the signed area of the triangle */
	public double getSignedArea() {
		return (p1.getX()*p2.getY() + p2.getX()*p3.getY() + p3.getX()*p1.getY() 
				- p3.getX()*p2.getY() - p2.getX()*p1.getY() - p1.getX()*p3.getY()) / 2;
	}
	
	/** Returns the area of the triangle */
	public double getArea() {
		return Math.abs(this.getSignedArea());
	}
	
	/** Returns the perimeter of the triangle */
	public double getPerimeter() {
		double side1 = p2.distance(p3);
		double side2 = p1.distance(p3);
		double side3 = p1.distance(p2);
		return side1 + side2 + side3;
	}
	
	/** Returns true if the specified point p is
	 * 	inside the triangle */
	public boolean contains(MyPoint p) {
		boolean a = new Triangle2D(p1,p2,p).getSignedArea() > 0; 
		boolean b = new Triangle2D(p2,p3,p).getSignedArea() > 0;
		boolean c = new Triangle2D(p3,p1,p).getSignedArea() > 0;
		return a == b && b == c;
	}
	
	/** Returns true if the specified triangle is
	 * inside this triangle */
	public boolean contains(Triangle2D t) {
		return 	this.contains(t.getP1()) &&
				this.contains(t.getP2()) &&
				this.contains(t.getP3());
	}
	
	/** Returns true if the specified triangle
	 * overlaps with this triangle */
	public boolean overlaps(Triangle2D t) {
		Segment s1 = new Segment(p2,p3);
		Segment s2 = new Segment(p1,p3);
		Segment s3 = new Segment(p1,p2);

		Segment q1 = new Segment(t.getP2(),t.getP3());
		Segment q2 = new Segment(t.getP1(),t.getP3());
		Segment q3 = new Segment(t.getP1(),t.getP2());
		
		return 	this.contains(t) || t.contains(this) ||
				s1.overlaps(q1) || s1.overlaps(q2) || s1.overlaps(q3) ||
				s2.overlaps(q1) || s2.overlaps(q2) || s2.overlaps(q3) ||
				s3.overlaps(q1) || s3.overlaps(q2) || s3.overlaps(q3);
	}
}
