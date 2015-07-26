// Implement HexFromatException class
public class HexFormatException extends NumberFormatException {
	private String hex; // Hex exception value

	/** Construct a HexFormatException object */
	public HexFormatException(String hex) {
		super(hex + " is not a hex string");
		this.hex = hex;
	} 

	/** Return hex exception value */
	public String getHex() {
		return hex;
	}
}