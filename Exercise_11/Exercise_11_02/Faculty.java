/**********************************************************
*                      Faculty                            *
*---------------------------------------------------------*
* -officeHours: int                                       *
* -rank: String                                           *
* +Faculty(name: String, address: String, phone: String,  *
*  email: String, office: int, salary: double,            *
*  officeHours: int, rank: String)     *
* +getOfficeHours(): int                                  *
* +setOfficeHours(officeHours: int): void                 *
* +getRank(): String                                      *
* +setRank(rank: String): void                            *
* +toString(): String                                     *
**********************************************************/

// Implement Faculty class
public class Faculty 
		extends Employee {
	// Data fields
	private String officeHours;
	private String rank;

	// Constructors
	/** Construct a Faculty object with specified name, address, phone number,
	  * email address, office, salary, office hours and rank */
	public Faculty(String name, String address, String phone, String email, 
		int office, double salary, String officeHours, String rank) {
		super(name, address, phone, email, office, salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	/** Return officeHours */
	public String getOfficeHours() {
		return officeHours;
	}

	/** Set new officeHours */
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	/** Return rank */
	public String getRank() {
		return rank;
	}

	/** Set new rank */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/** Return a string discription of the class */
	public String toString() {
		return super.toString() + "\nOffice hours: " + officeHours +
		"\nRank: " + rank;
	}
}