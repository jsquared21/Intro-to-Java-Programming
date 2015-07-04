/**************************************
*            MyInteger                *
*-------------------------------------*
* +value: int                         *
* +MyInteger(value: int)              *
* +getValue(): int                    *
* +isEven(): boolean                  *
* +isOdd(): boolean                   *
* +isPrime(): boolean                 *
* +isEven(value: int): boolean        *
* ----------------------------        *
* +isOdd(value: int): boolean         *
* ---------------------------         *
* +isPrime(value: int): boolean       *
* -----------------------------       *
* +isEven(value: MyInteger): boolean  *
* ----------------------------------  *
* +isOdd(value: MyInteger): boolean   *
* ---------------------------------   *
* +isPrime(value: MyInteger): boolean *
* ----------------------------------- *
* +equals(value: int): boolean        *
* +equals(value: MyInteger): boolean  *
* +parseInt(chars: char[])            *
* -----------------------             *
* +parseInt(str: String)              *
* ---------------------               *
**************************************/
// Implement MyInteger class
public class MyInteger {
	private int value;

	MyInteger(int value) {
		this.value = value;
	}

	/** Return value */
	public int getValue() {
		return value;
	}

	/** Return true if value is even */
	public boolean isEven() {
		return isEven(value); 
	}

	/** Return true if value is odd */
	public boolean isOdd() {
		return isOdd(value); 
	}

	/** Return true if value is prime */
	public boolean isPrime() {
		return isPrime(value);
	}

	/** Return true if the specified value is even */
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}

	/** Return true if the specified value is odd */
	public static boolean isOdd(int value) {
		return value % 2 != 0;
	}

	/** Return true if specified value is prime */
	public static boolean isPrime(int value) {
		for (int divisor = 2; divisor <= value / 2; divisor++) {
			if (value % divisor == 0)
				return false;
		}
		return true;
	}

	/** Return true if the specified value is even */
	public static boolean isEven(MyInteger myInteger) {
		return myInteger.isEven();
	}

	/** Return true if the specified value is odd */
	public static boolean isOdd(MyInteger myInteger) {
		return myInteger.isOdd();
	}

	/** Return true if specified value is prime */
	public static boolean isPrime(MyInteger myInteger) {
		return myInteger.isPrime();
	}

	/** Return true is the value in this object 
	*   is equal to the specified value. */
	public boolean equals(int value) {
		return this.value == value;
	}

	/** Return true if the value in this object 
	*   is equal to the specified value */
	public boolean equals(MyInteger myInteger) {
		return myInteger.value == this.value;
	}

	/** converts an array of numeric
	*   characters to an int value */
	public static int parseInt(char[] chars) {
		int value = 0;
		for (int i = 0, j = (int)Math.pow(10, chars.length - 1); 
			  i < chars.length; i++, j /= 10) {
			value += (chars[i]- 48) * j;
		}
		return value;
	}

	/** Converts a string into an int value */
	public static int parseInt(String str) {
		int value = 0;
		for (int i = 0, j = (int)Math.pow(10, str.length() - 1); 
			  i < str.length(); i++, j /= 10) {
			value += (str.charAt(i) - 48) * j;
		}
		return value;
	}
}
