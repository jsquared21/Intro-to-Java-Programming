public class StudentAddress implements java.io.Serializable {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;

	public StudentAddress(String name, String street, String city, 
		String state, String zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
}