// Implement Segment class
public class Segment {
	// Data fields
	private MyPoint p1;
	private MyPoint p2;
	
	// Constructors
	/** Creates a default segment with end points
	 * 	(0,0) and (1,0) */
	public Segment() {
		this(new MyPoint(0,0), new MyPoint(1,0));
	}
	
	/** Creates a segment with the specified end points */
	public Segment(MyPoint p1, MyPoint p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/** Returns end point p1 */
	public MyPoint getP1() {
		return p1;
	}
	
	/** Returns end point p2 */
	public MyPoint getP2() {
		return p2;
	}
	
	/** Returns true if the specified segment overlaps
	 * 	with this segment */
	public boolean overlaps(Segment s) {
		MyPoint q1 = s.getP1();
		MyPoint q2 = s.getP2();
		
		return 	new Triangle2D(p1,p2,q1).getSignedArea()*new Triangle2D(p1,p2,q2).getSignedArea() < 0 &&
				new Triangle2D(q1,q2,p1).getSignedArea()*new Triangle2D(q1,q2,p2).getSignedArea() < 0;
	}
}
