/*****************************************
*                Person                  *
*----------------------------------------*
* -name: String                          *
* -address: String                       *
* -phone: String                         *
* -email: String                         *
* +Person()                              *
* +Person(name: String, address: String, *
*  phone: String, email: String)         *
* +getName(): String                     *
* +getAddress(): String                  *
* +getPhone(): String                    *
* +getEmail(): String                    *
* +setName(name: String ): void          *
* +setAddress(address: String): void     *
* +setPhone(phone: String): void         *
* +setEmail(email: String): void         *
* +toString(): String                    *
*****************************************/
// Implement Person class
public class Person {
	private String name;
	private String address;
	private String phone;
	private String email;

	/** Construct default Person object */
	public Person() {
		this("Unknown","Unknown","Unknown","Unknown");
	}

	/** Construct Person object with specified name, address, phone and email */
	public Person(String name, String address, String phone, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	} 

	/** Return name */
	public String getName() {
		return name;
	}

	/** Return address */
	public String getAddress() {
		return address;
	}

	/** Return phone */
	public String getPhone() {
		return phone;
	}

	/** Return email */
	public String getEmail() {
		return email;
	}

	/** Set new name */
	public void setName(String name) {
		this.name = name;
	}

	/** Set new address */
	public void setAddress(String address) {
		this.address = address;
	}

	/** Set new phone number */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** Set new email */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Return a string discription of the class */
	public String toString() {
		return "\nName: " + name + "\nAddress: " + address + 
				 "\nPhone number: " + phone + "\nEmail address: " + email;
	}
}