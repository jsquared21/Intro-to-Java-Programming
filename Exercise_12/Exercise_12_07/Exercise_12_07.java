/*********************************************************************************
* (NumberFormatException) Write the bin2Dec(String binaryString) method to       *
* convert a binary string into a decimal number. Implement the bin2Dec method to *
* throw a NumberFormatException if the string is not a binary string.            *
*********************************************************************************/
public class Exercise_12_07 {
	public static int bin2Dec(String binaryString) throws NumberFormatException {
		int decimal = 0;
		for (int i = 0, j = binaryString.length() - 1; 
			i < binaryString.length(); i++, j--) {
			if (binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1')
				throw new NumberFormatException("The string is not a binary string");
			decimal += (Integer.parseInt(String.valueOf(binaryString.charAt(i)))) 
				* Math.pow(2, j);
		}
		return decimal;
	} 
}
	