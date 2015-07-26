/*********************************************************************************
* (HexFormatException) Exercise 12.6 implements the hex2Dec method to throw a    *
* NumberFormatException if the string is not a hex string. Define a custom       *
* exception called HexFormatException. Implement the hex2Dec method to throw a   *
* HexFormatException if the string is not a hex string.                          *
*********************************************************************************/
public class Exercise_12_09 {
	public static int bin2Dec(String binaryString) throws BinaryFormatException {
		int decimal = 0;
		for (int i = 0, j = binaryString.length() - 1; 
			i < binaryString.length(); i++, j--) {
			if (binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1')
				throw new BinaryFormatException(binaryString);
			decimal += (Integer.parseInt(String.valueOf(binaryString.charAt(i)))) 
				* Math.pow(2, j);
		}
		return decimal;
	} 
}
	