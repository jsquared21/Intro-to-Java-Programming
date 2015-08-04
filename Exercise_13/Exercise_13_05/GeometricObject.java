/**************************************************
*                GeometricObject                  *
*-------------------------------------------------*
* -color: String                                  *
* -filled: boolean                                *
* -dateCreated: java.util.Date                    *
*-------------------------------------------------*
* GeometricObject()                               *
* GeometricObject(color: String, filled: boolean) *
* +getColor(): String                             *
* +setColor(color: String): void                  *
* +isFilled(): boolean                            *
* +setFilled(filled: boolean): void               * 
* +getDateCreated(): java.util.Date               *
* +getMax(GeometricObject: o1,                    *
*  ---------------------------                    *
*		GeometricObject: o2): GeometricObject       *
*  	--------------------                        *
* +getArea(): double                              *
* +getPerimeter(): double                         *
**************************************************/

public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "while";
	private boolean filled;
	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}

	/** Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/** Return filled. Since filled is boolean,
	 *  the get method is named isFilled */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
			" and filled: " + filled;
	}

	@Override // Implement the compareTo method defined in Comparable
	public int compareTo(GeometricObject o) {
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		else
			return 0;
	}

	/** Abstract method getMax */
	public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
		return o1.compareTo(o2) == 1 ? o1 : o2;
	}

	/** Abstract method getArea */
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}